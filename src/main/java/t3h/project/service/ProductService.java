package t3h.project.service;

import org.springframework.web.multipart.MultipartFile;
import t3h.project.dto.ProCartDTO;
import t3h.project.dto.ProductDTO;
import t3h.project.entities.ProductEntity;

import java.util.List;

public interface ProductService{
    void createProduct(MultipartFile file, String p);
    List<ProductDTO> getListPro();
    ProductDTO getProById(Long id);
    void updateById(MultipartFile file, String product);
    void deleteById(Long id);
    List<ProductEntity> getProByCateId(Long id);
    List<ProCartDTO> getProductByUserId(int id);
}
