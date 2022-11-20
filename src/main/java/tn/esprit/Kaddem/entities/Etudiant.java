package tn.esprit.Kaddem.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Etudiant")
public class Etudiant implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEtudiant")
    Long idEtudiant;

    @NonNull
    String prenomE;
    @NonNull
    String nomE;
    @Enumerated(EnumType.STRING)
    Option option;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etudiant")
    Set<Contrat> contrats;

    @ManyToOne
    Departement departement;

    @ManyToMany(cascade = CascadeType.ALL)
    Set<Equipe> equipes;


}