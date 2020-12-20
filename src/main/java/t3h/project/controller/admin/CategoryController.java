package t3h.project.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import t3h.project.entities.CategoryEntity;
import t3h.project.service.impl.CategoryServiceImpl;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin/")
public class CategoryController {

    @Autowired
    CategoryServiceImpl categoryService;

    @GetMapping("/category")
    public List<CategoryEntity> getAll() {
        return categoryService.getAllCata();
    }

    @PostMapping("/category")
    public CategoryEntity createCategory(@RequestBody CategoryEntity c) {
        return categoryService.createCata(c);
    }

    @GetMapping("/category/{id}")
    public CategoryEntity getCategoryById(@PathVariable("id") Long id) {
        return categoryService.getCataById(id);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<CategoryEntity> editCategory(@PathVariable("id") Long id, @RequestBody CategoryEntity categoryEntity) {
        return ResponseEntity.ok(categoryService.updateCata(id, categoryEntity));
    }

    @DeleteMapping("/category/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        return categoryService.deleteCata(id);
    }
}
