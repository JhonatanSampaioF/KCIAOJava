package fiap._2tdspr.kciao.gateways.repositories;

import fiap._2tdspr.kciao.domains.Consulta;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ConsultaRepository {
    Optional<Consulta> findById (@NotEmpty @Valid String id);
    List<Consulta> findAll();
    void deleteById(@NotEmpty @Valid String id);
    // Patch profissional
    @Modifying
    @Transactional
    @Query("UPDATE Consulta c SET c.profissional = :name WHERE c.id_consulta = :id")
    int updateProfissionalById_consulta(@Param("name") @Valid String name, @Param("id") @Valid String id);
    // Patch local consulta
    @Modifying
    @Transactional
    @Query("UPDATE Consulta c SET c.local_consulta = :name WHERE c.id_consulta = :id")
    int updateLocalById_consulta(@Param("name") @Valid String name, @Param("id") @Valid String id);
    // Patch horario consulta
    @Modifying
    @Transactional
    @Query("UPDATE Consulta c SET c.horario_consulta = :name WHERE c.id_consulta = :id")
    int updateHorarioById_consulta(@Param("name") @Valid String name, @Param("id") @Valid String id);
}
