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

    @PostMapping("/add/{idEntreprise}")
    public Projet add(@RequestBody Projet p,@PathVariable("idEntreprise") long idEntreprise) {
        return projetServiceImp.addProjet(p,idEntreprise);
    }

    @PutMapping("/update/{idEquipe}")
    public Projet updat(@RequestBody Projet p,@PathVariable("idEquipe") int idEquipe) {
        return projetServiceImp.updateProjet(p,idEquipe);
    }
    @PutMapping("/ToFinished")
    public Projet statusToFinished(@RequestBody Projet p){
        return projetServiceImp.statusToFinished(p);
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
    public Projet addAndAssignProjetToEntreprise(@RequestBody Projet p, @PathVariable("idEquipe") int idEquipe ) {
        return projetServiceImp.addAndAssignProjetToEquipe(p, idEquipe);
    }

    @GetMapping("/getProjetOfyear/{year}")
    List<Projet> getProjetOfYear(@PathVariable("year") int y) {
        return projetServiceImp.getProjetOfYear(y);
    }

    @GetMapping("/getAllOrderByDateFinProjetAsc")
    public List<Projet> getProjetOrdredBYDateFin() {
        return projetServiceImp.getProjetOrdredBYDateFin();
    }
    @GetMapping("/getprixparEntreprise/{idEntreprise}")
    public double getset(@PathVariable("idEntreprise") Long idEntreprise) {
        return projetServiceImp.getPrixParEntreprise(idEntreprise);
    }
    @GetMapping("/getprixparEntreprise")
    public List<Object> getmapPrixForEntreprise() {
        return projetServiceImp.getmapPrixForEntreprise();
    }
    @GetMapping("/majorationProjet")
    public void majorationProjet(){projetServiceImp.majorationProjet();}
}