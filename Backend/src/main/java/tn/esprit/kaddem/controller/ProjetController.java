package tn.esprit.kaddem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.entities.Etudiant;
import tn.esprit.kaddem.entities.Projet;
import tn.esprit.kaddem.services.ProjetServiceImp;

import java.util.List;

@RestController
@RequestMapping("/Projet")
@AllArgsConstructor
public class ProjetController {

    ProjetServiceImp projetServiceImp;
    @GetMapping("/getAll")
    public List<Projet> getAllEtudiant() {
        return projetServiceImp.getAllProjet();
    }

    @PostMapping("/add")
    public Projet addEtudiant(@RequestBody Projet p) {
        return projetServiceImp.addProjet(p);
    }

    @PutMapping("/update")
    public Projet updatEtudiant(@RequestBody Projet p) {
        return projetServiceImp.updateProjet(p);
    }

    @DeleteMapping("/delete/{idProjet}")
    void deleteETudiant(@PathVariable("idProjet") Long idProjet) {
        projetServiceImp.deleteProjet(idProjet);
    }

    @GetMapping("/getById/{idProjet}")
    public Projet getEtudiant(@PathVariable ("idProjet") Long idProjet) {
        return projetServiceImp.getProjet(idProjet);
    }

    @PostMapping("/addAndAssignProjetToEntreprise/{idEntreprise}")
    public Projet addAndAssignProjetToEntreprise(@RequestBody Projet p,@PathVariable("idEntreprise") Long idEntreprise){
        return projetServiceImp.addAndAssignProjetToEntreprise(p, idEntreprise);
    }

}