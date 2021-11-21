package hbo.petiteannonce.seller;

import hbo.petiteannonce.base.Error;
import hbo.petiteannonce.base.RootExceptionHandler;
import hbo.petiteannonce.seller.exception.SellerEmailAlreadyExistsException;
import hbo.petiteannonce.seller.exception.SellerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SellerExceptionHandler extends RootExceptionHandler {

    @ResponseBody
    @ExceptionHandler(SellerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error handleAdvertNotFound(SellerNotFoundException e) {
        return buildErrorMessage(e);
    }

    @ResponseBody
    @ExceptionHandler(SellerEmailAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handleAdvertNotFound(SellerEmailAlreadyExistsException e) {
        return buildErrorMessage(e);
    }
}
