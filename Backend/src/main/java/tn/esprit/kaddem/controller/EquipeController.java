package tn.esprit.kaddem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.entities.Equipe;
import tn.esprit.kaddem.entities.Niveau;
import tn.esprit.kaddem.services.IEquipeServices;

import java.util.List;

@RestController
@RequestMapping("/Equipe")
@AllArgsConstructor
public class EquipeController {


    IEquipeServices equipeServices;

    @GetMapping("/getAll")
    public List<Equipe> getallEquipes() {
        return equipeServices.getAllEquipes();
    }

    @GetMapping("/getById/{idEquipe}")
    public Equipe getEquipe(@PathVariable ("idEquipe") Integer idEquipe) {
        return equipeServices.getEquipe(idEquipe);
    }

    @PostMapping("/add")
    public Equipe addEquipe(@RequestBody Equipe e) {
        return equipeServices.addEquipe(e);
    }

    @PutMapping("/update")
    public Equipe updateEquipe(@RequestBody Equipe e) {
        return equipeServices.updateEquipe(e);
    }

    @DeleteMapping("/delete/{idEquipe}")
    public void deleteEquipe(@PathVariable ("idEquipe") Integer idEquipe) {
        equipeServices.deleteEquipe(idEquipe);
    }

    @GetMapping("/findByThematique/{thematique}")
    public List<Equipe> findEquipeByDetailEquipeThematiqueLike(@PathVariable("thematique") String th) {
        return equipeServices.findEquipeByDetailEquipeThematiqueLike(th);
    }

    @GetMapping("/findByEtudiant/{idEtudiant}")
    public List<Equipe> findEquipeByEtudiantIdEtudiant(@PathVariable("idEtudiant") Long id) {
        return equipeServices.findEquipeByEtudiantsIdEtudiant(id);
    }

    @GetMapping("/findByThematiqueNotNull/{idE}")
    public List<Equipe> findByEtudiantIdEtudiantAndDetailEquipeThematiqueNotNull(@PathVariable("idE") Long idEtudiant) {
        return equipeServices.findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull(idEtudiant);
    }

    @GetMapping("/findByEtudiantAndDepart/{idE}/{idD}")
    public List<Equipe> findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepartement(@PathVariable("idE") Long idEtudiant, @PathVariable("idD") Integer idDepart) {
        return equipeServices.findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepartement(idEtudiant, idDepart);
    }

    @GetMapping("/findByNiveauAndThematique/{niv}/{th}")
    public List<Equipe> retriveEquipeByNiveauAndThematique(@PathVariable("niv") Niveau niveau, @PathVariable("th") String thematique) {
        return equipeServices.retriveEquipeByNiveauAndThematique(niveau, thematique);
    }


}
