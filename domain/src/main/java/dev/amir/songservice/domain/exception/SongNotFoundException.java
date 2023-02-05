package dev.amir.songservice.domain.exception;

public class SongNotFoundException extends RuntimeException {
    public SongNotFoundException(Long songId) {
        super(String.format("Song with id: %d not found", songId));
    }
}
