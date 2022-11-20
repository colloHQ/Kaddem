package tn.esprit.Kaddem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Kaddem.entities.Universite;


@Repository
public interface UniversiteRepository extends JpaRepository<Universite, Integer> {
}