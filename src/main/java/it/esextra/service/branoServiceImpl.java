package it.esextra.service;

import it.esextra.model.Brano;
import it.esextra.repository.BranoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class branoServiceImpl implements branoService {
    private final BranoRepository branoRepository;

    @Override
    public List<Brano> getBranoDecrescente() {
        return branoRepository.findBranoDecrescente();
    }

    @Override
    public List<Brano> getBranoOrdAlfabetico() {
        return branoRepository.findBranoOrdAlfabetico();
    }

    @Override
    public List<Brano> getBranoOrdCrescTitolo() {
        return branoRepository.findBranoOrdCrescTitolo();
    }

    @Override
    public String  controllo(float voto) {
        if (voto >= 1 || voto <= 10) {
            return "non puoi inserire un voto minore di 1 ma solo maggiore di esso";
        } else {
            return "Voto registarto";
        }
    }

    @Override
    public void saveBrano(Brano brano) {
        branoRepository.save(brano);
    }

    @Override
    @Transactional
    public void updateBrano(Brano brano) {
        Brano temp = branoRepository.getById(brano.getBranoid());
    }

    @Override
    public void deleteBranoBycanatnteAndtitolo(String cantante, String titolo) {
        branoRepository.deleteBycantanteAndtTitolo(cantante, titolo);
    }

    @Override
    public List<Brano> getAllBrani() {
        return branoRepository.findAll();
    }
}
