package ee.bcs.valiit.bronapp.service;

import ee.bcs.valiit.bronapp.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    public User get(Long id) {
        return userRepository.getOne(id);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void register(User user) {
        userRoleRepository.save(new UserRole(userRepository.save(user).getId(), roleRepository.findByName("bronapp.user").getId()));
    }

    public List<User> list() {
        return userRepository.findAll();
    }

}