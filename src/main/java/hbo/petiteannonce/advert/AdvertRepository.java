package hbo.petiteannonce.advert;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface AdvertRepository extends JpaRepository<Advert, Long> {

    @Query("SELECT a FROM Advert a WHERE a.seller.id = :id")
    public List<Advert> findBySellerId(Long id);

    @Transactional
    @Modifying
    @Query("DELETE Advert a WHERE a.seller.id = :id")
    public void deleteBySellerId(Long id);

}
