package tn.esprit.kaddem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.entities.Universite;
import tn.esprit.kaddem.services.IUniversiteServices;

import java.util.List;

@RestController
@RequestMapping("/Universite")
@AllArgsConstructor
public class UniversiteController {

    IUniversiteServices universiteServices;

    @GetMapping("/getAll")
    public List<Universite> getAllUniverite() {
        return universiteServices.getAllUniversites();
    }

    @PostMapping("/add")
    public Universite addUniversite(@RequestBody Universite u) {
        return universiteServices.addUniversite(u);
    }

    @PutMapping("/update")
    public Universite updatUniversite(@RequestBody Universite u) {
        return universiteServices.updateUniversite(u);
    }

    @DeleteMapping("/delete/{idUniversite}")
    void deleteUniversite(@PathVariable ("idUniversite") Integer idUniversite) {
        universiteServices.deleteUniversite(idUniversite);
    }

    @GetMapping("/getById/{idUniversite}")
    public Universite getUniversite(@PathVariable ("idUniversite") Integer idUniversite) {
        return universiteServices.getUniversite(idUniversite);
    }

    @PutMapping("/assignToDepartement/{idDepartement}/{idUniversite}")
    public void assignUniversiteToDepartement(@PathVariable("idDepartement") Integer idDepartement, @PathVariable("idUniversite") Integer idUniversite) {
        universiteServices.assignUniversiteToDepartement(idDepartement, idUniversite);
    }

}
