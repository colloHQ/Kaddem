package tn.esprit.kaddem.controller;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.entities.Contrat;
import tn.esprit.kaddem.services.IContratServices;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Contrat")
@AllArgsConstructor
public class ContratController {


    IContratServices contratServices;

    @GetMapping("/getAll")
    public List<Contrat> getAllContrat() {
        return contratServices.getALLContrat();
    }

    @GetMapping("getById/{idContrat}")
    public Contrat getContrat(@PathVariable ("idContrat")Integer idContrat) {
        return contratServices.getContratById(idContrat);
    }

    @PostMapping("/add")
    public Contrat addContrat(@RequestBody Contrat c) {
        return contratServices.addContrat(c);
    }

    @PutMapping("/update")
    public Contrat updateContrat(@RequestBody Contrat c) {
        return contratServices.updateContrat(c);
    }

    @DeleteMapping("delete/{idContrat}")
    public void deleteContrat(@PathVariable ("idContrat") Integer idContrat) {
        contratServices.deleteContrat(idContrat);
    }

    @PostMapping("/affectToEtudiant/{prenomE}")
    public Contrat affectContratToEtudiant(@RequestBody Contrat ce, String nomE, @PathVariable ("prenomE") String prenomE) {

        return contratServices.affectContratToEtudiant(ce, nomE, prenomE);

    }

    @GetMapping("getCA/{Ds}/{Df}")
    public float getChiffreAffaireEntreDeuxDate(@PathVariable("Ds") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @PathVariable("Df") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return contratServices.getChiffreAffaireEntreDeuxDate(startDate, endDate);
    }

    @GetMapping("/getValide/{DateDebutContrat}/{DateFinContrat}")
    public Integer GetValide(@PathVariable("DateDebutContrat") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateD, @PathVariable("DateFinContrat") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateF) {

        return contratServices.nbContratsValides(dateD, dateF);
    }
}
