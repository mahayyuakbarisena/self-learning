package com.sena.restTutorial.exception;

import com.sena.restTutorial.responses.UnitAlamatResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;
import java.util.logging.Logger;

public class AlamatException {
    private static final Logger LOGGER = Logger.getLogger(AlamatException.class.getName());

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<UnitAlamatResponse> handleException(Exception ex) {

        if (ex instanceof ResourceNotFoundException || ex instanceof NoSuchElementException)
            return new ResponseEntity<UnitAlamatResponse>(new UnitAlamatResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage()),
                    HttpStatus.NOT_FOUND);
        else if (ex instanceof ResourceForbiddenException)
            return new ResponseEntity<UnitAlamatResponse>(new UnitAlamatResponse(HttpStatus.FORBIDDEN.value(), ex.getMessage()),
                    HttpStatus.FORBIDDEN);
        else if (ex instanceof BadRequestException)
            return new ResponseEntity<UnitAlamatResponse>(new UnitAlamatResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage()),
                    HttpStatus.BAD_REQUEST);
        else if (ex instanceof ResourceConflictException)
            return new ResponseEntity<UnitAlamatResponse>(new UnitAlamatResponse(HttpStatus.CONFLICT.value(), ex.getMessage()),
                    HttpStatus.CONFLICT);
        else if (ex instanceof UnauthorizedException)
            return new ResponseEntity<UnitAlamatResponse>(new UnitAlamatResponse(HttpStatus.UNAUTHORIZED.value(), ex.getMessage()),
                    HttpStatus.UNAUTHORIZED);
        else if (ex instanceof FormException) {
            FormException err = (FormException) ex;
            return new ResponseEntity<UnitAlamatResponse>(new UnitAlamatResponse(HttpStatus.BAD_REQUEST.value(), err.getMessage(), err.getErrors()),
                    HttpStatus.BAD_REQUEST);
        } else {
            LOGGER.warning(ex.getMessage());
            return new ResponseEntity<UnitAlamatResponse>(new UnitAlamatResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
