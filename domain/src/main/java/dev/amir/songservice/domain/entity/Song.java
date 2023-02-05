package dev.amir.songservice.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Song {
    private Long id;
    private Long resourceId;
    private String name;
    private String artist;
    private String album;
    private String length;
    private Integer year;
}
