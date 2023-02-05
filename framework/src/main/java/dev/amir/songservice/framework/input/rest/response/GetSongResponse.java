package dev.amir.songservice.framework.input.rest.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetSongResponse {
    private String name;
    private String artist;
    private String album;
    private String length;
    private Long resourceId;
    private Integer year;
}
