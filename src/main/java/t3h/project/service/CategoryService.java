package t3h.project.service;

import t3h.project.entities.CategoryEntity;

import java.util.List;

public interface CategoryService {
    List<CategoryEntity> getAllCata();
    CategoryEntity getCataById(Long id);
    CategoryEntity createCata(CategoryEntity cata);
    CategoryEntity updateCata(Long id, CategoryEntity c);
    String deleteCata(Long id);
}
