package t3h.project.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import t3h.project.entities.BannerEntity;
import t3h.project.service.BannerService;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin/")
public class BannerController {

    @Autowired
    BannerService banner;

    @PostMapping("banner")
    public BannerEntity createBanner(@RequestParam("myFile") MultipartFile file, @RequestParam("status") String status) {
        return banner.createBanner(file, status);
    }

    @GetMapping("banner")
    public List<BannerEntity> getAllBanner() {
        return banner.getAllBanner();
    }
    @GetMapping("banner/{id}")
    public BannerEntity getById(@PathVariable("id") Long id) {
        return banner.getById(id);
    }

    @PutMapping("banner/{id}")
    public void updateById(@RequestParam(value = "myFile", required=false) MultipartFile file, @RequestParam("status") String status
            , @PathVariable("id") Long id) {
        banner.updateById(file, status, id);
    }

    @DeleteMapping("banner/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        banner.deleteById(id);
    }
}
