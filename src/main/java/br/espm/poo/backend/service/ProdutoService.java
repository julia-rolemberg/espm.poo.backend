package br.espm.poo.backend.service;

import br.espm.poo.backend.dataype.ProdutoBean;
import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class ProdutoService {

    private static Map<UUID, ProdutoBean> products = new HashMap<>();

    static {
        ProdutoBean p1 = new ProdutoBean(UUID.randomUUID(), "produto1");
        products.put(p1.getId(), p1);

    };

    public List<ProdutoBean> listAll() {
        return new ArrayList<>(products.values());
    }

    public ProdutoBean findBy(UUID id) {
        return products.get(id);
    }

    public ProdutoBean create(ProdutoBean user) {
        if (user.getId() == null) {
            user.setId(UUID.randomUUID());
        }
        products.put(user.getId(), user);
        return user;
    }

    public void delete(UUID id) {
        products.remove(id);
    }

}
