package com.api.crud.services;

import com.api.crud.models.UserModel;
import com.api.crud.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepository iUserRepository;

    public ArrayList<UserModel> getAllUsers() {
        return (ArrayList<UserModel>) iUserRepository.findAll();
    }

    public UserModel saveUser(UserModel user) {
        return iUserRepository.save(user);
    }

    public Optional<UserModel> getUserById(Long id) {
        return iUserRepository.findById(id);
    }

    public UserModel updateById(UserModel request, Long id) {
        UserModel modelUser = iUserRepository.findById(id).get();
        modelUser.setLastName(request.getLastName());
        modelUser.setFirstName(request.getFirstName());
        modelUser.setEmail(request.getEmail());
        return modelUser;
    }

    public boolean deteleUserByID(Long id) {
        try{
            iUserRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
