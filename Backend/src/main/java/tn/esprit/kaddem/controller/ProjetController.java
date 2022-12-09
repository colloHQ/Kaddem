package tn.esprit.kaddem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.entities.Projet;
import tn.esprit.kaddem.entities.projet;
import tn.esprit.kaddem.services.IProjetService;
import tn.esprit.kaddem.services.IprojetServices;
import tn.esprit.kaddem.services.ProjetService;

import java.util.List;

@RestController
@RequestMapping("/Projet")
@AllArgsConstructor
public class ProjetController {

    IProjetService projetService;

    @GetMapping("/getAll")
    public List<Projet> getAllProjet() {
        return ProjetService.getAllprojets();
    }

    @PostMapping("/add")
    public projet addprojet(@RequestBody projet u) {
        return projetServices.addprojet(u);
    }

    @PutMapping("/update")
    public projet updatprojet(@RequestBody projet u) {
        return projetServices.updateprojet(u);
    }

    @DeleteMapping("/delete/{idprojet}")
    void deleteprojet(@PathVariable ("idprojet") Integer idprojet) {
        projetServices.deleteprojet(idprojet);
    }

    @GetMapping("/getById/{idprojet}")
    public projet getprojet(@PathVariable ("idprojet") Integer idprojet) {
        return projetServices.getprojet(idprojet);
    }



}