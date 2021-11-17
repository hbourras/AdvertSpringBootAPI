package hbo.petiteannonce.seller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "seller")
@AllArgsConstructor
@NoArgsConstructor
public class Seller {
    private Long id;
    private String firstname;
    private String lastname;
    private Civility civility;
    private Date birthDate;
    private String email;
}
