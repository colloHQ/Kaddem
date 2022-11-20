package tn.esprit.Kaddem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Kaddem.entities.Contrat;
import tn.esprit.Kaddem.services.IContratService;

import java.util.List;

@RestController
@RequestMapping("/contrats")
public class ContratController {
    @Autowired
    IContratService CS;

    @GetMapping("/getAllContrats")

    public List<Contrat> getAll() {
        return CS.retrieveAllContrats();

    }

    @PostMapping("/addContrat")

    public Contrat addContrat(@RequestBody Contrat e) {
        return CS.addContrat(e);

    }

    @PostMapping("/assignEtudiantContract/{idEtudiant}/{idContrat}")

    public void assignEtudiantContrat(@PathVariable("idContrat") int idContrat, @PathVariable("idEtudiant") int idEtudiant) {
        CS.assignEtudiantToContrat(idEtudiant, idContrat);

    }

    @PutMapping("/updateContrat")

    public Contrat updateContrat(@RequestBody Contrat e) {

        return CS.updateContrat(e);

    }

    @DeleteMapping("/deleteContrat/{idContrat}")
    public void deleteContrat(@PathVariable("idContrat") int idContrat) {
        CS.removeContrat(idContrat);

    }

}