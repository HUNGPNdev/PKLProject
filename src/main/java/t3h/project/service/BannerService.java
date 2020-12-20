package t3h.project.service;

import org.springframework.web.multipart.MultipartFile;
import t3h.project.entities.BannerEntity;

import java.util.List;

public interface BannerService {
    BannerEntity createBanner(MultipartFile file, String status);
    List<BannerEntity> getAllBanner();
    BannerEntity getById(Long id);
    void deleteById(Long id);
    void updateById(MultipartFile file, String status, Long id);
    List<BannerEntity> getStatusTrue();
}
