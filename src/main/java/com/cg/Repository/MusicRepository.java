package com.cg.Repository;

import com.cg.Entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends JpaRepository<Music, String> {

    @Query("select m from Music m where m.songName = ?1")
    public Music getSpecificSong(String songName);

}
