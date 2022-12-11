package tn.esprit.kaddem.entities;

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

public class Projet implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idProjet;
    String Discription;
    @Temporal(TemporalType.DATE)
    private Date dateDebutProjet;
    @Temporal(TemporalType.DATE)
    private Date dateFinProjet;

    @ManyToOne
    Equipe equipe;
}
