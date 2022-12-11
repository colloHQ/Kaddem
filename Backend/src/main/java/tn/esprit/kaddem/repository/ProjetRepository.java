package tn.esprit.kaddem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.kaddem.entities.Projet;

import java.util.List;

public interface ProjetRepository extends JpaRepository<Projet, Long> {
    @Query("SELECT p from Projet p where year (p.dateDebutProjet)=:y and year (p.dateFinProjet)=:y")
    List<Projet> getProjetOfYear(int y);

    Projet findAllByOrderByDateFinProjetAsc();

}