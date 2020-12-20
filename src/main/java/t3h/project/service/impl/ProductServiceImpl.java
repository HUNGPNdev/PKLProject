package t3h.project.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import t3h.project.dto.ProCartDTO;
import t3h.project.dto.ProductDTO;
import t3h.project.entities.CartEntity;
import t3h.project.entities.ProductEntity;
import t3h.project.repository.CartRepository;
import t3h.project.repository.CategoryRepository;
import t3h.project.repository.ProductRepository;
import t3h.project.service.ProductService;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository proRepo;

    @Autowired
    CartRepository cartRp;

    @Autowired
    CategoryRepository cateRepo;

    @Autowired
    ServletContext context;

    @Override
    public void createProduct(MultipartFile file, String p) {
        String photoPath = context.getRealPath("images/" + file.getOriginalFilename());
        try {
            file.transferTo(new File(photoPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ProductEntity proEn = new ProductEntity();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ProductDTO proD = objectMapper.readValue(p, ProductDTO.class);
            proEn.setPro_name(proD.getPro_name());
            String slug = proD.getPro_name().trim().replaceAll("\\s{2,}", "-");
            proEn.setSlug(slug);
            proEn.setPrice(proD.getPrice());
            proEn.setDetails(proD.getDetails());
            proEn.setGuarantee(proD.getGuarantee());
            proEn.setPart(proD.getPart());
            proEn.setSupport(proD.getSupport());
            proEn.setImage(file.getOriginalFilename());
            proEn.setStatus(proD.isStatus());
            proEn.setCategory(cateRepo.findById(proD.getCata_id()).get());
            proRepo.save(proEn);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ProductDTO> getListPro() {
        List<ProductDTO> list = new ArrayList<>();
        for (ProductEntity p : proRepo.findAll()) {
            ProductDTO p2 = new ProductDTO(p.getPro_id(), p.getPro_name(), p.getPrice(), p.getDetails(), p.getGuarantee(), p.getPart(),
                    p.getSupport(), p.getImage(), p.isStatus(), p.getCategory().getCata_id(), p.getCategory().getCata_name());
            list.add(p2);
        }
        return list;
    }

    @Override
    public ProductDTO getProById(Long id) {
        ProductEntity p = proRepo.findById(id).get();
        ProductDTO proD = new ProductDTO(p.getPro_id(), p.getPro_name(), p.getPrice(), p.getDetails(), p.getGuarantee(), p.getPart(),
                p.getSupport(), p.getImage(), p.isStatus(), p.getCategory().getCata_id(), p.getCategory().getCata_name());
        return proD;
    }

    @Override
    public void updateById(MultipartFile file, String product) {
        String s = "";
        if (file != null) {
            try {
                String photoPath = context.getRealPath("images/" + file.getOriginalFilename());
                s = file.getOriginalFilename();
                file.transferTo(new File(photoPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        ProductEntity proEn = new ProductEntity();
        try {
            ProductDTO p = objectMapper.readValue(product, ProductDTO.class);
            proEn.setPro_id(p.getPro_id());
            proEn.setPro_name(p.getPro_name());
            String slug = p.getPro_name().trim().replaceAll("\\s{2,}", "-");
            proEn.setSlug(slug);
            proEn.setPrice(p.getPrice());
            proEn.setDetails(p.getDetails());
            proEn.setGuarantee(p.getGuarantee());
            proEn.setPart(p.getPart());
            proEn.setSupport(p.getSupport());
            if (s != "") {
                proEn.setImage(s);
            } else {
                proEn.setImage(p.getImage());
            }
            proEn.setStatus(p.isStatus());
            proEn.setCategory(cateRepo.findById(p.getCata_id()).get());
        } catch (Exception e) {
        }
        System.out.println(proEn.toString());
        proRepo.save(proEn);

    }

    @Override
    public void deleteById(Long id) {
        proRepo.deleteById(id);
    }

    @Override
    public List<ProductEntity> getProByCateId(Long id) {
        List<ProductEntity> list = proRepo.getProductEntityByCateId(id);
        return list;
    }

    @Override
    public List<ProCartDTO> getProductByUserId(int id) {
        List<ProCartDTO> listPro = new ArrayList<>();
        List<CartEntity> listC = cartRp.getListCartByUserId(id);
        for (CartEntity c: listC) {
            ProductEntity p = proRepo.findById(c.getPro_id()).get();
            listPro.add(new ProCartDTO(p.getPro_id(), p.getPro_name(), p.getPrice(),
                    p.getImage(), c.getQuantity()));
        }
        return listPro;
    }


}
