package dev.amir.songservice.application.port.input;

import dev.amir.songservice.application.port.output.SongPersistenceOutputPort;
import dev.amir.songservice.application.usecase.SongManagementUseCase;
import dev.amir.songservice.domain.entity.Song;
import dev.amir.songservice.domain.exception.SongNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class SongManagementInputPort implements SongManagementUseCase {
    private final SongPersistenceOutputPort songPersistenceOutputPort;

    @Override
    public Song createSong(Song song) {
        return songPersistenceOutputPort.saveSong(song);
    }

    @Override
    public Song getSongById(Long songId) {
        return songPersistenceOutputPort.getSongById(songId)
                .orElseThrow(() -> new SongNotFoundException(songId));
    }

    @Override
    public Collection<Long> deleteSongById(Collection<Long> ids) {
        var existingSongIds = songPersistenceOutputPort.getAllSongById(ids).stream()
                .map(Song::getId)
                .toList();

        songPersistenceOutputPort.deleteSongById(existingSongIds);

        return existingSongIds;
    }
}
