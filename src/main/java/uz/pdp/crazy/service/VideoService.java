package uz.pdp.crazy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.crazy.entity.VideoEntity;
import uz.pdp.crazy.repository.VideoRepository;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class VideoService {
    private final VideoRepository videoRepository;

}