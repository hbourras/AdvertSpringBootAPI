package hbo.petiteannonce.seller.exception;

public class SellerNotFoundException extends RuntimeException {
    public SellerNotFoundException(Long id) {
        super(String.format("Seller with ID %s not found.", id));
    }
}
