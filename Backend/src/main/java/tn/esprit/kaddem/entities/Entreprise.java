package tn.esprit.kaddem.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Entreprise implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idEntreprise;
    String nomEntreprise;
    String addresseEntreprise;
    int numeroEntreprise;
    @Enumerated(EnumType.STRING)
    Secteur secteur;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entreprise")
    @JsonIgnore
    Set<Encadrant> encadrants;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "entrepriseP")
    Set<Projet> projets;

}