package tn.esprit.kaddem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.kaddem.entities.Projet;

public interface ProjetRepository extends JpaRepository<Projet,Long> {
}