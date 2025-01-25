package com.crio.videorental.controller;

import com.crio.videorental.model.Video;
import com.crio.videorental.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private VideoService videoService;

    @PostMapping("/createVideo")
    public ResponseEntity<Video> createVideo(@RequestBody Video video) {
        return ResponseEntity.ok(videoService.save(video));
    }

    @PutMapping("/updateVideo/{id}")
    public ResponseEntity<String> updateVideo(@PathVariable Long id, @RequestBody Video videoDetails) {
        if (videoService.updateVideo(id, videoDetails)) {
            return ResponseEntity.ok("Video updated successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/deleteVideo/{id}")
    public ResponseEntity<String> deleteVideo(@PathVariable Long id) {
        videoService.deleteById(id);
        return ResponseEntity.ok("Video deleted successfully");
    }
}

