package dev.amir.songservice.domain.exception;

public class UnexpectedSongException extends RuntimeException {
    public UnexpectedSongException(String message) {
        super(message);
    }

    public UnexpectedSongException(Throwable throwable) {
        super(throwable);
    }

    public UnexpectedSongException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
