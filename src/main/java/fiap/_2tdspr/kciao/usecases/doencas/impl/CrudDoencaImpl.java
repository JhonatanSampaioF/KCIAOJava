package fiap._2tdspr.kciao.usecases.doencas.impl;

import fiap._2tdspr.kciao.domains.Doenca;
import fiap._2tdspr.kciao.gateways.repositories.DoencaRepository;
import fiap._2tdspr.kciao.gateways.requests.DoencaRequestPostDto;
import fiap._2tdspr.kciao.gateways.requests.DoencaRequestPatchDto;
import fiap._2tdspr.kciao.gateways.responses.DoencaResponseDto;
import fiap._2tdspr.kciao.usecases.doencas.interfaces.CrudDoenca;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CrudDoencaImpl implements CrudDoenca {
    private final DoencaRepository doencaRepository;
    @Override
    public DoencaResponseDto save(DoencaRequestPostDto doencaRequestPostDto) {

        Doenca doencaASerCriada = Doenca.builder()
            .nm_doenca(doencaRequestPostDto.getNm_doenca())
            .build();

        Doenca doencaSalva = doencaRepository.save(doencaASerCriada);


        DoencaResponseDto doencaResponseDto = DoencaResponseDto.builder()
            .nm_doenca(doencaSalva.getNm_doenca())
            .build();

        return doencaResponseDto;
    }

    @Override
    public Optional<DoencaResponseDto> getOne(String id) {
        Optional<Doenca> doenca = doencaRepository.findById(id);

        if(doenca.isPresent()) {
            DoencaResponseDto doencaResponseDto = DoencaResponseDto.builder()
                .nm_doenca(doenca.get().getNm_doenca())
                .build();
            return Optional.of(doencaResponseDto);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<DoencaResponseDto> getAll() {
        List<Doenca> listDoenca = doencaRepository.findAll();
        List<DoencaResponseDto> listDoencaResponse = listDoenca.stream()
            .map(doenca -> DoencaResponseDto.builder()
                .nm_doenca(doenca.getNm_doenca())
                .build()).toList();
        return listDoencaResponse;
    }

    @Override
    public Optional<DoencaResponseDto> update(String id, DoencaRequestPatchDto doencaRequestPatchDto) {

        Doenca doencaASerAtualizada = Doenca.builder()
            .nm_doenca(doencaRequestPatchDto.getNm_doenca())
            .build();

        int doencaAtualizada = doencaRepository.updateById_doenca(
            doencaASerAtualizada.getNm_doenca(),
            id
        );

        if(doencaAtualizada != 0){
            Optional<DoencaResponseDto> doencaAtualizadaResponse = getOne(id);
            if(doencaAtualizadaResponse.isPresent()) {
                DoencaResponseDto doencaResponseDto = DoencaResponseDto.builder()
                    .nm_doenca(doencaAtualizadaResponse.get().getNm_doenca())
                    .build();
                return Optional.ofNullable(doencaResponseDto);
            }
            return Optional.empty();
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void delete(String id) {
        doencaRepository.deleteById(id);
    }
}
