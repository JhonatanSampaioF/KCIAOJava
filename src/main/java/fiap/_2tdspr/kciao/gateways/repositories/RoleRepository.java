package fiap._2tdspr.kciao.gateways.repositories;

import fiap._2tdspr.kciao.domains.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByName(String role);
}
