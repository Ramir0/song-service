package dev.amir.songservice.framework.output.sql.repository;

import dev.amir.songservice.framework.output.sql.entity.SongJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface SongRepository extends CrudRepository<SongJpaEntity, Long> {
    Collection<SongJpaEntity> findAllByIdIn(Collection<Long> id);
}
