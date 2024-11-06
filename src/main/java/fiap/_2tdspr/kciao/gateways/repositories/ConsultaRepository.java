package fiap._2tdspr.kciao.gateways.repositories;

import fiap._2tdspr.kciao.domains.Consulta;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ConsultaRepository extends JpaRepository<Consulta, String> {
    Optional<Consulta> findById (@NotEmpty @Valid String id);
    List<Consulta> findAll();
    void deleteById(@NotEmpty @Valid String id);
    // Patch profissional
    @Modifying
    @Transactional
    @Query("UPDATE Consulta c SET c.profissional = :profissional WHERE c.id_consulta = :id")
    int updateProfissionalById_consulta(@Param("profissional") @Valid String profissional, @Param("id") @Valid String id);
    // Patch local consulta
    @Modifying
    @Transactional
    @Query("UPDATE Consulta c SET c.local_consulta = :local_consulta WHERE c.id_consulta = :id")
    int updateLocalById_consulta(@Param("local_consulta") @Valid String local_consulta, @Param("id") @Valid String id);
    // Patch horario consulta
    @Modifying
    @Transactional
    @Query("UPDATE Consulta c SET c.horario_consulta = :horario_consulta WHERE c.id_consulta = :id")
    int updateHorarioById_consulta(@Param("horario_consulta") @Valid Integer horario_consulta, @Param("id") @Valid String id);
}
