package tn.esprit.kaddem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.entities.Projet;
import tn.esprit.kaddem.services.ProjetServiceImp;

import java.util.List;

@RestController
@RequestMapping("/Projet")
@AllArgsConstructor
public class ProjetController {

    ProjetServiceImp projetServiceImp;

    @GetMapping("/getAll")
    public List<Projet> getAll() {
        return projetServiceImp.getAllProjet();
    }

    @PostMapping("/add")
    public Projet add(@RequestBody Projet p) {
        return projetServiceImp.addProjet(p);
    }

    @PutMapping("/update")
    public Projet updat(@RequestBody Projet p) {
        return projetServiceImp.updateProjet(p);
    }

    @DeleteMapping("/delete/{idProjet}")
    void delete(@PathVariable("idProjet") Long idProjet) {
        projetServiceImp.deleteProjet(idProjet);
    }

    @GetMapping("/getById/{idProjet}")
    public Projet getProjet(@PathVariable("idProjet") Long idProjet) {
        return projetServiceImp.getProjet(idProjet);
    }

    @PostMapping("/addAndAssignProjetToEquipeAndEntreprise/{idEquipe}/{idEntreprise}")
    public Projet addAndAssignProjetToEntreprise(@RequestBody Projet p, @PathVariable("idEquipe") int idEquipe, @PathVariable("idEntreprise") Long idEntreprise) {
        return projetServiceImp.addAndAssignProjetToEquipeAndEntreprise(p, idEquipe, idEntreprise);
    }

    @GetMapping("/getProjetOfyear/{year}")
    List<Projet> getProjetOfYear(@PathVariable("year") int y) {
        return projetServiceImp.getProjetOfYear(y);
    }

    @GetMapping("/getAllOrderByDateFinProjetAsc")
    public Projet getProjetOrdredBYDateFin() {
        return projetServiceImp.getProjetOrdredBYDateFin();
    }
}