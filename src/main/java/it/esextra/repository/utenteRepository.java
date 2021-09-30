package it.esextra.repository;

import it.esextra.model.Role;
import it.esextra.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.management.relation.Relation;
import java.util.List;

@Repository
public interface utenteRepository  extends JpaRepository<Utente,Long> {
    //Utente findUtenteByUsername(String username);
    @Query("select u from Utente u where u.username = ?0")
    Utente findUtenteByUsername(String username);

    Role findByNome(String roleName);

}
