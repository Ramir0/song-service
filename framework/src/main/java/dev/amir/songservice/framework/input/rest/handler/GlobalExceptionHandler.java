package dev.amir.songservice.framework.input.rest.handler;

import dev.amir.songservice.domain.exception.InvalidSongException;
import dev.amir.songservice.domain.exception.SongNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException exception) {
        String errorMessage = exception.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", "));
        log.error(errorMessage, exception);
        return new ResponseEntity<>("Song metadata missing validation error", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>("Song metadata missing validation error", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InvalidSongException.class})
    public ResponseEntity<String> handleInvalidSongException(InvalidSongException exception) {
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>("Invalid song metadata", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({SongNotFoundException.class})
    public ResponseEntity<String> handleSongNotFoundException(SongNotFoundException exception) {
        log.warn(exception.getMessage(), exception);
        return new ResponseEntity<>("The song metadata with the specified id does not exist", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<String> handleException(Exception exception) {
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>("An internal server error has occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

