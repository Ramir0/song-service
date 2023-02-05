package dev.amir.songservice.application.port.output;

import dev.amir.songservice.domain.entity.Song;

import java.util.Collection;
import java.util.Optional;

public interface SongPersistenceOutputPort {
    Song saveSong(Song song);

    Optional<Song> getSongById(Long songId);

    Collection<Song> getAllSongById(Collection<Long> songIds);

    void deleteSongById(Collection<Long> ids);
}
