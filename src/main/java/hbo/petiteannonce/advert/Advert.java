package hbo.petiteannonce.advert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="advert")
public class Advert {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "ID")
    private Long id;
    @Column (name = "TITLE", nullable = false, precision = 150)
    private String title;
    @Column (name = "DESCRIPTION", nullable = false, columnDefinition = "TEXT")
    private String description;
    @Column (name = "DATE_CREATION", nullable = false, columnDefinition = "DATE" )
    private Date creationDate;
    @Column (name = "DATE_MODIFICATION", columnDefinition = "DATE" )
    private Date modificationDate;
    @Column (name = "PRICE", nullable = false, columnDefinition = "DECIMAL(8,2)")
    private Float price;
}
