package com.cg.Service;

import com.cg.Entity.Music;
import com.cg.Repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MusicServiceImplementation implements MusicService{

    @Autowired
    private MusicRepository musicRepo;

    @Override
    @Transactional()
    public ResponseEntity<String> addSingleSong(Music musicData) {
        if (musicData != null)
            musicRepo.save(musicData);
        return new ResponseEntity<>("Song added Successfully", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List> getListOfAllSongs() {
        Optional<List<Music>> songListHolder = Optional.of(musicRepo.findAll());
        List<Music> listOfSongs = songListHolder.orElse(null);
        if(listOfSongs.isEmpty())
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(listOfSongs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Music> getDetailsOfSpecificSong(String songName) {
        Music requestedSong = Optional.of(musicRepo.getSpecificSong(songName)).orElse(null);
        if(requestedSong != null)
            return new ResponseEntity<>(requestedSong, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    @Transactional()
    public ResponseEntity<String> updateSongDetails(Music song) {

        Music songToUpdate = Optional.of(musicRepo.getSpecificSong(song.getSongName())).orElse(null);
        if(songToUpdate != null){
            songToUpdate.setSongName(song.getSongName());
            songToUpdate.setDuration(song.getDuration());
            songToUpdate.setLanguage(song.getLanguage());
            songToUpdate.setGenre(song.getGenre());
            songToUpdate.setArtistName(song.getArtistName());
            musicRepo.save(songToUpdate);
            return new ResponseEntity<>("Song Updated Successfully!!!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("No Song Found To Update", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> deleteSpecificSong(String songName) {

        Music songToDelete = Optional.of(musicRepo.getSpecificSong(songName)).orElse(null);
        musicRepo.delete(songToDelete);

        if(songToDelete != null)
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        return new ResponseEntity<>("No Song Found To Delete", HttpStatus.NOT_FOUND);
    }
}
