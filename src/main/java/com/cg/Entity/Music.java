package com.cg.Entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int songId;
    @NonNull
    private String songName;
    private String language;
    @NonNull
    private int duration;
    private String artistName;
    private String genre;

}
