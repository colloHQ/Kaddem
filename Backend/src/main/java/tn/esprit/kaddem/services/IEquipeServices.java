package tn.esprit.kaddem.services;

import tn.esprit.kaddem.entities.Equipe;
import tn.esprit.kaddem.entities.Niveau;

import java.util.List;

public interface IEquipeServices {
    List<Equipe> getAllEquipes();

    Equipe getEquipe(Integer idEquipe);

    Equipe addEquipe(Equipe e); // ajouter l’équipe avec son détail

    Equipe updateEquipe(Equipe e);

    void deleteEquipe(Integer idEquipe);

    List<Equipe> findEquipeByDetailEquipeThematiqueLike(String th);

    List<Equipe> findEquipeByEtudiantsIdEtudiant(Long id);

    List<Equipe> findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull(Long idEtudiant);

    List<Equipe> findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepartement(Long idEtudiant, Integer idDepart);

    List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau, String thematique);


}
