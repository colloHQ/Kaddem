package tn.esprit.kaddem.services;

import tn.esprit.kaddem.entities.DetailEquipe;

import java.util.List;

public interface IDetailEquipeServices {

    List<DetailEquipe> GetAllDetailEquipe();

    DetailEquipe addDetailEquipe(DetailEquipe e);

    DetailEquipe updateDetailEquipe(DetailEquipe e);

    DetailEquipe getDetailEquipeById(Integer idDetailEquipe);

    void deleteDetailEquipe(Integer idDetailEquipe);

    List<DetailEquipe> findByThematique(String thematique);
}
