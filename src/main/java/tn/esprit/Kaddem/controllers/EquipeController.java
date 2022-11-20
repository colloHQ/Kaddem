package tn.esprit.Kaddem.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Kaddem.entities.Equipe;
import tn.esprit.Kaddem.services.IEquipeService;

import java.util.List;

@RestController
@RequestMapping("/equipes")
public class EquipeController {
    @Autowired
    IEquipeService ES;

    @GetMapping("/getAllEquipes")
    public List<Equipe> getAll() {
        return ES.retrieveAllEquipes();

    }

    @PostMapping("/addEquipe")
    public Equipe addEquipe(@RequestBody Equipe e) {
        return ES.addEquipe(e);
    }

    @PutMapping("/updateEquipe")
    public Equipe updateEquipe(@RequestBody Equipe e) {
        return ES.updateEquipe(e);
    }

    @DeleteMapping("/deleteEquipe/{idEquipe}")
    public void deleteEquipe(@PathVariable("idEquipe") int idEquipe) {
        ES.removeEquipe(idEquipe);
    }

    @GetMapping("/findByEtudiantIdEtudiant/{idEtudiant}")
    public List<Equipe> findEquipeByEtudiantsIdEtudiant(@PathVariable("idEtudiant") long idEtudiant) {
        return ES.findEquipeByEtudiantsIdEtudiant(idEtudiant);
    }


}