package br.com.hireme.api.handler;

import br.com.hireme.api.handler.exception.ErrorDetails;
import br.com.hireme.api.handler.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.ZonedDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(br.com.hireme.api.handler.exception.NotFoundException.class)
    public ResponseEntity<Object> handlerResourceNotFoundException(NotFoundException exception, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(
                ZonedDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.name(),
                "Not Found Exception, Check the Documentation",
                exception.getMessage(),
                exception.getClass().getName(),
                request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

}
