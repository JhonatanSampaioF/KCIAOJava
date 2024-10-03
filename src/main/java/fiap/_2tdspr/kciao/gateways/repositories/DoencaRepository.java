package fiap._2tdspr.kciao.gateways.repositories;

import fiap._2tdspr.kciao.domains.Doenca;
import fiap._2tdspr.kciao.gateways.requests.DoencaRequestPatchNameDto;
import fiap._2tdspr.kciao.gateways.responses.DoencaResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DoencaRepository extends JpaRepository<Doenca,String> {

    Optional<Doenca> findById (String id_doenca);
    List<Doenca> findAll();
    void deleteById(String id_doenca);
//    Implementar custom query
//    Optional<Doenca> updateById(String id, DoencaRequestPatchNameDto doenca);
}
