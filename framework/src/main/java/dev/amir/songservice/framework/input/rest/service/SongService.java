package dev.amir.songservice.framework.input.rest.service;

import dev.amir.songservice.framework.input.rest.request.CreateSongRequest;
import dev.amir.songservice.framework.input.rest.request.DeleteSongRequest;
import dev.amir.songservice.framework.input.rest.response.CreateSongResponse;
import dev.amir.songservice.framework.input.rest.response.DeleteSongResponse;
import dev.amir.songservice.framework.input.rest.response.GetSongResponse;
import org.springframework.http.ResponseEntity;

public interface SongService {
    ResponseEntity<CreateSongResponse> createSong(CreateSongRequest request);

    ResponseEntity<GetSongResponse> getSongById(Long id);

    ResponseEntity<DeleteSongResponse> deleteSongs(DeleteSongRequest request);
}
