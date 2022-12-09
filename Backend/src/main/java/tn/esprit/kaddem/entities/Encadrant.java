package tn.esprit.kaddem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "encadrant")
public class Encadrant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idEncadrant;
    String prenomEncadrant;
    String nomEncadrant;
    Date dateEmbauche;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "encadrant")
    Set<Equipe> equipes;



}
