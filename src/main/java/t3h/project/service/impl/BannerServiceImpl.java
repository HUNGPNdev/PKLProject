package t3h.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import t3h.project.entities.BannerEntity;
import t3h.project.repository.BannerRepository;
import t3h.project.service.BannerService;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    BannerRepository banner;

    @Autowired
    ServletContext context;



    @Override
    public BannerEntity createBanner(MultipartFile file, String status) {
        BannerEntity b = null;
        try {
            String photoPath = context.getRealPath("images/"+file.getOriginalFilename());
            file.transferTo(new File(photoPath));
            b = new BannerEntity(file.getOriginalFilename(), Boolean.parseBoolean(status));
        } catch (Exception e) {
            System.err.println("Error while create banner");
        }
        return banner.save(b);
    }

    @Override
    public List<BannerEntity> getAllBanner() {
        List<BannerEntity> list = banner.findAll();
        return list;
    }

    @Override
    public BannerEntity getById(Long id) {
        return banner.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        banner.deleteById(id);
    }

    @Override
    public void updateById(MultipartFile file, String status, Long id) {
        BannerEntity b = banner.findById(id).get();
        b.setStatus(Boolean.parseBoolean(status));
        if (file!=null) {
            try {
                String photoPath = context.getRealPath("images/"+file.getOriginalFilename());
                file.transferTo(new File(photoPath));
                b.setName(file.getOriginalFilename());
            } catch (Exception e) {
                System.err.println("Error while create banner");
            }
        }
        banner.save(b);
    }

    @Override
    public List<BannerEntity> getStatusTrue() {
        return banner.getStatusTrue();
    }


}
