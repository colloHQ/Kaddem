package tn.esprit.kaddem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.entities.DetailEquipe;
import tn.esprit.kaddem.services.IDetailEquipeServices;

import java.util.List;

@RestController
@RequestMapping("/DetailEquipe")
@AllArgsConstructor
public class DetailEquipeController {


    IDetailEquipeServices detailEquipeServices;

    @GetMapping("/getAll")
    public List<DetailEquipe> getallDetailEquipes() {
        return detailEquipeServices.GetAllDetailEquipe();
    }

    @GetMapping("/getById/{idDetailEquipe}")
    public DetailEquipe getDetailEquipe(@PathVariable ("idDetailEquipe") Integer idDetailEquipe) {
        return detailEquipeServices.getDetailEquipeById(idDetailEquipe);
    }

    @PostMapping("/add")
    public DetailEquipe addDetailEquipe(@RequestBody DetailEquipe e) {
        return detailEquipeServices.addDetailEquipe(e);
    }

    @PutMapping("/update")
    public DetailEquipe updateDetailEquipe(@RequestBody DetailEquipe e) {
        return detailEquipeServices.updateDetailEquipe(e);
    }

    @DeleteMapping("/delete/{idDetailEquipe}")
    public void deleteDetailEquipe(@PathVariable ("idDetailEquipe") Integer idDetailEquipe) {
        detailEquipeServices.deleteDetailEquipe(idDetailEquipe);
    }

    @GetMapping("/getByThematique/{Thematic}")
    public List<DetailEquipe> findByThematique(@PathVariable ("Thematic") String Thematic) {
        return detailEquipeServices.findByThematique(Thematic);
    }

}
