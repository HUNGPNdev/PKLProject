package t3h.project.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import t3h.project.dto.OrderDTO;
import t3h.project.dto.ProductDTO;
import t3h.project.repository.OrderRepository;
import t3h.project.service.OrderService;
import t3h.project.service.ProductService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class ProductController {

    @Autowired
    OrderService odSv;

    @Autowired
    ProductService proSv;

    @Autowired
    OrderRepository orderRp;

    @PostMapping("/product")
    public void createProduct(@RequestParam("file") MultipartFile file, @ModelAttribute("product") String p) {
        proSv.createProduct(file, p);
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductDTO>> getAllproduct() {
        return ResponseEntity.ok(proSv.getListPro());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(proSv.getProById(id));
    }

    @PutMapping("/product")
    public void updateById(@RequestParam(value = "file", required=false) MultipartFile file, @ModelAttribute("product") String product){
        proSv.updateById(file, product);
    }

    @DeleteMapping("/product/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        proSv.deleteById(id);
    }

    @GetMapping("/order")
    public ResponseEntity<List<OrderDTO>> adminGetOrder() {
        return ResponseEntity.ok(odSv.adminGetAllOrder());
    }

    @DeleteMapping("/order/{id}")
    public void deleteOrder(@PathVariable("id") Long id) {
        orderRp.deleteById(id);
    }
}
