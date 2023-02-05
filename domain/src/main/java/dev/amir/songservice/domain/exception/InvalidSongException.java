package dev.amir.songservice.domain.exception;

public class InvalidSongException extends RuntimeException {
    public InvalidSongException(String message) {
        super(message);
    }
    public InvalidSongException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
