package it.esextra.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UtenteRegistarzioneDTO {
    final String messaggio = "Campo richiesto!";

    @NotEmpty(message = messaggio)
    private String nome;

    @NotEmpty(message = messaggio)
    private String cognome;

    @NotEmpty(message = messaggio)
    private String password;

    @NotEmpty(message = messaggio)
    private String confermaPassword;

    @Email(message = "Formato email non corretto!")
    @NotEmpty(message = messaggio)
    private String email;

    @Email(message = "Formato email non corretto!")
    @NotEmpty(message = messaggio)
    private String confermaemail;
}
