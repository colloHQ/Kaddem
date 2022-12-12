package tn.esprit.kaddem.controller;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;
import tn.esprit.kaddem.entities.Equipe;
import tn.esprit.kaddem.entities.Niveau;
import tn.esprit.kaddem.repository.EquipeRepository;
import tn.esprit.kaddem.services.IEquipeServices;
import tn.esprit.kaddem.utils.FileUploadUtil;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/Equipe")
@AllArgsConstructor
public class EquipeController {


    private final EquipeRepository equipeRepository;
    IEquipeServices equipeServices;

    @GetMapping("/getAll")
    public List<Equipe> getallEquipes() {
        return equipeServices.getAllEquipes();
    }

    @GetMapping("/getById/{idEquipe}")
    public Equipe getEquipe(@PathVariable("idEquipe") int idEquipe) {
        return equipeServices.getEquipe(idEquipe);
    }

    @PostMapping("/add")
    public Equipe addEquipe(@RequestBody Equipe e) {
        return equipeServices.addEquipe(e);
    }

    @PutMapping("/update")
    public Equipe updateEquipe(@RequestBody Equipe e) {
        return equipeServices.updateEquipe(e);
    }

    @DeleteMapping("/delete/{idEquipe}")
    public void deleteEquipe(@PathVariable("idEquipe") Integer idEquipe) {
        equipeServices.deleteEquipe(idEquipe);
    }

    @GetMapping("/findByThematique/{thematique}")
    public List<Equipe> findEquipeByDetailEquipeThematiqueLike(@PathVariable("thematique") String th) {
        return equipeServices.findEquipeByDetailEquipeThematiqueLike(th);
    }

    @GetMapping("/findByEtudiant/{idEtudiant}")
    public List<Equipe> findEquipeByEtudiantIdEtudiant(@PathVariable("idEtudiant") Long id) {
        return equipeServices.findEquipeByEtudiantsIdEtudiant(id);
    }

    @GetMapping("/findByThematiqueNotNull/{idE}")
    public List<Equipe> findByEtudiantIdEtudiantAndDetailEquipeThematiqueNotNull(@PathVariable("idE") Long idEtudiant) {
        return equipeServices.findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull(idEtudiant);
    }

    @GetMapping("/findByEtudiantAndDepart/{idE}/{idD}")
    public List<Equipe> findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepartement(@PathVariable("idE") Long idEtudiant, @PathVariable("idD") Integer idDepart) {
        return equipeServices.findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepartement(idEtudiant, idDepart);
    }

    @GetMapping("/findByNiveauAndThematique/{niv}/{th}")
    public List<Equipe> retriveEquipeByNiveauAndThematique(@PathVariable("niv") Niveau niveau, @PathVariable("th") String thematique) {
        return equipeServices.retriveEquipeByNiveauAndThematique(niveau, thematique);
    }


    /*-- Added functionality */
    @PostMapping("/save")
    public RedirectView saveEquipe(Equipe eq, @RequestParam("image") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        eq.setPhotos(fileName);

        Equipe savedEquipe = equipeRepository.save(eq);

        String uploadDir = "equipe-photos/" + savedEquipe.getIdEquipe();

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        return new RedirectView("/Equipe/getAll", true);
    }

    @GetMapping("/getTopThree")
    public List<Equipe> getTopThree() {
        return equipeRepository.findTop3ByOrderByRatingDesc();
    }


    @PostMapping("/updateRating/{idEquipe}")
    public void updateRating(@PathVariable("idEquipe") int idEquipe) {
        Equipe e = equipeServices.getEquipe(idEquipe);
        e.setRating(equipeServices.updateRating(idEquipe));
        equipeRepository.save(e);
    }

    @GetMapping("/equipeByN/{nv}")
    public List<Equipe> findEquipeByN(@PathVariable("nv") Niveau nv) {
        return equipeRepository.findEquipesByNiveauLike(nv);
    }




}
