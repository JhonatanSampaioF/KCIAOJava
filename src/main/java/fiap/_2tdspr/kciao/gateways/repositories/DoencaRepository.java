package fiap._2tdspr.kciao.gateways.repositories;

import fiap._2tdspr.kciao.domains.Doenca;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DoencaRepository extends JpaRepository<Doenca,String> {

    Optional<Doenca> findById (@NotEmpty @Valid String id);
    List<Doenca> findAll();
//    Optional<Doenca> updateById(String id, DoencaRequestPutDto doenca);
    void deleteById(@NotEmpty @Valid String id);
    @Query("update Doenca set nm_doenca = :name where id_doenca = :id")
    int updateById_doenca(@Param("name") @Valid String name, @Param("id") @Valid String id);

}
