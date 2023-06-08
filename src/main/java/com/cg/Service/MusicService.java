package com.cg.Service;

import com.cg.Entity.Music;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MusicService {

    @Transactional()
    ResponseEntity<String> addSingleSong(Music musicData);

    public ResponseEntity<List> getListOfAllSongs();

    public ResponseEntity<Music> getDetailsOfSpecificSong(String songName);

    //public ResponseEntity<String> addBatchSongs();

    @Transactional()
    public ResponseEntity<String> updateSongDetails(Music song);

    public ResponseEntity<String> deleteSpecificSong(String songName);

    //public ResponseEntity<String> deleteBatchSongs();
}
