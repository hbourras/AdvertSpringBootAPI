package hbo.petiteannonce.advert;

import hbo.petiteannonce.seller.Seller;
import hbo.petiteannonce.seller.SellerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AdvertService {

    @Autowired
    private final AdvertRepository advertRepository;

    @Autowired
    private final SellerService sellerService;

    public List<Advert> retrieve() {
        log.info("Retrieving all adverts");
        return this.advertRepository.findAll();
    }

    public List<Advert> retrieveBySellerId(Long sellerId) {
        Seller seller = this.sellerService.retrieveById(sellerId);
        log.info("Retrieving advert from {} seller account", seller.getEmail());
        return this.advertRepository.findBySellerId(sellerId);
    }

    public Advert retrieveById(Long id) {
        log.info("Retrieving advert from #{} seller account", id);
        return this.advertRepository.findById(id).orElseThrow(() -> new AdvertNotFoundException(id));
    }

    @Transactional
    public void delete(Long id) {
        Advert ad = this.retrieveById(id);
        log.info("Deleting advert #{}", id);
        this.advertRepository.deleteById(ad.getId());
    }

    @Transactional
    public Advert create(Advert advert) {
        Seller seller = this.sellerService.retrieveById(advert.getSeller().getId());
        log.info("Creating advert into {} seller account", seller.getEmail());
        advert.setSeller(seller);
        advert.setCreationDate(Calendar.getInstance().getTime());
        return this.advertRepository.save(advert);
    }

    @Transactional
    public Advert update(Advert advert) {
        Advert existingAdvert = this.retrieveById(advert.getId());
        log.info("Update advert #{}", advert.getId());

        existingAdvert.setDescription(advert.getDescription());
        existingAdvert.setTitle(advert.getTitle());
        existingAdvert.setModificationDate(Calendar.getInstance().getTime());
        existingAdvert.setPrice(advert.getPrice());
        return this.advertRepository.save(existingAdvert);
    }
}
