package it.esextra.service;
import it.esextra.model.Role;
import it.esextra.model.Utente;
import it.esextra.repository.rolerepository;
import it.esextra.repository.utenteRepository;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class utenteServiceImpl implements utenteService, UserDetailsService {
    private final utenteRepository utenteRepository;
    private final rolerepository rolerepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utente utente = this.utenteRepository.findUtenteByUsername(username);
        if(utente == null) {
            log.error("Utente non trovato all'interno del db!");
            throw new UsernameNotFoundException("Utente non trovato all'interno del db!");
        } else {
            log.info("Utente richiesto trovato nel db: {}", username);
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            utente.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getNome()));
            });

            return new User(utente.getUsername(), utente.getPassword(), authorities);
        }
    }


    @Override
    public Utente saveUtente(Utente utente) {
        log.info("Salvataggio dell'utente {} all'interno del database", utente.getUsername());

        utente.getRoles().forEach(
                role -> {
                    String nome = role.getNome();
                    role.setId(rolerepository.findByNome(nome).getId());
                }
        );
        utente.setPassword(passwordEncoder.encode(utente.getPassword()));
        return this.utenteRepository.save(utente);
    }


    @Override
    public Role saveRole(Role role) {
        return this.rolerepository.save(role);
    }

    @Override
    public void aggiungiRuoloUt(String username, String roleName) {
        Utente utente = this.utenteRepository.findUtenteByUsername(username);
        Role role = this.utenteRepository.findByNome(roleName);
        log.info("Aggiungo il ruolo {} all'utente {}.",role.getNome(),utente.getUsername());
        utente.getRoles().add(role);

        this.utenteRepository.delete(utente.getId());
        this.utenteRepository.save(utente);

    }

    @Override
    public Utente getUtenteRuolo(String username) {
        this.utenteRepository.findUtenteByUsername(username).getRoles().forEach(
                ruolo -> { System.out.println(ruolo.getNome());}
        );
        return this.utenteRepository.findUtenteByUsername(username);
    }
    @Override
    public List<Utente> getUtenti() {
        return this.utenteRepository.findAll();
    }

    @Override
    public Utente getUtente(String username) {
        this.utenteRepository.findUtenteByUsername(username).getRoles().forEach(
                ruolo -> { System.out.println(ruolo.getNome());}
        );
        return this.utenteRepository.findUtenteByUsername(username);
    }


    @Override
    public void resetAll() {
        this.utenteRepository.deleteAll();
        this.rolerepository.deleteAll();
    }
}
