package br.com.hireme.api.handler;

import br.com.hireme.api.handler.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.ZonedDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
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

    @ExceptionHandler(NotAcceptableException.class)
    public ResponseEntity<Object> handlerResourceNotAcceptableException(NotAcceptableException exception, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(
                ZonedDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.name(),
                "Not Acceptable, Check the Documentation",
                exception.getMessage(),
                exception.getClass().getName(),
                request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(NoContentException.class)
    public ResponseEntity<Object> handlerResourceNoContentException(NoContentException exception, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                ZonedDateTime.now(),
                HttpStatus.NO_CONTENT.value(),
                HttpStatus.NO_CONTENT.name(),
                "No value was funded",
                exception.getMessage(),
                exception.getClass().getName(),
                request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handlerResourceBadRequestException(BadRequestException exception, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                ZonedDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.name(),
                "Error in filling the fields. Check the Documentation",
                exception.getMessage(),
                exception.getClass().getName(),
                request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
