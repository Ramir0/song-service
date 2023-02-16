package dev.amir.songservice.framework.input.rest;

import dev.amir.songservice.framework.input.rest.request.CreateSongRequest;
import dev.amir.songservice.framework.input.rest.request.DeleteSongRequest;
import dev.amir.songservice.framework.input.rest.response.CreateSongResponse;
import dev.amir.songservice.framework.input.rest.response.DeleteSongResponse;
import dev.amir.songservice.framework.input.rest.response.GetSongResponse;
import dev.amir.songservice.framework.input.rest.service.SongService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("songs")
public class SongsController {
    private final SongService songService;

    @PostMapping
    public ResponseEntity<CreateSongResponse> createSong(
            @Valid @RequestBody CreateSongRequest request) {
        log.info("Request: {}", request);
        return songService.createSong(request);
    }

    @GetMapping("{id}")
    public ResponseEntity<GetSongResponse> getSong(
            @PathVariable Long id) {
        log.info("Request: SongId: {}", id);
        return songService.getSongById(id);
    }

    @DeleteMapping()
    public ResponseEntity<DeleteSongResponse> deleteSong(
            @Valid @RequestParam("id") DeleteSongRequest request) {
        log.info("Request: {}", request);
        return songService.deleteSongs(request);
    }
}
