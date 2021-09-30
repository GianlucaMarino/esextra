package it.esextra.model;


import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
@Table
@Data
@Entity
@NoArgsConstructor
public class Brano {
  /*  @Id
    @SequenceGenerator(
            name = "brano_id",
            sequenceName = "brano_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "brano_sequence"
    )*/

  @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long brano_id;
    String titolo;
    String cantante;
    String album;
    Integer annoNascita;
    float voto;

    public Brano(String titolo, String cantante, String album, Integer annoNascita, float voto) {
        this.titolo = titolo;
        this.cantante = cantante;
        this.album = album;
        this.annoNascita = annoNascita;
        this.voto = voto;
    }
}

