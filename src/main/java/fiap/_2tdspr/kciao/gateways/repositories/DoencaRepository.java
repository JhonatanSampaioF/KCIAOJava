package fiap._2tdspr.kciao.gateways.repositories;

import fiap._2tdspr.kciao.domains.Doenca;
import fiap._2tdspr.kciao.gateways.responses.DoencaResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DoencaRepository extends JpaRepository<Doenca,String> {

    Optional<Doenca> findById (String id_doenca);
//    List<Doenca> findAllDoenca();
//    Doenca updateDoencaById_doenca(String id, Doenca doenca);
//    Doenca deleteDoencaById_doenca(String id_doenca);
}
