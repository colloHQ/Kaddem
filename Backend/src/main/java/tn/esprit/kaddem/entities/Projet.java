package tn.esprit.kaddem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
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
    @Temporal(TemporalType.DATE)
    private Date dateDebutProjet;
    @Temporal(TemporalType.DATE)
    private Date dateFinProjet;

    @Enumerated(EnumType.STRING)
    private Review review;
    double prixProjet;
    @ManyToOne
    Equipe equipe;
    @JsonIgnore
    @ManyToOne
    Entreprise entrepriseP;



}
