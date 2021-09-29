package it.esextra.config;

import it.esextra.model.*;
import it.esextra.repository.*;
import it.esextra.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;


@Configuration
public class Config {
    @Bean
    CommandLineRunner commandLineRunner(BranoRepository branoRepository, rolerepository rolerepository, utenteRepository utenteRepository,utenteService utenteService, utenteServiceImpl utenteServiceImpl,
                                        branoService branoService, branoServiceImpl branoServiceImpl ) {
        return args -> {
            utenteService.resetAll();
            branoRepository.deleteAll();
            rolerepository.deleteAll();
            utenteRepository.deleteAll();

            utenteService.saveRole(new Role("ROLE_USER"));
            utenteService.saveRole(new Role("ROLE_ADMIN"));

            //inserimento dati dei brani
            Brano brano1 = new Brano("titolo1","cantante1","album1", 1995,9.3F);
            Brano brano2 = new Brano("titolo2","cantante2","album2", 1980,3.2F);
            Brano brano3 = new Brano("titolo3","cantante3","album3", 1965,5.1F);
            Brano brano4 = new Brano("titolo4","cantante4","album4", 2000,9.8F);
            Brano brano5 = new Brano("titolo5","cantante5","album5", 2001,1.7F);
            Brano brano6 = new Brano("titolo6","cantante6","album6", 1995,8.4F);
            Brano brano7 = new Brano("titolo7","cantante7","album7", 2005,7.6F);
            Brano brano8 = new Brano("titolo8","cantante8","album8", 2003,4.4F);
            Brano brano9 = new Brano("titolo9","cantante9","album9", 1980,6.5F);
            Brano brano10 = new Brano("titolo10","cantante10","album10", 1995,9.5F);


            //inserimento user
            utenteService.saveUtente(new Utente(null, "john.ring@mail.it", "john", new ArrayList<>(),"paperino"));
            utenteService.saveUtente(new Utente(null, "s.smith@mail.it", "will", new ArrayList<>(),"pippo"));
            utenteService.saveUtente(new Utente(null, "carry@mail.it", "jim", new ArrayList<>(),"minni"));
            utenteService.saveUtente(new Utente(null, "sanvito@mail.it", "vito", new ArrayList<>(),"inter"));


            //inserimento ruolo
            utenteService.aggiungiRuoloUt("john.ring@mail.it", "ROLE_USER");
            utenteService.aggiungiRuoloUt("s.smith@mail.it", "ROLE_USER");
            utenteService.aggiungiRuoloUt("carry@mail.it", "ROLE_ADMIN");
            utenteService.aggiungiRuoloUt("sanvito@mail.it", "ROLE_ADMIN");

            ArrayList<Brano> temp = new ArrayList<>();
            temp.add(brano1);
            temp.add(brano2);
            temp.add(brano3);
            temp.add(brano4);
            temp.add(brano5);
            temp.add(brano6);
            temp.add(brano7);
            temp.add(brano8);
            temp.add(brano9);
            temp.add(brano10);

            branoRepository.saveAll(temp);
        };

    }
}
