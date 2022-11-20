package tn.esprit.Kaddem.entities;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "DetailEquipe")
public class DetailEquipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long idDetailEquipe;
    @NonNull
    Long salle;
    @NonNull
    String thematique;

    @OneToOne(mappedBy = "detailEquipe")
    Equipe equipe;
}