package hbo.petiteannonce.advert;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adverts")
@AllArgsConstructor
public class AdvertResource {

    @Autowired
    private final AdvertService advertService;

    @GetMapping
    public List<Advert> list() {
        return this.advertService.retrieve();
    }

    @GetMapping("/{id}")
    public Advert get(@PathVariable("id") Long id) {
        return this.advertService.retrieveById(id);
    }

    @PostMapping
    public Advert create(@RequestBody Advert advert) {
        return this.advertService.create(advert);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.advertService.delete(id);
    }

    @PutMapping("/{id}")
    public Advert modify(@PathVariable("id") Long id, @RequestBody Advert advert) {
        advert.setId(id);
        return this.advertService.update(advert);
    }
}