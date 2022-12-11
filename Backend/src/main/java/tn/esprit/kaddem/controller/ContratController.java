package tn.esprit.kaddem.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.entities.Contrat;
import tn.esprit.kaddem.entities.Specialite;
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

    @GetMapping("/getById/{idContrat}")
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

    @DeleteMapping("/delete/{idContrat}")
    public void deleteContrat(@PathVariable ("idContrat") Integer idContrat) {
        contratServices.deleteContrat(idContrat);
    }

    @PostMapping("/affectToEtudiant/{nomE}/{prenomE}")
    public Contrat affectContratToEtudiant(@RequestBody Contrat contrat,@PathVariable("nomE") String nomE, @PathVariable ("prenomE") String prenomE) {
        return contratServices.affectContratToEtudiant(contrat, nomE, prenomE);
    }

    @GetMapping("/getCA/{startDate}/{endDate}")
    public float getChiffreAffaireEntreDeuxDate(@PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return contratServices.getChiffreAffaireEntreDeuxDate(startDate, endDate);
    }

    @GetMapping("/getValide/{DateDebutContrat}/{DateFinContrat}")
    public Integer GetValide(@PathVariable("DateDebutContrat") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateD, @PathVariable("DateFinContrat") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateF) {

        return contratServices.nbContratsValides(dateD, dateF);
    }

    @GetMapping("getBySpecialite/{specialite}")
    public List<Contrat> getContractsBySpecialite(@PathVariable Specialite specialite){
        return contratServices.getContractsBySpecialite(specialite);
    }

    @Scheduled(cron = "0 0 13 * * ?")
    public void retrieveAndUpdateStatusContrat(){
        contratServices.archiveDeadContracts();
        System.out.println(contratServices.retrieveAndUpdateStatusContrat());
    }


}
