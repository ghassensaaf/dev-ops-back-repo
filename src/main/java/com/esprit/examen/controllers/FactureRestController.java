package com.esprit.examen.controllers;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.esprit.examen.entities.Facture;
import com.esprit.examen.services.IFactureService;
import com.esprit.examen.dto.FactureDTO;
import org.modelmapper.ModelMapper;
import io.swagger.annotations.Api;


@RestController
@Api(tags = "Gestion des factures")
@RequestMapping("/v4/facture")
@CrossOrigin("*")
@RequiredArgsConstructor
public class FactureRestController {

    private final IFactureService factureService;
    private final ModelMapper mapper ;

    @GetMapping("/retrieve-all-factures")
    @ResponseBody
    public List<Facture> getFactures() {
        return factureService.retrieveAllFactures();
    }

    @GetMapping("/retrieve-facture/{facture-id}")
    @ResponseBody
    public Facture retrieveFacture(@PathVariable("facture-id") Long factureId) {
        return factureService.retrieveFacture(factureId);
    }

    @PostMapping("/add-facture")
    @ResponseBody
    public Facture addFacture(@RequestBody FactureDTO f) {
        Facture fa = mapper.map(f,Facture.class);
        return factureService.addFacture(fa);
    }

    @PutMapping("/cancel-facture/{facture-id}")
    @ResponseBody
    public void cancelFacture(@PathVariable("facture-id") Long factureId) {
        factureService.cancelFacture(factureId);
    }


}
