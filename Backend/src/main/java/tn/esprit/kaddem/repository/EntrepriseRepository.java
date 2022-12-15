package tn.esprit.kaddem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.kaddem.entities.Entreprise;
import tn.esprit.kaddem.entities.Secteur;

import java.util.List;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
    List<Entreprise> findAllBySecteur(Secteur secteur);
    List<Entreprise> findByProjetsIsNull();
}