package fiap._2tdspr.kciao.domains;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Doenca {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id_doenca;
    @Column(unique = true)
    private String nm_doenca;
    @ManyToMany
    private List<Cliente> fk_cliente;
}
