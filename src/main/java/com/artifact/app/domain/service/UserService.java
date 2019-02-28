package com.artifact.app.domain.service;

import com.artifact.app.domain.entity.User;
import com.artifact.app.domain.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepo repository;

    public List<User> getAll(){
        return repository.findAll();
    }

    public User getByUsername(String username){
        return repository.findUserByUsername(username);
    }

    public User getById(Long id){
        return repository.findById(id).get();
    }

    public User save(User user){
        return repository.save(user);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return repository.findUserByUsername(s);
    }
}
