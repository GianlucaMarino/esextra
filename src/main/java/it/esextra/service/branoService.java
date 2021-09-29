package it.esextra.service;

import it.esextra.model.Brano;


import java.util.List;

public interface branoService {

    List<Brano> getBranoDecrescente();
    List<Brano> getBranoOrdAlfabetico();
    List<Brano> getBranoOrdCrescTitolo();

    String  controllo(float voto);
    void saveBrano(Brano brano);
    void updateBrano(Brano brano);
    void deleteBranoBycanatnteAndtitolo(String cantante, String titolo);

   List<Brano>  getAllBrani();
}
