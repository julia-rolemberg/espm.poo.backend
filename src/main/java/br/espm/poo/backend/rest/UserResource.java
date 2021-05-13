package br.espm.poo.backend.rest;

import br.espm.poo.backend.exception.RecordNotFoundException;
import br.espm.poo.backend.dataype.UserBean;
import br.espm.poo.backend.model.UserModel;
import br.espm.poo.backend.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/users")
    public List<UserBean> listAll() {
        return userService.listAll();
    }

    @GetMapping(path = "/users/{id}")
    public UserBean findBy(@PathVariable UUID id) {
        UserBean foundUser = userService.findBy(id);
        if (foundUser == null) {
            throw new RecordNotFoundException(id.toString());
        }
        return foundUser;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<Object> save(@RequestBody UserBean user) {

       UserBean savedUser =  userService.create(user);

       URI location = ServletUriComponentsBuilder
               .fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(savedUser.getId().toString())
               .toUri();
       return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteBy(@PathVariable UUID id) {
        userService.delete(id);
    }
}
