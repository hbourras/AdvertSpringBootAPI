package hbo.petiteannonce.seller;

import hbo.petiteannonce.advert.Advert;
import hbo.petiteannonce.advert.AdvertService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellers")
@AllArgsConstructor
public class SellerResource {

    @Autowired
    private final SellerService sellerService;

    @Autowired
    private final AdvertService advertService;

    @GetMapping
    public List<Seller> retrieveAll() {
        return this.sellerService.retrieveAll();
    }

    @GetMapping("/{id}/adverts")
    public List<Advert> retrieveAdvicesBySellerId(@PathVariable("id") Long sellerId) {
        return this.advertService.retrieveBySellerId(sellerId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.sellerService.delete(id);
    }

    @GetMapping("/{id}")
    public Seller get(@PathVariable("id") Long id) {
        return this.sellerService.retrieveById(id);
    }

    @PostMapping
    public Seller create(@RequestBody Seller seller) {
        return this.sellerService.create(seller);
    }

    @PostMapping("/{id}/adverts")
    public Advert createAdvertFromSellerId(@PathVariable("id") Long sellerId, @RequestBody Advert advert) {
        advert.setSeller(Seller.builder().id(sellerId).build());
        return this.advertService.create(advert);
    }
}
