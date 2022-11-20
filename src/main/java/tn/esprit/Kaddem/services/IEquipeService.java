package tn.esprit.Kaddem.services;

import tn.esprit.Kaddem.entities.Equipe;

import java.util.List;

public interface IEquipeService {

    List<Equipe> retrieveAllEquipes();

    Equipe addEquipe(Equipe e);

    Equipe updateEquipe(Equipe e);

    Equipe retrieveEquipe(Integer idEquipe);

    void removeEquipe(Integer idEquipe);

    void assignEtudiantToEquipe(Integer idEtudiant, Integer idEquipe);

    List<Equipe> findEquipeByEtudiantsIdEtudiant(long idEtudiant);

}