package me.dio.santander_dev_api_rest_2025.controller.exception;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleResourceNotFoundException(
        IllegalArgumentException businessException) {
        return new ResponseEntity<String>(businessException.getMessage(), 
            org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(
        NoSuchElementException notFoundException) {
        return new ResponseEntity<>("Resource ID not found", 
            org.springframework.http.HttpStatus.NOT_FOUND); // ou NOT_CONTENT (familia 204)
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleUnexpectedException(
        Throwable unexpectedException) {
            var message = "Unexpected Server Error, see the logs.";
            logger.error(message, unexpectedException);
        return new ResponseEntity<>(message, 
            org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
