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

    public VideoEntity addVideo(VideoRequestDTO dto) {
        if (dto == null) {
            throw new RecordNotFoundException(String.format("Video does't saved with name %s", dto.getName()));
        }
        return videoRepository.save(VideoConvert.convertToEntity(dto));
    }

    public VideoEntity getOneVideo(Long id) {
        return videoRepository.findById(id).orElseThrow(
                () -> new RecordNotFoundException(String.format("Video not fount with id %s", id))
        );
    }

    public List<VideoEntity> getAllVideos() {
        return videoRepository.findAll();
    }

    public VideoEntity deleteVideo(Long id) {
        VideoEntity deletedVideo = videoRepository.findById(id).orElseThrow(
                () -> new RecordNotFoundException(String.format("Video not fount with id %s", id))
        );
        videoRepository.delete(deletedVideo);
        return deletedVideo;
    }

}