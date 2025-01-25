package com.crio.videorental.controller;

import com.crio.videorental.model.Video;
import com.crio.videorental.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private VideoService videoService;
    @GetMapping("/getAvailableVideos")
    public ResponseEntity<List<Video>> getAvailableVideos(){
        return ResponseEntity.ok(videoService.getAvailableVideos());
    }
}
