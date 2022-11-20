package tn.esprit.Kaddem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Kaddem.entities.Equipe;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe, Integer> {


    List<Equipe> findEquipeByEtudiantsIdEtudiant(long idEtudiant);

}