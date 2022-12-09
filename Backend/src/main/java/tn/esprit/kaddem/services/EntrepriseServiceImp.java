package tn.esprit.kaddem.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.kaddem.entities.Entreprise;
import tn.esprit.kaddem.repository.EntrepriseRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EntrepriseServiceImp implements IEntrepriseServices{

    EntrepriseRepository entrepriseRepository;

    @Override
    public List<Entreprise> getAllEntreprise() {
        return entrepriseRepository.findAll();
    }

    @Override
    public Entreprise addEntreprise(Entreprise e) {
        return entrepriseRepository.save(e);
    }

    @Override
    public Entreprise updateEntreprise(Entreprise e) {
        return entrepriseRepository.save(e);
    }

    @Override
    public void deleteEntreprise(Long id) {
        entrepriseRepository.deleteById(id);
    }

    @Override
    public Entreprise getEntrepriseById(Long id) {
        return entrepriseRepository.findById(id).orElse(null);
    }
}