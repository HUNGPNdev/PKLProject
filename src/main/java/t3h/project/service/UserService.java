package t3h.project.service;

import t3h.project.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUser();
    UserDTO getUserById(Long id);
    void updateUser(UserDTO user);
    UserDTO getUserByName(String name);
    void deleteById(Long id);
}
