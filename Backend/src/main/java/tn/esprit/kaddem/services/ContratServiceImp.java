package tn.esprit.kaddem.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.kaddem.entities.Contrat;
import tn.esprit.kaddem.entities.Etudiant;
import tn.esprit.kaddem.repository.ContratRepository;
import tn.esprit.kaddem.repository.EtudiantRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ContratServiceImp implements IContratServices {


    ContratRepository contratRepository;
    EtudiantRepository etudiantRepository;

    @Override
    public List<Contrat> getALLContrat() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat addContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Contrat updateContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public void deleteContrat(Integer id) {
        contratRepository.deleteById(id);

    }

    @Override
    public Contrat getContratById(Integer id) {
        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {

        Etudiant etudiant = etudiantRepository.findEtudiantByPrenomEtudiant(prenomE);
        if (etudiant.getContrats().size() < 5) {
            ce.setEtudiant(etudiant);
            contratRepository.save(ce);
        } else System.out.println("cannot add new contrat to etudiant");
        return ce;
    }


    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        float CA = 0;
        int nbOfMonths = 1;

        List<Contrat> contrat = contratRepository.findAll();
        for (int i = 0; i < contrat.size(); i++) {
            Contrat ct = contrat.get(i);
            int dd = Integer.parseInt(ct.getDateDebutContrat().toString().substring(5, 7));
            int df = Integer.parseInt(ct.getDateFinContrat().toString().substring(5, 7));

            if ((nbOfMonths *= (df - dd)) == 0) {
                nbOfMonths = 1;
            } else {
                nbOfMonths = (df - dd);
            }
            if (ct.isArchive() == false) {

                System.out.println("*******" + nbOfMonths);

                if (ct.getSpecialite().toString() == "IA") {
                    CA += nbOfMonths * 300;

                } else if (ct.getSpecialite().toString() == "RESEAUX") {
                    CA += nbOfMonths * 350;
                } else if (ct.getSpecialite().toString() == "CLOUD") {
                    CA += nbOfMonths * 400;
                } else if (ct.getSpecialite().toString() == "SECURITE") {
                    CA += nbOfMonths * 450;
                }

            }

        }
        return CA;
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        int j = 0;

        List<Contrat> contrat = contratRepository.findAll();

        for (int i = 0; i < contrat.size(); i++) {
            Contrat ct = contrat.get(i);


            if (ct.isArchive() == false) {
                j++;
                System.out.println("famaa " + j + "contrat dispo");

            }

        }
        return j;
    }
}
