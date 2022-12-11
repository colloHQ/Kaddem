package tn.esprit.kaddem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.entities.Entreprise;
import tn.esprit.kaddem.entities.Projet;
import tn.esprit.kaddem.entities.Review;
import tn.esprit.kaddem.services.EntrepriseServiceImp;

import java.util.List;

@RestController
@RequestMapping("/Entreprise")
@AllArgsConstructor
public class EntrepriseController {
    EntrepriseServiceImp entrepriseServiceImp;

    @GetMapping("/getAll")
    public List<Entreprise> getallEquipes() {
        return entrepriseServiceImp.getAllEntreprise();
    }

    @GetMapping("/getById/{idEntreprise}")
    public Entreprise getEquipe(@PathVariable("idEntreprise") Long idEntreprise) {
        return entrepriseServiceImp.getEntrepriseById(idEntreprise);
    }

    @PostMapping("/add")
    public Entreprise addEquipe(@RequestBody Entreprise e) {
        return entrepriseServiceImp.addEntreprise(e);
    }

    @PutMapping("/update")
    public Entreprise updateEquipe(@RequestBody Entreprise e) {
        return entrepriseServiceImp.updateEntreprise(e);
    }

    @DeleteMapping("/delete/{idEntreprise}")
    public void deleteEquipe(@PathVariable("idEntreprise") Long idEntreprise) {
        entrepriseServiceImp.deleteEntreprise(idEntreprise);
    }


    @PutMapping("/ReviewProjet/{idProjet}/{review}")
    public Projet reviewProjet(@PathVariable("idProjet") Long idProjet, @PathVariable("review") Review review) {
        return entrepriseServiceImp.reviewProjet(idProjet, review);
    }


    @GetMapping("/bestEntrepriseOfTheYear/{year}")
    public Entreprise getBestEntrepriseOfTheYear(@PathVariable("year") int y) {
        return entrepriseServiceImp.getBestEntrepriseOfTheYear(y);
    }

    /* Integration  */
}