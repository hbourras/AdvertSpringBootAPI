package hbo.petiteannonce.advert;

public class AdvertNotFoundException extends RuntimeException {
    public AdvertNotFoundException(Long id) {
        super(String.format("Advert with ID #%d not found", id));
    }
}
