package br.espm.poo.backend.service;

import br.espm.poo.backend.dataype.UserBean;
import br.espm.poo.backend.model.UserModel;
import br.espm.poo.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserBean> listAll() {
        return StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList())
                .stream().map(UserModel::to)
                .collect(Collectors.toList());
    }

    public UserBean findBy(UUID id) {
        return userRepository.findById(id.toString()).map(userModel -> userModel.to()).orElse(null);

    }

    public UserBean create(UserBean user) {
        user.setId(UUID.randomUUID());
        return userRepository.save(new UserModel(user)).to();
    }

    public List<UserBean> listByName(String name){
        return userRepository.listByUserName(name)
                .stream().map(UserModel::to)
                .collect(Collectors.toList());
    }

    public void delete(UUID id) {
        userRepository.deleteById(id.toString());
    }
}
