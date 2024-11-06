package fiap._2tdspr.kciao.gateways.repositories;

import fiap._2tdspr.kciao.domains.Cliente;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository {

    Optional<Cliente> findById (@NotEmpty @Valid String id);
    List<Cliente> findAll();
    void deleteById(@NotEmpty @Valid String id);
    @Modifying
    @Transactional
    @Query("UPDATE Cliente c SET c.nm_cliente = :name WHERE c.id_cliente = :id")
    int updateById_cliente(@Param("name") @Valid String name, @Param("id") @Valid String id);
    // Patch Lista Doencas
//    @Modifying
//    @Transactional
//    @Query("INSERT INTO Cliente c (c.nm_cliente) values (:name"))
//    int addDoencaToCliente(@Param("name") @Valid String name, @Param("id") @Valid String id);
//
//    @Modifying
//    @Transactional
//    @Query("UPDATE Cliente c SET c.nm_cliente = :name WHERE c.id_cliente = :id")
//    int deleteDoencaFromCliente(@Param("name") @Valid String name, @Param("id") @Valid String id);

}