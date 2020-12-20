package t3h.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import t3h.project.dto.SignUpForm;
import t3h.project.dto.UserDTO;
import t3h.project.entities.Role;
import t3h.project.entities.RoleName;
import t3h.project.entities.UserEntity;
import t3h.project.repository.RoleRepository;
import t3h.project.repository.UserRepository;
import t3h.project.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService, UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;



    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));

        return UserPrinciple.build(user);
    }


    @Override
    public List<UserDTO> getAllUser() {
        List<UserDTO> list = new ArrayList<>();
        for(UserEntity u: userRepository.findAll()) {
            List<String> role = new ArrayList<>();
            for(Role r: u.getRoles()) {
                role.add(String.valueOf(r.getName()));
            }
            list.add(new UserDTO(u.getUser_id(), u.getName(), u.getUsername(), u.getEmail(), role, u.getPassword()));
        }
        return list;
    }

    @Override
    public UserDTO getUserById(Long id) {
        UserEntity u = userRepository.findById(id).get();
        UserDTO user = new UserDTO(u.getUser_id(), u.getName(), u.getUsername(), u.getEmail());
        List<String> role = new ArrayList<>();
        for(Role r: u.getRoles()) {
            role.add(String.valueOf(r.getName()));
        }
        user.setRole(role);
        return user;
    }

    @Override
    public void updateUser(UserDTO user) {
        UserEntity u = userRepository.findById(user.getId()).get();
        u.setName(user.getName());
        u.setUsername(user.getUsername());
        u.setEmail(user.getEmail());
        if (user.getPassword() != null) {
            u.setPassword(encoder.encode(user.getPassword()));
        }
        List<Role> roles = new ArrayList<>();
        for (String role: user.getRole()) {
            switch (role) {
                case "ROLE_ADMIN":
                    Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(adminRole);

                    break;
                case "ROLE_PM":
                    Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(pmRole);

                    break;
                default:
                    Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(userRole);
            }
        }
        u.setRoles(roles);
        userRepository.save(u);
    }

    @Override
    public UserDTO getUserByName(String name) {
        UserEntity ue = userRepository.findByUsername(name).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found with -> username or email : " + name));
        UserDTO u = new UserDTO(ue.getUser_id(), ue.getName(), ue.getUsername(), ue.getEmail());
        return u;
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }


}
