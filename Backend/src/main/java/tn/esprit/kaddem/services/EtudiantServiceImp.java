package tn.esprit.kaddem.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.kaddem.entities.*;
import tn.esprit.kaddem.repository.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service

public class EtudiantServiceImp implements IEtudiantServices {


    EtudiantRepository etudiantRepository;
    DepartementRepository departementRepository;
    ProjetRepo projetRepo;

    //slide15
    EquipeRepository equipeRepository;
    ContratRepository contratRepository;

    @Override
    public List<Etudiant> getALLEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public void deleteETudiant(Long id) {
        etudiantRepository.deleteById(id);
        System.out.println("deleted successfuly");
    }

    @Override
    public Etudiant getEtudiantById(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public Etudiant getEtudiantbyPrenomEtudiant(String prenom) {
        return etudiantRepository.findEtudiantByPrenomEtudiant(prenom);
    }

    @Override
    public List<Etudiant> retrieveEtudiantByEquipeThematique(String thematique) {
        return etudiantRepository.retrieveEtudiantByEquipeThematique(thematique);
    }

    @Override
    public void updateEtudiantByOption(Option op, Long idEtudiant) {
        etudiantRepository.updateEtudiantByOption(op, idEtudiant);
    }

    @Override
    public void assignEtudiantToDepartement(Long idEtudiant, Integer idDepartement) {
        Etudiant etudiant = etudiantRepository.findById(idEtudiant).orElse(null);
        Departement departement = departementRepository.findById(idDepartement).orElse(null);
        etudiant.setDepartement(departement);
        etudiantRepository.save(etudiant);
    }

    @Transactional
    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idEquipe, Integer idContrat) {

        Contrat contrat = contratRepository.findById(idContrat).orElse(null);
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        contrat.setEtudiant(e);
        equipe.getEtudiants().add(e);

/*        e.setEquips(new HashSet<Equipe>());
        e.getEquips().add(equipe);*/

        //try
        //e.getEquips().add(equipe);
        //e.getContrats().add(contrat);

        return etudiantRepository.save(e);
    }

    @Override
    public Set<Etudiant> getEtudiantByDepartement(Integer idDepartement) {
        Departement dep = departementRepository.findById(idDepartement).orElse(null);
        return dep.getEtudiants();
    }

    @Override
    public Long nbrEtudByOneDepart(Integer idDepartement) {
            long nbrEtu=0 ;
            Departement d = this.departementRepository.findById(idDepartement).orElse(null);
            return nbrEtu = d.getEtudiants().stream().count();
        }

    @Override
    public Set<Etudiant> findByContratsArchive(Boolean archive) {
        return etudiantRepository.findByContratsArchive(archive);
    }


   /* public Long nbrEtudByDepart() {
        long nbrEtu=0 ;
        List<Departement> Listdepts = departementRepository.findAll();

        for(int i=0;i<Listdepts.size();i++){
            return nbrEtu = Listdepts.get(i).getEtudiants()
                    .stream().map(e -> e.getDepartement()).count();

        }
        return nbrEtu;
    }

    */


    public List<Projet> getProjets(long idEtudiant){

        Etudiant etu = etudiantRepository.findById(idEtudiant).orElse(null);
        Set<Equipe> equipes = etu.getEquips();
        List <Projet> projets = new ArrayList<>();
        equipes.stream().forEach(equipe -> equipe.getProjets().stream().forEach(p ->projets.add(p)));
        return projets;
    }






}
