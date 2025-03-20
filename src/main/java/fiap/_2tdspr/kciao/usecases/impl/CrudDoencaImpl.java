package fiap._2tdspr.kciao.usecases.impl;

import fiap._2tdspr.kciao.domains.Doenca;
import fiap._2tdspr.kciao.gateways.controllers.impl.DoencaControllerImpl;
import fiap._2tdspr.kciao.gateways.repositories.DoencaRepository;
import fiap._2tdspr.kciao.gateways.requests.doenca.DoencaRequestDto;
import fiap._2tdspr.kciao.gateways.responses.doenca.DoencaResponseDto;
import fiap._2tdspr.kciao.usecases.interfaces.CrudDoenca;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@RequiredArgsConstructor
public class CrudDoencaImpl implements CrudDoenca {
    private final DoencaRepository doencaRepository;
    @Override
    public DoencaResponseDto save(DoencaRequestDto doencaRequestDto) {

        Doenca doencaASerCriada = Doenca.builder()
            .nm_doenca(doencaRequestDto.getNm_doenca())
            .build();

        Doenca doencaSalva = doencaRepository.save(doencaASerCriada);

        DoencaResponseDto doencaResponse = DoencaResponseDto.builder()
            .id_doenca(doencaSalva.getId_doenca())
            .nm_doenca(doencaSalva.getNm_doenca())
            .build();

        doencaResponse.add(
                linkTo(
                        methodOn(DoencaControllerImpl.class)
                                .getDoenca(doencaSalva.getId_doenca().toString())
                ).withSelfRel()
        );

        return doencaResponse;
    }

    @Override
    public DoencaResponseDto getOne(String id) {
        Doenca doenca = doencaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Doenca not found"));

        return DoencaResponseDto.builder()
                .id_doenca(doenca.getId_doenca())
                .nm_doenca(doenca.getNm_doenca())
                .build();
    }

    @Override
    public List<DoencaResponseDto> getAll() {
        List<Doenca> listDoenca = doencaRepository.findAll();
        return listDoenca.stream()
            .map(doenca -> DoencaResponseDto.builder()
                .id_doenca(doenca.getId_doenca())
                .nm_doenca(doenca.getNm_doenca())
                .build()).toList();
    }

    @Override
    public DoencaResponseDto update(String id, DoencaRequestDto doencaRequestDto) {

        Doenca doenca = doencaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Doenca not found"));

        doenca.setNm_doenca(doencaRequestDto.getNm_doenca() != null ? doencaRequestDto.getNm_doenca() : doenca.getNm_doenca());

        Doenca doencaSalva = doencaRepository.save(doenca);

        return DoencaResponseDto.builder()
                .id_doenca(doencaSalva.getId_doenca())
                .nm_doenca(doencaSalva.getNm_doenca())
                .build();
    }

    @Override
    public void delete(String id) {
        doencaRepository.deleteById(id);
    }
}
