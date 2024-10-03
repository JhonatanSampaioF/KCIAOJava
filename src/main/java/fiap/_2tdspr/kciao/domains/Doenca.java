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
    private String nm_doenca;
    @ManyToMany
    private List<Cliente> cliente;
}
