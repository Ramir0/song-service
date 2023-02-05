package dev.amir.songservice.framework.input.rest.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSongRequest {
    @NotNull
    private String name;
    @NotNull
    private String artist;
    @NotNull
    private String album;
    @NotNull
    private String length;
    @NotNull
    private Long resourceId;
    @NotNull
    private Integer year;
}
