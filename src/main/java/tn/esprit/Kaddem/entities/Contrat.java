package tn.esprit.Kaddem.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Contrat")
public class Contrat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long idContrat;
    @Temporal(TemporalType.DATE)
    @NonNull
    Date dateDebutContrat;

    Date dateFinContrat;
    @Enumerated(EnumType.STRING)
    Specialite specialite;
    boolean archive;


    @ManyToOne
    Etudiant etudiant;
}