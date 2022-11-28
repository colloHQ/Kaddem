package tn.esprit.kaddem.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.kaddem.entities.*;
import tn.esprit.kaddem.repository.ContratRepository;
import tn.esprit.kaddem.repository.DepartementRepository;
import tn.esprit.kaddem.repository.EquipeRepository;
import tn.esprit.kaddem.repository.EtudiantRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service

public class EtudiantServiceImp implements IEtudiantServices {


    EtudiantRepository etudiantRepository;
    DepartementRepository departementRepository;

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


}
