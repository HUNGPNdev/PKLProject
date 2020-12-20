package t3h.project.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import t3h.project.dto.UserDTO;
import t3h.project.service.impl.UserDetailsServiceImpl;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin/")
public class UserController {

    @Autowired
    UserDetailsServiceImpl userSv;

    @GetMapping("/user")
    public ResponseEntity<List<UserDTO>> getAllUser() {
        return ResponseEntity.ok(userSv.getAllUser());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userSv.getUserById(id));
    }

    @PutMapping("user/{id}")
    public void updateUser(@RequestBody UserDTO user) {
        userSv.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        userSv.deleteById(id);
    }
}
