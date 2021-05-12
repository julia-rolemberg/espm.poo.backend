package br.espm.poo.backend.dataype;

import java.util.UUID;

public class ProdutoBean {

    private UUID id;
    private String name;


    public ProdutoBean(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProdutoBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
