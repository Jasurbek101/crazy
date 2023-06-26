package uz.pdp.crazy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.crazy.controller.convert.VideoConvert;
import uz.pdp.crazy.entity.VideoEntity;
import uz.pdp.crazy.entity.dto.ApiResponse;
import uz.pdp.crazy.entity.dto.VideoRequestDTO;
import uz.pdp.crazy.exception.RecordNotFoundException;
import uz.pdp.crazy.repository.VideoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoService {
    private final VideoRepository videoRepository;

    public ApiResponse<VideoEntity> addVideo(VideoRequestDTO dto){
        if (dto == null) {
            throw new RecordNotFoundException(String.format("Video does't saved with name %s",dto.getName()));
        }

        VideoEntity savedVideo = videoRepository.save(VideoConvert.convertToEntity(dto));
        return ApiResponse.<VideoEntity>builder()
                .message(" Succesfully Added ")
                .success(true)
                .status(200)
                .data(savedVideo)
                .build();
    }

    public ApiResponse<VideoEntity> getOneVideo(Long id){
        VideoEntity videoEntity = videoRepository.findById(id).orElseThrow(
                () -> new RecordNotFoundException(String.format("Video not fount with id %s", id))
        );

        return ApiResponse.<VideoEntity>builder()
                .message(" Here !!! ")
                .status(200)
                .data(videoEntity)
                .success(true)
                .build();
    }

    public ApiResponse<List<VideoEntity>> getAllVideos(){
        List<VideoEntity> videos = videoRepository.findAll();

        return ApiResponse.<List<VideoEntity>>builder()
                .message(" Here !!! ")
                .status(200)
                .data(videos)
                .success(true)
                .build();
    }

    public ApiResponse<VideoEntity> deleteVideo(Long id){
        VideoEntity deletedVideo = videoRepository.findById(id).orElseThrow(
                () -> new RecordNotFoundException(String.format("Video not fount with id %s", id))
        );
        videoRepository.delete(deletedVideo);
        return ApiResponse.<VideoEntity>builder()
                .message(" Deleted !!! ")
                .status(200)
                .data(deletedVideo)
                .success(true)
                .build();
    }

}