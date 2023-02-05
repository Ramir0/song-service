package dev.amir.songservice.framework.output.sql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "songs")
@NoArgsConstructor
@AllArgsConstructor
public class SongJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long resourceId;
    @Column
    private String name;
    @Column
    private String artist;
    @Column
    private String album;
    @Column
    private String length;
    @Column
    private Integer year;
}
