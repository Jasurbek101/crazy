package uz.pdp.crazy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.crazy.entity.VideoEntity;
import uz.pdp.crazy.entity.dto.ApiResponse;
import uz.pdp.crazy.entity.dto.VideoRequestDTO;
import uz.pdp.crazy.service.VideoService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/video")
@RequiredArgsConstructor
public class VideoController {
    private final VideoService videoService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_SUPERADMIN')")
    public ResponseEntity<?> addVideo(@RequestBody VideoRequestDTO video){
        ApiResponse<VideoEntity> addVideo = videoService.addVideo(video);
        return ResponseEntity.status(addVideo.getStatus()).body(addVideo);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getOneVideo(@PathVariable Long id){
        ApiResponse<VideoEntity> addVideo = videoService.getOneVideo(id);
        return ResponseEntity.status(addVideo.getStatus()).body(addVideo);
    }

    @GetMapping
    public ResponseEntity<?> getAllVideo(){
        ApiResponse<List<VideoEntity>> allVideos = videoService.getAllVideos();
        return ResponseEntity.status(allVideos.getStatus()).body(allVideos);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_SUPERADMIN')")
    public ResponseEntity<?> deleteVideo(@PathVariable Long id){
        ApiResponse<VideoEntity> video = videoService.deleteVideo(id);
        return ResponseEntity.status(video.getStatus()).body(video);
    }
}
