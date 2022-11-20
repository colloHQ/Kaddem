package tn.esprit.Kaddem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Kaddem.entities.Etudiant;
import tn.esprit.Kaddem.services.IEtudiantService;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {
    @Autowired
    IEtudiantService iEtudiantService;

    @GetMapping("/getAllEtudiants")
    public List<Etudiant> getAllEtudiants() {
        return iEtudiantService.getAllEtudiant();
    }

    @PostMapping("/addEtudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        return iEtudiantService.addEtudiant(e);
    }

    @PutMapping("/updateEtudiant")
    @ResponseBody
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        return iEtudiantService.updateEtudiant(e);
    }

    @DeleteMapping("/deleteEtudiant/{id}")
    public void deleteEtudiant(@PathVariable("id") Long id) {
        iEtudiantService.deleteEtudiant(id);
    }

    @GetMapping("/getById/{id}")
    public Etudiant getEtudiantById(@PathVariable("id") Long id) {
        return iEtudiantService.getEtudiantById(id);
    }

    @GetMapping("/findByPrenom/{prenom}")
    public Etudiant findByPrenomE(@PathVariable("prenom") String prenomE) {
        return iEtudiantService.findByPrenomE(prenomE);
    }

}