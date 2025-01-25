package com.crio.videorental.service;

import com.crio.videorental.model.Video;
import com.crio.videorental.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {
    @Autowired
    private VideoRepository videoRepository;

    public List<Video> getAvailableVideos(){
        return videoRepository.findByAvailableTrue();
    }
    public Video save(Video requestVideo){
        return videoRepository.save(requestVideo);
    }
    public boolean updateVideo(Long id, Video videoDetails) throws RuntimeException{
        Optional<Video> foundVideoEntity=videoRepository.findById(id);
        if(foundVideoEntity.isPresent()){
            var entity=foundVideoEntity.get();
            entity.setTitle(videoDetails.getTitle());
            entity.setDirector(videoDetails.getDirector());
            entity.setGenre(videoDetails.getGenre());
            videoRepository.save(entity);
            return true;
        }
        return false;
    }
    public void deleteById(Long id){
        videoRepository.deleteById(id);
    }
}
