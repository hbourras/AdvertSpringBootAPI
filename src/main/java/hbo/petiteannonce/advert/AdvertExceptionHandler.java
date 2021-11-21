package hbo.petiteannonce.advert;

import hbo.petiteannonce.base.Error;
import hbo.petiteannonce.base.RootExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AdvertExceptionHandler extends RootExceptionHandler {

    @ExceptionHandler(AdvertNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public Error handleAdvertNotFound(AdvertNotFoundException e) {
        return buildErrorMessage(e);
    }
}
