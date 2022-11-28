package tn.esprit.kaddem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.entities.Etudiant;
import tn.esprit.kaddem.entities.Option;
import tn.esprit.kaddem.services.IEtudiantServices;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/Etudiant")
@AllArgsConstructor
public class EtudiantController {

    IEtudiantServices etudiantServices;

    @GetMapping("/getAll")
    public List<Etudiant> getAllEtudiant() {
        return etudiantServices.getALLEtudiant();
    }

    @PostMapping("/add")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        return etudiantServices.addEtudiant(e);
    }

    @PutMapping("/update")
    public Etudiant updatEtudiant(@RequestBody Etudiant e) {
        return etudiantServices.updateEtudiant(e);
    }

    @DeleteMapping("/delete/{idEtudiant}")
    void deleteETudiant(@PathVariable("idEtudiant") Long idEtudiant) {
        etudiantServices.deleteETudiant(idEtudiant);
    }

    @GetMapping("/getById/{idEtudiant}")
    public Etudiant getEtudiant(@PathVariable ("idEtudiant") Long idEtudiant) {
        return etudiantServices.getEtudiantById(idEtudiant);
    }

    @GetMapping("/getByPrenom/{PrenomEtudiant}")
    public Etudiant getEtudiantbyPrenomEtudiant(@PathVariable ("PrenomEtudiant") String PrenomEtudiant) {
        return etudiantServices.getEtudiantbyPrenomEtudiant(PrenomEtudiant);
    }

    @GetMapping("/getByEquipeThematique/{thematique}")
    public List<Etudiant> retrieveEtudiantByEquipeThematique(@PathVariable ("thematique")  String thematique) {
        return etudiantServices.retrieveEtudiantByEquipeThematique(thematique);
    }

    @PutMapping("/updateByOption/{op}/{idE}")
    public void updateEtudiantByOption(@PathVariable("op") Option op, @PathVariable("idE") Long idEtudiant) {
        etudiantServices.updateEtudiantByOption(op, idEtudiant);
    }

    @PutMapping("/assignToDepartement/{idEtudiant}/{idDepartement}")
    public void assignEtudiantToDepartement(@PathVariable ("idEtudiant")  Long idEtudiant, @PathVariable("idDepartement")  Integer idDepartement) {
        etudiantServices.assignEtudiantToDepartement(idEtudiant, idDepartement);
    }

    @PostMapping("/addAndAssignToEquipeAndContract/{idEquipe}/{idContrat}")
    @ResponseBody
    public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e, @PathVariable("idEquipe") Integer idEquipe, @PathVariable("idContrat") Integer idContrat) {
        return etudiantServices.addAndAssignEtudiantToEquipeAndContract(e, idEquipe, idContrat);
    }

    @GetMapping("/getByDepartement/{idD}")
    public Set<Etudiant> getEtudiantByDepartement(@PathVariable("idD") Integer idDepartement) {
        return etudiantServices.getEtudiantByDepartement(idDepartement);
    }
}
