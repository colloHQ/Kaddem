package tn.esprit.Kaddem.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Kaddem.entities.Departement;
import tn.esprit.Kaddem.services.IDepartmentService;

import java.util.List;

@RestController
@RequestMapping("/departements")
public class DepartementController {
    @Autowired
    IDepartmentService DS;

    @GetMapping("/getAllDepartments")

    public List<Departement> getAll() {
        return DS.retrieveAllDepartements();

    }

    @PostMapping("/addDepartement")
    public Departement addDepartement(@RequestBody Departement e) {
        return DS.addDepartement(e);

    }

    @PutMapping("/updateDepartement")

    public Departement updateDepartement(@RequestBody Departement e) {

        return DS.updateDepartement(e);

    }

    @DeleteMapping("/deleteDepartement/{idDepartement}")
    public void deleteDepartement(@PathVariable("idDepartement") int idDepartement) {
        DS.removeDepartement(idDepartement);
    }

    @PostMapping("/assignEtudiantDepartement/{idEtudiant}/{idDepartement}")

    public void assignEtudiantContrat(@PathVariable("idDepartement") int idDepartement, @PathVariable("idEtudiant") int idEtudiant) {
        DS.assignEtudiantDepartement(idEtudiant, idDepartement);

    }
}