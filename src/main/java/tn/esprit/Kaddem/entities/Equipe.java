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
@Table(name = "Equipe")
public class Equipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEquipe;

    @NonNull
    String nomEquipe;

    @Enumerated(EnumType.STRING)
    Niveau niveau;

    @OneToOne
    DetailEquipe detailEquipe;

    @ManyToMany(mappedBy = "equipes", cascade = CascadeType.ALL)
    Set<Etudiant> etudiants;

}