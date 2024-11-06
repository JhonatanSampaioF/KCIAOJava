package fiap._2tdspr.kciao.gateways.repositories;

import fiap._2tdspr.kciao.domains.Evento;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public interface EventoRepository extends JpaRepository<Evento, String> {
    Optional<Evento> findById (@NotEmpty @Valid String id);
    List<Evento> findAll();
    void deleteById(@NotEmpty @Valid String id);
    // Patch tipo
    @Modifying
    @Transactional
    @Query("UPDATE Evento e SET e.tipo_evento = :tipo WHERE e.id_evento = :id")
    int updateTipoById_evento(@Param("tipo") @Valid String tipo, @Param("id") @Valid String id);
    // Patch descricao
    @Modifying
    @Transactional
    @Query("UPDATE Evento e SET e.desc_evento = :descricao WHERE e.id_evento = :id")
    int updateDescricaoById_evento(@Param("descricao") @Valid String descricao, @Param("id") @Valid String id);
    // Patch data
    @Modifying
    @Transactional
    @Query("UPDATE Evento e SET e.dt_evento = :data WHERE e.id_evento = :id")
    int updateDataById_evento(@Param("data") @Valid Date data, @Param("id") @Valid String id);
}
