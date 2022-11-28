package tn.esprit.kaddem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.entities.Departement;
import tn.esprit.kaddem.entities.Option;
import tn.esprit.kaddem.services.IDepartementServices;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/Departement")
@AllArgsConstructor
public class DepartementController {


    IDepartementServices departementServices;


    @GetMapping("/getById/{idDepart}")
    public Departement getDepartements(@PathVariable("idDepart") Integer idDepart) {
        return departementServices.getDepartementById(idDepart);
    }

    @GetMapping("/getAll")
    public List<Departement> getDepartementList() {
        return departementServices.getAllDepartements();
    }

    @PostMapping("/add")
    public Departement addDepartement(@RequestBody Departement d) {
        return departementServices.addDepartement(d);
    }

    @PutMapping("/update")
    public Departement updateDepartement(@RequestBody Departement d) {
        return departementServices.updateDepartement(d);
    }

    @DeleteMapping("/delete/{idDepart}")
    public void deleteDepartement(@PathVariable ("idDepart") Integer idDepart) {
        departementServices.deleteDepartement(idDepart);
    }

    @GetMapping("/getByEtudOpt/{opt}")
    public List<Departement> retrieveDepartementByOptionEtudiant(@PathVariable ("opt") Option opt) {
        return departementServices.retrieveDepartementByOptionEtudiant(opt);
    }

    @GetMapping("retrieveDepartementByUniversite/{idU}")
    public Set<Departement> retrieveDepartementByUniversite(@PathVariable("idU") Integer idUniversite){
        return departementServices.retrieveDepartementByUniversite(idUniversite);
    }
}
