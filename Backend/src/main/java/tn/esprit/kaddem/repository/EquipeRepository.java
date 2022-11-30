package tn.esprit.kaddem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.kaddem.entities.Equipe;
import tn.esprit.kaddem.entities.Niveau;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe, Integer> {
    List<Equipe> findEquipeByDetailEquipeThematiqueLike(String th);

    List<Equipe> findEquipeByEtudiantsIdEtudiant(Long id);

    List<Equipe> findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull(Long idEtudiant);

    List<Equipe> findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepartement(Long idEtudiant, Integer idDepart);

    @Query("SELECT equipe FROM Equipe equipe INNER JOIN DetailEquipe detail "
            + "ON detail.equipe = equipe.idEquipe WHERE detail.thematique =:thematique "
            + "and equipe.niveau =:niveau")
    List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau, String thematique);


}
