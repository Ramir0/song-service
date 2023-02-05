package dev.amir.songservice.application.usecase;

import dev.amir.songservice.domain.entity.Song;

import java.util.Collection;

public interface SongManagementUseCase {
    Song createSong(Song song);

    Song getSongById(Long songId);

    Collection<Long> deleteSongById(Collection<Long> ids);
}
