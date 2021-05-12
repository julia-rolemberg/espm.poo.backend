package br.espm.poo.backend.rest;

import br.espm.poo.backend.dataype.MessageBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

public class HelloResource {

//     @RequestMapping(method = RequestMethod.GET, path = "/hello")
    @GetMapping(path = "/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping(path = "/html")
    public String html() {
        return "<p style='color:red'>Hello World!</p>: Feliz Springboot";
    }

    @GetMapping(path = "/mensagem")
    public MessageBean message() {
        MessageBean m = new MessageBean();
        m.setMessage("Bom dia!");
        return m;
    }
}
