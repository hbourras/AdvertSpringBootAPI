package hbo.petiteannonce.seller.exception;

public class SellerEmailAlreadyExistsException extends RuntimeException {
    public SellerEmailAlreadyExistsException (String email) {
        super(String.format("Seller with email '%s' already exists",email));
    }
}
