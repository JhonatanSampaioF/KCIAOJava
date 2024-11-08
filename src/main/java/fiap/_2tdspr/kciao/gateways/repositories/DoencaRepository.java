package fiap._2tdspr.kciao.gateways.repositories;

import fiap._2tdspr.kciao.domains.Doenca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DoencaRepository extends JpaRepository<Doenca, Long> {

    @Modifying
    @Transactional
    @Query(value = "CALL insert_repositorio_doencas(:nome_doenca)", nativeQuery = true)
    void insertDoenca(String nome_doenca);

    @Modifying
    @Transactional
    @Query(value = "CALL update_repositorio_doenca(:id_doenca, :nome_doenca)", nativeQuery = true)
    void updateDoenca(Long id_doenca, String nome_doenca);

    @Modifying
    @Transactional
    @Query(value = "CALL delete_repositorio_doenca(:id_doenca)", nativeQuery = true)
    void deleteDoenca(Long id_doenca);
}
