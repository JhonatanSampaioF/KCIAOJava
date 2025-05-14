package fiap._2tdspr.kciao.usecases.impl;

import fiap._2tdspr.kciao.domains.Role;
import fiap._2tdspr.kciao.gateways.repositories.RoleRepository;
import fiap._2tdspr.kciao.usecases.interfaces.CrudRoles;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CrudRolesImpl implements CrudRoles {
    private final RoleRepository roleRepository;

    @Override
    public String save(String name) {
        Role role = Role.builder()
                .name(name)
                .build();

        roleRepository.save(role);

        return "Role saved successfully";
    }
}
