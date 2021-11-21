package hbo.petiteannonce.seller;

import com.fasterxml.jackson.annotation.*;
import hbo.petiteannonce.advert.Advert;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter @Setter @Builder
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "seller", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"EMAIL"}, name = "seller_email_uq")
})
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Seller {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(name = "FIRSTNAME", nullable = false, length = 30)
    private String firstname;
    @Column(name = "LASTNAME", nullable = false, length = 30)
    private String lastname;
    @Column(name = "CIVILITY", nullable = false)
    @Enumerated(EnumType.STRING)
    private Civility civility;
    @Column(name = "DATE_BIRTH", nullable = false, columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthDate;
    @Column(name="EMAIL",  nullable = false, length = 150)
    private String email;

    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Advert> adverts;
}
