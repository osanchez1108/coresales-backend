package com.coresales.service.user.auth.service;

import com.coresales.service.user.auth.model.User;
import com.coresales.service.user.auth.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> listar(){
        return userRepository.findAll();
    }

    public Optional<User> buscarPorId(Long id){
        return userRepository.findById(id);
    }

    public User crear(User user){
        return userRepository.save(user);
    }

    public User actualizar(User user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public Optional<User> findByUsername(String username){
        return  userRepository.findByUsername(username);
    }
}
