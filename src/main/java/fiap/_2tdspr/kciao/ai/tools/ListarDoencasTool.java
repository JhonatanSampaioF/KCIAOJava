package fiap._2tdspr.kciao.ai.tools;

import fiap._2tdspr.kciao.domains.Cliente;
import fiap._2tdspr.kciao.domains.Doenca;
import fiap._2tdspr.kciao.gateways.repositories.ClienteRepository;
import fiap._2tdspr.kciao.gateways.responses.doenca.DoencaResponseDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;
import org.springframework.ai.tool.annotation.Tool;


import java.util.List;

@Component
@RequiredArgsConstructor
public class ListarDoencasTool {

    private final ClienteRepository clienteRepository;

    @Tool(name = "ListarDoencas", description = "Lista as doenças de um cliente pelo ID")
    public List<DoencaResponseDto> getDoencas(
            @ToolParam(description = "idCliente") String idCliente
    ) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        System.out.println("Cliente doenças: " + cliente.getFk_doencas() != null ? cliente.getFk_doencas().get(0) : "");
        return cliente.getFk_doencas().stream().map(
                doenca -> DoencaResponseDto.builder()
                        .nm_doenca(doenca.getNm_doenca())
                        .build()
        ).toList();
    }
}