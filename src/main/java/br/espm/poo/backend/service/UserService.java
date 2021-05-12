package br.espm.poo.backend.service;

import br.espm.poo.backend.dataype.UserBean;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserService {
    private static Map<UUID, UserBean> users = new HashMap<>();

    static {
        UserBean u1 = new UserBean(UUID.randomUUID(), "1berto");
        UserBean u2 = new UserBean(UUID.randomUUID(), "2berto");
        UserBean u3 = new UserBean(UUID.randomUUID(), "3berto");
        UserBean u4 = new UserBean(UUID.randomUUID(), "4berto");
        users.put(u1.getId(), u1);
        users.put(u2.getId(), u2);
        users.put(u3.getId(), u3);
        users.put(u4.getId(), u4);
    };

    public List<UserBean> listAll() {
        return new ArrayList<>(users.values());
    }

    public UserBean findBy(UUID id) {
        return users.get(id);
    }

    public UserBean create(UserBean user) {
        if (user.getId() == null) {
            user.setId(UUID.randomUUID());
        }
        users.put(user.getId(), user);
        return user;
    }

    public void delete(UUID id) {
        users.remove(id);
    }
}
