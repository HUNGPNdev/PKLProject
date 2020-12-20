package t3h.project.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import t3h.project.dto.OrderDTO;
import t3h.project.dto.ProCartDTO;
import t3h.project.dto.ProductDTO;
import t3h.project.dto.UserDTO;
import t3h.project.entities.BannerEntity;
import t3h.project.entities.CartEntity;
import t3h.project.entities.CategoryEntity;
import t3h.project.entities.ProductEntity;
import t3h.project.repository.CartRepository;
import t3h.project.service.*;
import t3h.project.service.impl.CartSv;
import t3h.project.service.impl.CategoryServiceImpl;
import t3h.project.service.impl.OrderServiceImpl;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4201")
@RestController
@RequestMapping("/user/")
public class HomController {

    @Autowired
    CategoryServiceImpl categoryService;

    @Autowired
    ProductService proSv;

    @Autowired
    CartService cartSv;

    @Autowired
    CartRepository cartRp;

    @Autowired
    BannerService banner;

    @Autowired
    UserService userSv;

    @Autowired
    OrderService orderSv;

    @Autowired
    OrderServiceImpl odIm;

    @GetMapping("catagory")
    public List<CategoryEntity> getAllCata() {
        return categoryService.getAllCata();
    }

    @GetMapping("bannerShow")
    public ResponseEntity<List<BannerEntity>> getAllBanner(){
        return ResponseEntity.ok(banner.getStatusTrue());
    }

    @GetMapping("product")
    public ResponseEntity<List<ProductDTO>> getListPro() {
        return ResponseEntity.ok(proSv.getListPro());
    }

    @GetMapping("product/{id}")
    public ResponseEntity<ProductDTO> getProById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(proSv.getProById(id));
    }

    @GetMapping("catagory/{id}")
    public List<ProductEntity> getProByCateId(@PathVariable("id") Long id) {
        return proSv.getProByCateId(id);
    }

    @GetMapping("{name}")
    public ResponseEntity<UserDTO> getUserByName(@PathVariable("name") String name) {
        System.out.println(userSv.getUserByName(name));
        return ResponseEntity.ok(userSv.getUserByName(name));
    }

    @PutMapping("")
    public void updateUser(@RequestBody UserDTO user) {
        System.out.println(user);
        userSv.updateUser(user);
    }

    @PostMapping("cart")
    public void postToCart(@RequestBody CartEntity cart) {
        cartSv.addCart(cart);
    }

    @GetMapping("cart-list/{id}")
    public ResponseEntity<List<ProCartDTO>> getCartByUserId(@PathVariable("id") int id) {
        return ResponseEntity.ok(proSv.getProductByUserId(id));
    }

    @PutMapping("cart/{id}")
    public void updateCart(@PathVariable("id") int pro_id, @RequestParam("user_id") int user_id, @RequestParam("count") int count) {
        cartSv.update(user_id, pro_id, count);
    }

    @DeleteMapping("cart-delete/{user_id}/{pro_id}")
    public void deleteCart(@PathVariable("user_id") int user_id, @PathVariable("pro_id") Long pro_id) {
        cartSv.deleteCart(user_id, pro_id);
    }

    @PostMapping("order/{id}")
    public void order(@RequestBody List<OrderDTO> order, @PathVariable("id") int id) {
        orderSv.addOrder(id, order);
    }

    @GetMapping("order/{id}")
    public ResponseEntity<List<OrderDTO>> getListOrder(@PathVariable("id") int user_id) {
        return ResponseEntity.ok(orderSv.getListOrder(user_id));
    }
}
