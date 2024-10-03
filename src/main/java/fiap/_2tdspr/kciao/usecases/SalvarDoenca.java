package fiap._2tdspr.kciao.usecases;

import fiap._2tdspr.kciao.domains.Doenca;
import org.springframework.stereotype.Service;

@Service
public interface SalvarDoenca {
    Doenca execute(Doenca doenca);
}
