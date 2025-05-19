package fiap._2tdspr.kciao.usecases.impl;

import fiap._2tdspr.kciao.domains.Cliente;
import fiap._2tdspr.kciao.domains.Doenca;
import fiap._2tdspr.kciao.domains.Evento;
import fiap._2tdspr.kciao.domains.Role;
import fiap._2tdspr.kciao.gateways.controllers.interfaces.ClienteController;
import fiap._2tdspr.kciao.gateways.repositories.ClienteRepository;
import fiap._2tdspr.kciao.gateways.repositories.DoencaRepository;
import fiap._2tdspr.kciao.gateways.repositories.EventoRepository;
import fiap._2tdspr.kciao.gateways.repositories.RoleRepository;
import fiap._2tdspr.kciao.gateways.requests.cliente.ClienteRequestDto;
import fiap._2tdspr.kciao.gateways.responses.cliente.ClienteResponseDto;
import fiap._2tdspr.kciao.gateways.responses.evento.EventoResponseDto;
import fiap._2tdspr.kciao.usecases.interfaces.CrudCliente;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@RequiredArgsConstructor
public class CrudClienteImpl implements CrudCliente {
    private final ClienteRepository clienteRepository;
    private final DoencaRepository doencaRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final EventoRepository eventoRepository;

    @Override
    public ClienteResponseDto save(ClienteRequestDto clienteRequestDto) {
        List<Doenca> doencas = new ArrayList<>();

        if (clienteRequestDto.getDoencas() != null && !clienteRequestDto.getDoencas().isEmpty()) {
            doencas = doencaRepository.findAllById(clienteRequestDto.getDoencas());
        }

        Role role = roleRepository.findByName(clienteRequestDto.getRole());

        if (role == null) {
            throw new EntityNotFoundException("Role not found: " + clienteRequestDto.getRole());
        }

        Cliente clienteASerCriado = Cliente.builder()
                .nm_cliente(clienteRequestDto.getNm_cliente())
                .fk_doencas(doencas)
                .email(clienteRequestDto.getEmail())
                .roles(Set.of(role))
                .password(passwordEncoder.encode(clienteRequestDto.getPassword()))
                .build();

        Cliente clienteSalvo = clienteRepository.save(clienteASerCriado);

        ClienteResponseDto clienteResponse = ClienteResponseDto.builder()
                .id_cliente(clienteSalvo.getId())
                .nm_cliente(clienteSalvo.getNm_cliente())
                .email(clienteASerCriado.getEmail())
                .nm_doencas(clienteSalvo.getFk_doencas() != null ?
                        clienteSalvo.getFk_doencas().stream()
                                .map(Doenca::getNm_doenca)
                                .collect(Collectors.toList())
                        : List.of())
                .build();

        clienteResponse.add(
                linkTo(
                        methodOn(ClienteController.class)
                                .getCliente(clienteSalvo.getId().toString())
                ).withSelfRel()
        );

        return clienteResponse;
    }

    @Override
    public ClienteResponseDto getOne(String id) {

        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Client not found"));

        List<String> doencasIds = cliente.getFk_doencas().stream()
                .map(Doenca::getId_doenca)
                .collect(Collectors.toList());

        return ClienteResponseDto.builder()
                .id_cliente(cliente.getId())
                .nm_cliente(cliente.getNm_cliente())
                .email(cliente.getEmail())
                .doencas(doencasIds) // Lista de IDs
                .nm_doencas(cliente.getFk_doencas().stream()
                        .map(Doenca::getNm_doenca)
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public List<ClienteResponseDto> getAll() {
        List<Cliente> listCliente = clienteRepository.findAll();
        return listCliente.stream()
                .map(cliente -> ClienteResponseDto.builder()
                        .id_cliente(cliente.getId())
                        .nm_cliente(cliente.getNm_cliente())
                        .email(cliente.getEmail())
                        .nm_doencas(cliente.getFk_doencas() != null ?
                                cliente.getFk_doencas().stream()
                                        .map(Doenca::getNm_doenca)
                                        .collect(Collectors.toList())
                                : List.of())
                        .build()).toList();
    }

    @Override
    public ClienteResponseDto update(String id, ClienteRequestDto clienteRequestDto) {
        List<Doenca> doencas = new ArrayList<>();
        if (clienteRequestDto.getDoencas() != null && !clienteRequestDto.getDoencas().isEmpty()) {
            doencas = doencaRepository.findAllById(clienteRequestDto.getDoencas());
        }

        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Client not found"));

        cliente.setNm_cliente(clienteRequestDto.getNm_cliente());
        cliente.setFk_doencas(doencas);
        cliente.setEmail(clienteRequestDto.getEmail());
        cliente.setPassword(passwordEncoder.encode(clienteRequestDto.getPassword()));

        Cliente updatedClient = clienteRepository.save(cliente);

        return ClienteResponseDto.builder()
                .id_cliente(updatedClient.getId())
                .nm_cliente(updatedClient.getNm_cliente())
                .email(updatedClient.getEmail())
                .nm_doencas(cliente.getFk_doencas() != null ?
                        cliente.getFk_doencas().stream()
                                .map(Doenca::getNm_doenca)
                                .collect(Collectors.toList())
                        : List.of())
                .build();
}

    @Override
    public void delete(String id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public List<EventoResponseDto> getAllEventos(String id) {
        List<Evento> listEvento = eventoRepository.findAllByCliente_Id(id);
        return listEvento.stream()
                .map(evento -> EventoResponseDto.builder()
                        .id_evento(evento.getId_evento())
                        .tipo_evento(evento.getTipo_evento())
                        .desc_evento(evento.getDesc_evento())
                        .dt_evento(evento.getDt_evento())
                        .build()).toList();
    }

    @Override
    public ClienteResponseDto addDoenca(String idCliente, String idDoenca) {
        Doenca newDoenca = doencaRepository.findById(idDoenca)
                .orElseThrow(() -> new EntityNotFoundException("Doença não encontrada"));

        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        List<Doenca> doencaList = cliente.getFk_doencas();

        doencaList.add(newDoenca);

        cliente.setFk_doencas(doencaList);

        Cliente savedCliente = clienteRepository.save(cliente);

        return ClienteResponseDto.builder()
                .id_cliente(savedCliente.getId())
                .nm_cliente(savedCliente.getNm_cliente())
                .doencas(savedCliente.getFk_doencas()
                        .stream()
                        .map(Doenca::getId_doenca)
                        .toList())
                .build();
    }

    @Override
    public ClienteResponseDto removeDoenca(String idCliente, String idDoenca) {
        Doenca newDoenca = doencaRepository.findById(idDoenca)
                .orElseThrow(() -> new EntityNotFoundException("Doença não encontrada"));

        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        List<Doenca> doencaList = cliente.getFk_doencas();

        doencaList.remove(newDoenca);

        cliente.setFk_doencas(doencaList);

        Cliente savedCliente = clienteRepository.save(cliente);

        return ClienteResponseDto.builder()
                .id_cliente(savedCliente.getId())
                .nm_cliente(savedCliente.getNm_cliente())
                .doencas(savedCliente.getFk_doencas()
                        .stream()
                        .map(Doenca::getId_doenca)
                        .toList())
                .build();
    }

    @Override
    public String fillForm(String idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new EntityNotFoundException("Cliente not found"));

        cliente.setForm(true);

        clienteRepository.save(cliente);
        return "Client form updated successfully";
    }
}
