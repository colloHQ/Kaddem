package tn.esprit.kaddem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Projet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idProjet;
    String description;
    double prixProjet;


    @ManyToOne
    Equipe equipe;

    @ManyToOne
    Entreprise entrepriseP;

    private LocalDate dateDebutProjet;
    private LocalDate dateFinProjet;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Review review;


}