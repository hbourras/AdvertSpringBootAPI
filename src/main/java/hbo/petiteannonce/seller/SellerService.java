package hbo.petiteannonce.seller;

import hbo.petiteannonce.advert.AdvertRepository;
import hbo.petiteannonce.seller.exception.SellerEmailAlreadyExistsException;
import hbo.petiteannonce.seller.exception.SellerNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class SellerService {

    @Autowired
    private final SellerRepository sellerRepository;

    @Autowired
    private final AdvertRepository advertRepository;

    public List<Seller> retrieveAll() {
        log.info("Retrieving all sellers");
        return this.sellerRepository.findAll();
    }

    public Seller retrieveById(Long id) {
        log.info("Retrieving seller #{}", id);
        return this.sellerRepository.findById(id).orElseThrow(() -> new SellerNotFoundException(id));
    }

    @Transactional
    public void delete(Long id) {
        Seller seller = this.retrieveById(id);

        log.info("Deleting seller #{}", id);
        this.advertRepository.deleteBySellerId(seller.getId());
        this.sellerRepository.delete(seller);
    }

    @Transactional
    public Seller create(Seller seller) {
        Seller existingSeller = this.sellerRepository.findByEmail(seller.getEmail());
        if(Objects.nonNull(existingSeller))
            throw new SellerEmailAlreadyExistsException(seller.getEmail());

        log.info("Creating seller with email '{}'", seller.getEmail());
        return this.sellerRepository.save(seller);
    }
}
