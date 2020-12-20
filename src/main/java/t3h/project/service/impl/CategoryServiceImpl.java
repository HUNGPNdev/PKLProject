package t3h.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import t3h.project.entities.CategoryEntity;
import t3h.project.repository.CategoryRepository;
import t3h.project.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository cateRepo;

    @Override
    public List<CategoryEntity> getAllCata() {
        return cateRepo.findAll();
    }

    @Override
    public CategoryEntity getCataById(Long id) {
        return cateRepo.findById(id).get();
    }

    @Override
    public CategoryEntity createCata(CategoryEntity c) {
        String slug = c.getCata_name().trim().replaceAll("\\s{2,}", "-");
        System.out.println(c.isStatus());
        CategoryEntity cate = new CategoryEntity(c.getCata_name(), slug, c.isStatus());
        return cateRepo.save(cate);
    }

    @Override
    public CategoryEntity updateCata(Long id, CategoryEntity c) {
        CategoryEntity cate = c;
        cate.setCata_id(id);
        String slug = c.getCata_name().trim().replaceAll("\\s{2,}", "-");
        cate.setSlug(slug);
        return cateRepo.save(cate);
    }

    @Override
    public String deleteCata(Long id) {
        cateRepo.deleteById(id);
        return "";
    }
}
