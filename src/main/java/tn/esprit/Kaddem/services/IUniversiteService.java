package tn.esprit.Kaddem.services;

import tn.esprit.Kaddem.entities.Universite;

import java.util.Date;
import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversites();

    Universite addUniversite(Universite u);

    Universite updateUniversite(Universite u);

    Universite retrieveUniversite(Integer idUniversite);

    void removeUniversite(Integer idUniversite);

    float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);


}