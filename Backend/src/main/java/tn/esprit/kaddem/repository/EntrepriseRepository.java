package tn.esprit.kaddem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.kaddem.entities.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long>{
    
}
