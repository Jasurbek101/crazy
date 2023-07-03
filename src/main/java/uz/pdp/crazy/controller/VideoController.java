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
    @PreAuthorize(value = "hasRole('ROLE_ADMIN') || hasRole('ROLE_SUPERADMIN')")
    public ApiResponse<VideoEntity> addVideo(@RequestBody VideoRequestDTO video){
        VideoEntity savedVideoEntity = videoService.addVideo(video);
        return ApiResponse.<VideoEntity>builder()
                .message(" Succesfully Added ")
                .success(true)
                .status(200)
                .data(savedVideoEntity)
                .build();
    }


    @GetMapping("/{id}")
    public ApiResponse<VideoEntity> getOneVideo(@PathVariable Long id){
        VideoEntity videoEntity = videoService.getOneVideo(id);
        return ApiResponse.<VideoEntity>builder()
                .message(" Here !!! ")
                .status(200)
                .data(videoEntity)
                .success(true)
                .build();
    }

    @GetMapping
    public ApiResponse<List<VideoEntity>> getAllVideo(){
        List<VideoEntity> allVideos = videoService.getAllVideos();
        return ApiResponse.<List<VideoEntity>>builder()
                .message(" Here !!! ")
                .status(200)
                .data(allVideos)
                .success(true)
                .build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN') || hasRole('ROLE_SUPERADMIN')")
    public ApiResponse<VideoEntity> deleteVideo(@PathVariable Long id){
        VideoEntity deleteVideo = videoService.deleteVideo(id);
        return ApiResponse.<VideoEntity>builder()
                .message(" Deleted !!! ")
                .status(200)
                .data(deleteVideo)
                .success(true)
                .build();
    }
}
