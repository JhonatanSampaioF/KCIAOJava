package fiap._2tdspr.kciao.gateways.repositories;

import fiap._2tdspr.kciao.domains.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Modifying
    @Transactional
    @Query(value = "CALL insert_cliente(:nome_cliente)", nativeQuery = true)
    void insertCliente(String nome_cliente);

    @Modifying
    @Transactional
    @Query(value = "CALL update_cliente(:id_cliente, :nome_cliente)", nativeQuery = true)
    void updateCliente(Long id_cliente, String nome_cliente);

    @Modifying
    @Transactional
    @Query(value = "CALL delete_cliente(:id_cliente)", nativeQuery = true)
    void deleteCliente(Long id_cliente);
}
