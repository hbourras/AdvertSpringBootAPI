package hbo.petiteannonce.advert;

import com.fasterxml.jackson.annotation.*;
import hbo.petiteannonce.seller.Seller;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter @Builder
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="advert")
public class Advert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID")
    @EqualsAndHashCode.Include
    private Long id;
    @Column (name = "TITLE", nullable = false, precision = 150)
    private String title;
    @Column (name = "DESCRIPTION", nullable = false, columnDefinition = "TEXT")
    private String description;
    @Column (name = "DATE_CREATION", nullable = false, columnDefinition = "DATETIME" )
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Date creationDate;
    @Column (name = "DATE_MODIFICATION", columnDefinition = "DATETIME" )
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Date modificationDate;
    @Column (name = "PRICE", nullable = false, precision=8, scale=2)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(foreignKey=@ForeignKey(name="advert_seller_fk"), name = "SELLER_ID", nullable = false)
    private Seller seller;
}
