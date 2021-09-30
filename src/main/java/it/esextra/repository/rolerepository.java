package it.esextra.repository;

import it.esextra.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface rolerepository extends JpaRepository<Role,Long> {
    Role findByNome(String nome);
}
