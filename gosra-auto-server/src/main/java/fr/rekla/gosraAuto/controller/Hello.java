package fr.rekla.gosraAuto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @GetMapping("/server")
    public String hello() {
        return "hello from gosra auto server...";
    }
}
