package com.challenge.hmvfiap.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/test/login")
public class TestaLoginController {

    @GetMapping()
    public String login() {
        return "Logado!";
    }
}
