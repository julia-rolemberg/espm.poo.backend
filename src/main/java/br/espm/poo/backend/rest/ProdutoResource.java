package br.espm.poo.backend.rest;


import br.espm.poo.backend.dataype.ProdutoBean;
import br.espm.poo.backend.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping(path = "/products")
    public List<ProdutoBean> listAll() {
        return produtoService.listAll();
    }

    @GetMapping(path = "/products/{id}")
    public ProdutoBean findBy(@PathVariable UUID id) {
        return produtoService.findBy(id);
    }

    @PostMapping(path = "/products")
    public void save(@RequestBody ProdutoBean user) {
        produtoService.create(user);
    }

    @DeleteMapping(path = "/products/{id}")
    public void deleteBy(@PathVariable UUID id) {
        produtoService.delete(id);
    }
}
