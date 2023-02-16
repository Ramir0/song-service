package dev.amir.songservice.framework.output.sql;

import dev.amir.songservice.application.port.output.SongPersistenceOutputPort;
import dev.amir.songservice.domain.entity.Song;
import dev.amir.songservice.framework.output.sql.mapper.SongEntityMapper;
import dev.amir.songservice.framework.output.sql.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class SongPersistenceSqlAdapter implements SongPersistenceOutputPort {
    private final SongRepository songRepository;
    private final SongEntityMapper mapper;

    @Override
    public Song saveSong(Song song) {
        log.info("Saving [{}]", song);
        var songEntity = songRepository.save(Objects.requireNonNull(mapper.convert(song)));
        log.info("Song was successfully saved with Id: [{}]", songEntity.getId());
        return Objects.requireNonNull(mapper.convert(songEntity));
    }

    @Override
    public Optional<Song> getSongById(Long songId) {
        return songRepository.findById(songId).map(mapper::convert);
    }

    @Override
    public Collection<Song> getAllSongById(Collection<Long> songIds) {
        return songRepository.findAllByIdIn(songIds).stream().map(mapper::convert).collect(Collectors.toList());
    }

    @Override
    public void deleteSongById(Collection<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }

        songRepository.deleteAllById(ids);
    }
}
