package it.esextra.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utente {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String username;
    String nome;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<Role>();
    String password;


}
