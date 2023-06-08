package com.cg.Controller;

import com.cg.Entity.Music;
import com.cg.Service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicDirectory")
public class MusicController {

    @Autowired
    private MusicService musicService;

    @PostMapping("/add-music")
    public ResponseEntity<String> addSingleSong(@RequestBody Music song) {
        return musicService.addSingleSong(song);
    }

    @GetMapping("/getSong")
    public ResponseEntity<Music> getSpecificSong(@RequestParam String songName) {
        return musicService.getDetailsOfSpecificSong(songName);
    }

    @GetMapping("/getSongsList")
    public ResponseEntity<List> getListOfSongs() {
        return musicService.getListOfAllSongs();
    }

    @PutMapping("/updateSong")
    public ResponseEntity<String> updateSpecificSong(@RequestBody Music song) {
        return musicService.updateSongDetails(song);
    }

    @DeleteMapping("/deleteSong")
    public ResponseEntity<String> deleteSpecificSong(@RequestParam String songName) {
        return musicService.deleteSpecificSong(songName);
    }

}
