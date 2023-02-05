package dev.amir.songservice.framework.input.rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteSongResponse {
    private Iterable<Long> ids;
}
