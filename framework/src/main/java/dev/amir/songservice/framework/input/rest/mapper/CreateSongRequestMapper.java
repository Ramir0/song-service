package dev.amir.songservice.framework.input.rest.mapper;

import dev.amir.songservice.domain.entity.Song;
import dev.amir.songservice.framework.input.rest.request.CreateSongRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CreateSongRequestMapper {
    Song convert(CreateSongRequest request);
}
