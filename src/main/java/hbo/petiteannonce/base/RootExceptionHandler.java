package hbo.petiteannonce.base;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RootExceptionHandler {
    protected Error buildErrorMessage(Exception e) {
        log.error("Error while accessing api : {}", e.getMessage());
        return Error.builder().message(e.getMessage()).build();
    }
}
