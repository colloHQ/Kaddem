package tn.esprit.kaddem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.entities.*;
import tn.esprit.kaddem.services.EntrepriseServiceImp;

import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @GetMapping("/PourcentageDeparticipationSelonSecteur/{secteur}")
    public String PourcentageDeparticipationSelonSecteur(@PathVariable("secteur") Secteur secteur){
        return entrepriseServiceImp.PourcentageDeparticipationSelonSecteur(secteur);
    }

    @GetMapping("EntrepriseWithNoProjets")
    List<Entreprise> findByProjetsIsNull(){
        return entrepriseServiceImp.findByProjetsIsNull();
    }

    @GetMapping("/GetAllEquipsOfAllEntreprises")
    public Map<String, Set<String>> GetAllEquipsOfAllEntreprises(){
        return entrepriseServiceImp.GetAllEquipsOfAllEntreprises();
    }
}