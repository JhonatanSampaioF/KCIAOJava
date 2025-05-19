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
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ClienteRepository extends MongoRepository<Cliente, String> {
    @EntityGraph(attributePaths = "roles") // 👈 força carregar roles junto
    Optional<Cliente> findByEmail(String email);
}
