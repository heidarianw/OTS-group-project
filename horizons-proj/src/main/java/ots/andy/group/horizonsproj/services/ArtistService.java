//package com.solo.lastFmProject.service;
//
//import com.solo.lastFmProject.connector.LastFMConnector;
//import com.solo.lastFmProject.exception.ArtistServiceException;
//import com.solo.lastFmProject.model.Artist;
//import com.solo.lastFmProject.model.Summary;
//import com.solo.lastFmProject.repository.ArtistRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ArtistService {
//
//    @Autowired
//    private ArtistRepository artistRepository;
//
//    @Autowired
//    private LastFMConnector lastFMConnector;
//
//    @Autowired
//    private TagService tagService;
//
//
//    public List<Artist> getAllArtists(){
//        return artistRepository.findAll();
//    }
//
//    public void addArtist(Artist artist){
//        if(artistRepository.findByName(artist.getName()) != null){
//            throw new ArtistServiceException("Cannot add duplicate artists");
//        }
//        tagService.addArtistTagsToMap(artist.getName());
//        artistRepository.save(artist);
//    }
//
//    public Summary getSummaryByArtistName(String name){
//        if(artistRepository.findByName(name) == null){
//            throw new ArtistServiceException("Cannot find summary, artist does not exist");
//        }
//        Summary summary = new Summary();
//        summary.setSummary(lastFMConnector.getArtistInfo(name).getArtist().getBio().getSummary());
//        return summary;
//    }
//}
