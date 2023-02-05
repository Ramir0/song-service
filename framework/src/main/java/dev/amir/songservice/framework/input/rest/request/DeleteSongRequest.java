package dev.amir.songservice.framework.input.rest.request;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteSongRequest {
    @Size(max = 200, message = "The maximum number of characters in Id is 200")
    @Pattern(regexp = "\\d+(,\\d+)*(\\.\\d+)?", message = "Invalid Id format")
    String ids;
}
