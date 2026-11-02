package br.unig.denunciadigital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index"; // vai procurar o arquivo index.html
    }

    @GetMapping("/info")
    public String info() {
        return "info"; // página informativa sobre direitos digitais
    }
}