package tn.esprit.kaddem.entities;

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
    String Discription;
    @Temporal(TemporalType.DATE)
    private Date dateDebutProjet;
    @Temporal(TemporalType.DATE)
    private Date dateFinProjet;
    @NotNull
    @Column(length = 255, columnDefinition = "varchar(255) default 'NOTYETREVIEWED'")
    @Enumerated(EnumType.STRING)
    private Review review;
    @ManyToOne
    Equipe equipe;
    @ManyToOne
    Entreprise entreprise;
    


}
