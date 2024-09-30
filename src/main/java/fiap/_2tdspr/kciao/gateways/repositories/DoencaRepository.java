package fiap._2tdspr.kciao.gateways.repositories;

import fiap._2tdspr.kciao.domains.Doenca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoencaRepository extends JpaRepository<Doenca,String> {

    Doenca findDoencaById_doenca(String id_doenca);
    List<Doenca> findAllDoenca();
    Doenca updateDoencaById_doenca(String id, Doenca doenca);
    Doenca deleteDoencaById_doenca(String id_doenca);
}
