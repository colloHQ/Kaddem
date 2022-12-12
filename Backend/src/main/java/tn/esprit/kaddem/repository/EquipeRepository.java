package tn.esprit.kaddem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.kaddem.entities.Equipe;
import tn.esprit.kaddem.entities.Niveau;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe, Integer> {

    List<Equipe> findEquipeByDetailEquipeThematiqueLike(String th);

    List<Equipe> findEquipesByNiveauLike(Niveau nv);

    List<Equipe> findTop3ByOrderByRatingDesc();


    List<Equipe> findEquipeByEtudiantsIdEtudiant(Long id);

    List<Equipe> findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull(Long idEtudiant);

    List<Equipe> findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepartement(Long idEtudiant, Integer idDepart);

    @Query("SELECT equipe FROM Equipe equipe INNER JOIN DetailEquipe detail "
            + "ON detail.equipe = equipe.idEquipe WHERE detail.thematique =:thematique "
            + "and equipe.niveau =:niveau")
    List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau, String thematique);


    /* Added methods */


}