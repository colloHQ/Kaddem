package tn.esprit.kaddem.services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.kaddem.entities.Equipe;
import tn.esprit.kaddem.entities.Niveau;
import tn.esprit.kaddem.entities.Projet;
import tn.esprit.kaddem.repository.EquipeRepository;
import tn.esprit.kaddem.repository.ProjetRepository;

import java.util.List;

@Service
@AllArgsConstructor
@EnableScheduling
public class EquipeServiceImp implements IEquipeServices {


    private final ProjetRepository projetRepository;
    EquipeRepository equipeRepository;

    @Override
    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe getEquipe(Integer idEquipe) {
        return equipeRepository.findById(idEquipe).orElse(null);
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public void deleteEquipe(Integer idEquipe) {
        equipeRepository.deleteById(idEquipe);
    }

    @Override
    public List<Equipe> findEquipeByDetailEquipeThematiqueLike(String th) {
        return equipeRepository.findEquipeByDetailEquipeThematiqueLike(th);
    }

    @Override
    public List<Equipe> findEquipeByEtudiantsIdEtudiant(Long id) {
        return equipeRepository.findEquipeByEtudiantsIdEtudiant(id);
    }

    @Override
    public List<Equipe> findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull(Long idEtudiant) {
        return equipeRepository.findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull(idEtudiant);
    }

    @Override
    public List<Equipe> findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepartement(Long idEtudiant, Integer idDepart) {
        return equipeRepository.findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepartement(idEtudiant, idDepart);
    }

    @Override
    public List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau, String thematique) {
        return equipeRepository.retriveEquipeByNiveauAndThematique(niveau, thematique);
    }

    @Override
    public float updateRating(Integer idEquipe) {
        {
            Equipe e = equipeRepository.findById(idEquipe).orElse(null);
            List<Projet> ProjetsOfEquipe = projetRepository.findProjetsByEquipeIdEquipe(idEquipe);
            float rating = 0;
            for (Projet p : ProjetsOfEquipe) {
                if (p.getReview().toString().equals("VERYBAD")) {
                    rating = rating + 1;
                } else if (p.getReview().toString().equals("BAD")) {
                    rating = rating + 2;
                } else if (p.getReview().toString().equals("AVERAGE")) {
                    rating = rating + 3;
                } else if (p.getReview().toString().equals("GOOD")) {
                    rating = rating + 4;
                } else if (p.getReview().toString().equals("EXCELLENT")) {
                    rating = rating + 5;
                }
            }
            System.out.println(rating / (float) ProjetsOfEquipe.size());
            return rating / (float) ProjetsOfEquipe.size();
        }

    }

    @Scheduled(cron = "*/10 * * * * *") //@weekly
    @Override
    public void updateNiveau() {
        System.out.println(
                "Fixed delay task - " + System.currentTimeMillis() / 1000);
        List<Equipe> junior = equipeRepository.findEquipesByNiveauLike(Niveau.JUNIOR);
        List<Equipe> senior = equipeRepository.findEquipesByNiveauLike(Niveau.SENIOR);

        for (Equipe e : junior) {
            List<Projet> ProjetsOfEquipe = projetRepository.findProjetsByEquipeIdEquipe(e.getIdEquipe());
            if (ProjetsOfEquipe.size()>=2 && e.getRating() >=3 ){
                e.setNiveau(Niveau.SENIOR);
                equipeRepository.save(e);
            }
        }
        for (Equipe e : senior) {
            List<Projet> ProjetsOfEquipe = projetRepository.findProjetsByEquipeIdEquipe(e.getIdEquipe());
            if (ProjetsOfEquipe.size()>=5 && e.getRating() >=4 ){
                e.setNiveau(Niveau.EXPERT);
                equipeRepository.save(e);
            }
        }

    }


}