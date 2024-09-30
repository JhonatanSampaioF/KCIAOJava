package fiap._2tdspr.kciao.usecases.impl;

import fiap._2tdspr.kciao.domains.Doenca;
import fiap._2tdspr.kciao.gateways.repositories.DoencaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalvarDoenca implements fiap._2tdspr.kciao.usecases.SalvarDoenca {

    private final DoencaRepository doencaRepository;

    @Override
    public Doenca execute(Doenca doencaASerSalva) {
        return  doencaRepository.save(doencaASerSalva);
    }
}
