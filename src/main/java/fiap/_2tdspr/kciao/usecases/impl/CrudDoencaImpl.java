package fiap._2tdspr.kciao.usecases.impl;

import fiap._2tdspr.kciao.domains.Doenca;
import fiap._2tdspr.kciao.gateways.repositories.DoencaRepository;
import fiap._2tdspr.kciao.gateways.requests.doenca.DoencaRequestDto;
import fiap._2tdspr.kciao.gateways.responses.doenca.DoencaResponseDto;
import fiap._2tdspr.kciao.usecases.interfaces.CrudDoenca;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
            .nm_doenca(doencaSalva.getNm_doenca())
            .build();

        return doencaResponse;
    }

    @Override
    public Optional<DoencaResponseDto> getOne(String id) {
        Optional<Doenca> doenca = doencaRepository.findById(id);

        if(doenca.isPresent()) {
            DoencaResponseDto doencaResponse = DoencaResponseDto.builder()
                .nm_doenca(doenca.get().getNm_doenca())
                .build();
            return Optional.of(doencaResponse);
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
    public Optional<DoencaResponseDto> update(String id, DoencaRequestDto doencaRequestDto) {

        Doenca doencaASerAtualizada = Doenca.builder()
            .nm_doenca(doencaRequestDto.getNm_doenca())
            .build();

        int doencaAtualizada = doencaRepository.updateById_doenca(
            doencaASerAtualizada.getNm_doenca(),
            id
        );

        if(doencaAtualizada != 0){
            Optional<DoencaResponseDto> doencaAtualizadaResponse = getOne(id);
            if(doencaAtualizadaResponse.isPresent()) {
                DoencaResponseDto doencaResponse = DoencaResponseDto.builder()
                    .nm_doenca(doencaAtualizadaResponse.get().getNm_doenca())
                    .build();
                return Optional.ofNullable(doencaResponse);
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