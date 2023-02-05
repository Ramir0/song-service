package dev.amir.songservice.framework.input.rest.service;

import dev.amir.songservice.application.usecase.SongManagementUseCase;
import dev.amir.songservice.domain.exception.UnexpectedSongException;
import dev.amir.songservice.framework.input.rest.mapper.CreateSongRequestMapper;
import dev.amir.songservice.framework.input.rest.request.CreateSongRequest;
import dev.amir.songservice.framework.input.rest.request.DeleteSongRequest;
import dev.amir.songservice.framework.input.rest.response.CreateSongResponse;
import dev.amir.songservice.framework.input.rest.response.DeleteSongResponse;
import dev.amir.songservice.framework.input.rest.response.GetSongResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {
    private final SongManagementUseCase songManagementUseCase;
    private final CreateSongRequestMapper createSongRequestMapper;

    @Override
    public ResponseEntity<CreateSongResponse> createSong(CreateSongRequest request) {
        var song = createSongRequestMapper.convert(request);
        var savedSong = songManagementUseCase.createSong(song);
        return ResponseEntity.ok(new CreateSongResponse(savedSong.getId()));
    }

    @Override
    public ResponseEntity<GetSongResponse> getSongById(Long id) {
        var song = songManagementUseCase.getSongById(id);
        return ResponseEntity.ok(
                GetSongResponse.builder()
                        .name(song.getName())
                        .album(song.getAlbum())
                        .artist(song.getArtist())
                        .length(song.getLength())
                        .resourceId(song.getResourceId())
                        .year(song.getYear())
                        .build()
        );
    }

    @Override
    public ResponseEntity<DeleteSongResponse> deleteSongs(DeleteSongRequest request) {
        try {
            var ids = getIdsFromRequest(request);
            var deletedSongIds = songManagementUseCase.deleteSongById(ids);
            return ResponseEntity.ok(new DeleteSongResponse(deletedSongIds));
        } catch (NumberFormatException exception) {
            throw new UnexpectedSongException(String.format("Invalid list of ids: [%s]", request.getIds()), exception);
        }
    }

    private Collection<Long> getIdsFromRequest(DeleteSongRequest request) {
        return Arrays.stream(request.getIds().split(","))
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }
}
