package hbo.petiteannonce.advert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(params = "api/v1/adverts")
public class AdvertResource {

    private final AdvertService advertService;

    @Autowired
    public AdvertResource(AdvertService advertService) {
        this.advertService = advertService;
    }

    @GetMapping
    public ResponseEntity list() {
        return ResponseEntity.ok().body(this.advertService.retrieve());
    }

    @PostMapping
    public Advert create(@RequestBody Advert advert) {
        return null;
    }
}
