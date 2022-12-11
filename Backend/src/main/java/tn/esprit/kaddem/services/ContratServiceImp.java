package tn.esprit.kaddem.services;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import tn.esprit.kaddem.entities.Contrat;
import tn.esprit.kaddem.entities.Etudiant;
import tn.esprit.kaddem.entities.Specialite;
import tn.esprit.kaddem.repository.ContratRepository;
import tn.esprit.kaddem.repository.EtudiantRepository;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.MONTHS;

@Service
@AllArgsConstructor
public class ContratServiceImp implements IContratServices {


    ContratRepository contratRepository;
    EtudiantRepository etudiantRepository;

    @Override
    public List<Contrat> getALLContrat() {
        return contratRepository.findAll();
    }


    @Override
    public Contrat addContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Contrat updateContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public void deleteContrat(Integer id) {
        contratRepository.deleteById(id);
    }

    @Override
    public Contrat getContratById(Integer id) {
        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat contrat , String nomE,  String prenomE) {
        Contrat ct = getContratById(contrat.getIdContrat());
        Etudiant etudiant = etudiantRepository.findEtudiantByPrenomEtudiant(prenomE);
        if (ct.getEtudiant()==null && (etudiant.getContrats().size() < 5) ) {
            ct.setEtudiant(etudiant);
            contratRepository.save(ct);
        }
        return ct;

    }


    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        float CA = 0;
        LocalDate dd = Instant.ofEpochMilli( startDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate df = Instant.ofEpochMilli(endDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        Period pd = Period.between(dd,df);
        int years = pd.getYears();
        int nbOfMonths = years*12+pd.getMonths();
        int months ;
        if(nbOfMonths<0) {
            System.out.println("The End-date is  before the Start-date , which is invalid !");
            return 0;
        }
        List<Contrat> contrat = getALLContrat();
        for (Contrat ct : contrat) {
        LocalDate dateDebutContrat = Instant.ofEpochMilli(ct.getDateDebutContrat().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate dateFinContrat = Instant.ofEpochMilli(ct.getDateFinContrat().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();

            int startIndicator= dateDebutContrat.compareTo(dd) ; //indicates whether the contract starts before the startDate provided
            int endIndicator = dateDebutContrat.compareTo(df); //indicates whether the contract starts before the endDate provided
            int indicator = dateFinContrat.compareTo(dd); //indicates whether the contracts ends after the startDate provided
            //we do this to eliminate contracts that start after the endDate provided because they are still valid
            //=0 if dd == dateDebutContrat
            //>0 if  dateDebutContrat after dd
            //<0 if dateDebutContrat before

            //contracts that starts after startDate and endDate  , ends after startDate
            if (!ct.isArchive() && startIndicator >= 0 && endIndicator <0 && indicator > 0 ) {

                if(dateFinContrat.compareTo(df)<0){
                    pd = Period.between(dateDebutContrat,dateFinContrat);
                    years = pd.getYears();
                    months = years*12+pd.getMonths();
                    System.out.println(ct.getIdContrat()+ "    dd < ddc && dfc<df   " + months);
                }
                else{
                    pd=Period.between(dateDebutContrat,df);
                    years = pd.getYears();
                    months= years*12 +pd.getMonths();
                    System.out.println(ct.getIdContrat()+ "    dd < ddc && dfc>df   " + months);
                }
                CA = calculCA(CA, months, ct);
            //contracts that start before startDate , ends after endDate
            } else if (!ct.isArchive() && startIndicator <0 && indicator > 0  ) {

                if(dateFinContrat.compareTo(df)<0){
                    pd = Period.between(dd,dateFinContrat);
                    years = pd.getYears();
                    months = years*12+pd.getMonths();
                    System.out.println( ct.getIdContrat()+ "    dd > ddc && dfc<df   " + months);

                }
                else{
                    pd=Period.between(dd,df);
                    years = pd.getYears();
                    months= years*12+ pd.getMonths();
                    System.out.println(ct.getIdContrat()+ "    dd > ddc && dfc>df   " + months);
                }
                CA = calculCA(CA, months, ct);
            }

        }

        return CA;
    }
    //redundant code in the getChiffreAffaire function , so we created a private method to enhace modularity and readablity of the code
    private float calculCA(float CA, long nbOfMonths, Contrat ct) {
        if (ct.getSpecialite() == Specialite.IA) {
            CA +=  nbOfMonths * 300;

        } else if (ct.getSpecialite() == Specialite.RESEAUX) {
            CA += nbOfMonths * 350;
        } else if (ct.getSpecialite() == Specialite.CLOUD) {
            CA += nbOfMonths * 400;
        } else if (ct.getSpecialite() == Specialite.SECURITE) {
            CA += nbOfMonths * 450;
        }
        return CA;
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        int nbContratsValides= 0;
        LocalDate enDate=Instant.ofEpochMilli(endDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();

        List<Contrat> contrat = getALLContrat();

        for (Contrat ct : contrat ) {
            LocalDate contratStDate=Instant.ofEpochMilli(ct.getDateDebutContrat().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
            //!ct.isArchive() means that the endDate  of the contract is not reached yet
            //endDate.compareTo(contratStDate)>0 means that the contract starts before the endDate provided
            if (!ct.isArchive() && enDate.compareTo(contratStDate)>0  ) {
                nbContratsValides++;
            }
        }
        return nbContratsValides;
    }
    @Override
    public List<Contrat> getContractsBySpecialite(Specialite specialite){
        List<Contrat> allContrats = getALLContrat();
        List<Contrat> specialisedContrats = new ArrayList<Contrat>();
        for (Contrat ct:allContrats){
            if(ct.getSpecialite()==specialite ) {
                specialisedContrats.add(ct);
            }
        }
        return specialisedContrats;
    }
    @Override
    public void archiveDeadContracts(){
        List<Contrat> contrats=getALLContrat();
        contrats.forEach(contrat -> {
            LocalDate endDate = Instant.ofEpochMilli(contrat.getDateFinContrat().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
            if (DAYS.between(LocalDate.now(),endDate)<0) {
                contrat.setArchive(true);
            }
        });
       contratRepository.saveAll(contrats);
    }

    @Override
    public String retrieveAndUpdateStatusContrat(){
        List<Contrat> contrats = getALLContrat();
        String  contractsList = "la liste des contrats dont la date de fin est prevue pour les 15 prochains jours : ";
        for (Contrat ct : contrats){
            LocalDate endDate = Instant.ofEpochMilli(ct.getDateFinContrat().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
            if( !ct.isArchive() && DAYS.between( LocalDate.now(),endDate) <=15 ){
                contractsList+="\n id Contrat : "+ct.getIdContrat()+"    date Fin :"+ ct.getDateFinContrat().toString()+"   specialite: "+ct.getSpecialite().toString()
                +"    etudiant concerne: "+ct.getEtudiant().getIdEtudiant()+"   remaining days :  "+DAYS.between( LocalDate.now(),endDate);
            }
            //Period.between(LocalDate.now(),endDate).getDays()
        }

       return contractsList;


    }
    @Override
    public void onDeleteEtudiant(Long etudiantId){
        List<Contrat> contracts = contratRepository.onDeleteEtudiant(etudiantId);
        System.out.println(contracts);
        for(Contrat ct:contracts ){
            ct.setEtudiant(null);
        }
        contratRepository.saveAll(contracts);
    }

}

