package fiap._2tdspr.kciao.gateways.repositories;

import fiap._2tdspr.kciao.domains.Evento;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EventoRepository {
    Optional<Evento> findById (@NotEmpty @Valid String id);
    List<Evento> findAll();
    void deleteById(@NotEmpty @Valid String id);
    // Patch tipo
    @Modifying
    @Transactional
    @Query("UPDATE Evento e SET e.tipo_evento = :name WHERE e.id_evento = :id")
    int updateTipoById_evento(@Param("name") @Valid String name, @Param("id") @Valid String id);
    // Patch descricao
    @Modifying
    @Transactional
    @Query("UPDATE Evento e SET e.desc_evento = :name WHERE e.id_evento = :id")
    int updateDescricaoById_evento(@Param("name") @Valid String name, @Param("id") @Valid String id);
    // Patch data
    @Modifying
    @Transactional
    @Query("UPDATE Evento e SET e.dt_evento = :name WHERE e.id_evento = :id")
    int updateDataById_evento(@Param("name") @Valid String name, @Param("id") @Valid String id);
}
