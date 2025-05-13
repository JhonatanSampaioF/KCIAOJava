package fiap._2tdspr.kciao.gateways.repositories;

import fiap._2tdspr.kciao.domains.Cliente;
import fiap._2tdspr.kciao.domains.Evento;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ClienteRepository extends JpaRepository<Cliente, String> {
    @EntityGraph(attributePaths = "roles") // 👈 força carregar roles junto
    Optional<Cliente> findByEmail(String email);


    Optional<Cliente> findById (@NotEmpty @Valid String id);
    List<Cliente> findAll();
    void deleteById(@NotEmpty @Valid String id);
    @Modifying
    @Transactional
    @Query("UPDATE Cliente c SET c.nm_cliente = :name WHERE c.id_cliente = :id")
    int updateById_cliente(@Param("name") @Valid String name, @Param("id") @Valid String id);
    @Transactional
    @Query("SELECT e FROM Evento e where e.fk_cliente.id_cliente = :id")
    List<Evento> findAllEventobyId(@Param("id") @Valid String id);

    @Modifying
    @Transactional
    @Query(value = "BEGIN relatorio_eventos_consultas_cliente; END;", nativeQuery = true)
    void relatorioEventosConsultasCliente();

}
