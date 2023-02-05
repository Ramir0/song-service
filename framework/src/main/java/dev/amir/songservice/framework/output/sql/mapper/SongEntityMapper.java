package dev.amir.songservice.framework.output.sql.mapper;

import dev.amir.songservice.domain.entity.Song;
import dev.amir.songservice.framework.output.sql.entity.SongJpaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SongEntityMapper {
    Song convert(SongJpaEntity entity);

    SongJpaEntity convert(Song song);
}
