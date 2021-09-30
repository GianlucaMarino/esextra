package it.esextra.controller;

import it.esextra.model.Brano;
import it.esextra.service.branoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping (path = "/BranoController")
public class BranoController {
    public final branoService branoService;

    @GetMapping
    ResponseEntity<List<Brano>> getAllVoli() {
        return ResponseEntity.ok().body(branoService.getAllBrani());
    }

    @PostMapping("/addBrano")
    ResponseEntity<Brano> saveBrano(@RequestBody Brano brano){
        branoService.saveBrano(brano);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/BranoController/" + brano.getBrano_id()).toUriString());

        log.info("Brano {}, {}, {} salvato all'interno del db raggiungibile al link {} ",brano.getCantante(), brano.getTitolo(),brano.getAlbum(), uri.toString());
        return ResponseEntity.created(uri).body(brano);
    }

    @GetMapping("/ricerca/getBraniDesc")
    ResponseEntity<List<Brano>> getBraniDESC() {
        return ResponseEntity.ok().body(branoService.getBranoDecrescente());
    }

    @GetMapping("/ricerca/getBraniASC")
    ResponseEntity<List<Brano>> getBraniASCAlfabetico() {
        return ResponseEntity.ok().body(branoService.getBranoOrdAlfabetico());
    }

    @GetMapping("ricerca/getBraniTitoloASC")
    ResponseEntity<List<Brano>> getBraniASCTitolo() {
        return ResponseEntity.ok().body(branoService.getBranoOrdCrescTitolo());
    }


}
