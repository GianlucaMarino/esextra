package it.esextra.repository;

import it.esextra.model.Brano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranoRepository extends JpaRepository<Brano,Long> {
    @Query("select b from Brano b order by voto desc")
    List<Brano> findBranoDecrescente();
    @Query("select b from Brano b order by cantante asc")
    List<Brano> findBranoOrdAlfabetico();
    @Query("select b from Brano b order by titolo asc")
    List<Brano> findBranoOrdCrescTitolo();

    void deleteBycantanteAndtTitolo(String cantante, String titolo);

    Brano getById(Long branoid);
}
