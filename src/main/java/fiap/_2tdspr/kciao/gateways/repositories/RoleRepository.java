package fiap._2tdspr.kciao.gateways.repositories;

import fiap._2tdspr.kciao.domains.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, String> {
    Role findByName(String role);
}
