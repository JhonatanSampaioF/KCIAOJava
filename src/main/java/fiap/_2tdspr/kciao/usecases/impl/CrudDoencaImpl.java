package fiap._2tdspr.kciao.usecases.impl;

import fiap._2tdspr.kciao.domains.Doenca;
import fiap._2tdspr.kciao.gateways.controllers.impl.DoencaControllerImpl;
import fiap._2tdspr.kciao.gateways.repositories.DoencaRepository;
import fiap._2tdspr.kciao.gateways.requests.doenca.DoencaRequestDto;
import fiap._2tdspr.kciao.gateways.responses.doenca.DoencaResponseDto;
import fiap._2tdspr.kciao.usecases.interfaces.CrudDoenca;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@RequiredArgsConstructor
public class CrudDoencaImpl implements CrudDoenca {
    private final DoencaRepository doencaRepository;
    @Override
    public void save(DoencaRequestDto doencaRequestDto) {

        Doenca doencaASerCriada = Doenca.builder()
            .nm_doenca(doencaRequestDto.getNm_doenca())
            .build();

        doencaRepository.save(doencaASerCriada);
    }

    @Override
    public void update(Long id, DoencaRequestDto doencaRequestDto) {

        Doenca doencaASerAtualizada = Doenca.builder()
            .nm_doenca(doencaRequestDto.getNm_doenca())
            .build();

        doencaRepository.updateDoenca(
            id,
            doencaASerAtualizada.getNm_doenca()
        );
    }

    @Override
    public void delete(Long id) {
        doencaRepository.deleteDoenca(id);
    }
}
