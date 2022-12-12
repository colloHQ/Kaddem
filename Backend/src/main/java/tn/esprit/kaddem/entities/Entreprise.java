package tn.esprit.kaddem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Entreprise implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idEntreprise;
    String nomEntreprise;
    String addresseEntreprise;
    int numeroEntreprise;
    @Enumerated(EnumType.STRING)
    Secteur secteur;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entrepriseP")
    Set<Projet> projets;

}