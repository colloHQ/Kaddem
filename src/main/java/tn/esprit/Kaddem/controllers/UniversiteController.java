package tn.esprit.Kaddem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Kaddem.entities.Universite;
import tn.esprit.Kaddem.services.IUniversiteService;

import java.util.List;

@RestController
@RequestMapping("/universites")
public class UniversiteController {
    @Autowired
    IUniversiteService US;

    @GetMapping("/getAllUniversite")

    public List<Universite> getAll() {
        return US.retrieveAllUniversites();

    }

    @PostMapping("/addUniversite")

    public Universite addUniversite(@RequestBody Universite e) {
        return US.addUniversite(e);

    }

    @PutMapping("/updateUniversite")

    public Universite updateUniversite(@RequestBody Universite e) {

        return US.updateUniversite(e);

    }

    @DeleteMapping("/deleteUniversite/{idUniversite}")
    public void deleteUniversite(@PathVariable("idUniversite") int idUniversite) {
        US.removeUniversite(idUniversite);
    }

}