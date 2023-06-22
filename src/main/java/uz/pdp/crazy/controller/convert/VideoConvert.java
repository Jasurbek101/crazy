package uz.pdp.crazy.controller.convert;

import lombok.experimental.UtilityClass;
import uz.pdp.crazy.entity.VideoEntity;
import uz.pdp.crazy.entity.dto.VideoRequestDTO;

@UtilityClass
public class VideoConvert {
    public VideoEntity convertToEntity(VideoRequestDTO videoRequestDTO){
        return VideoEntity.builder()
                .name(videoRequestDTO.getName())
                .url(videoRequestDTO.getUrl())
                .build();
    }
}
