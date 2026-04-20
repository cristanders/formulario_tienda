package com.alejandromax.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.security.autoconfigure.SecurityProperties;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @Autowired
    private InMemoryUserDetailsManager userDetailsManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String mostrarRegistro() {
        return "register";
    }

    @PostMapping("/register")
    public String registrarUsuario(@RequestParam("username") String usuario,
                                   @RequestParam("password") String contrasena,
                                   Model model) {


        String usuarioRegistrado = usuario.trim();

        var registrar = org.springframework.security.core.userdetails.User.builder()
                .username(usuarioRegistrado)
                .password(passwordEncoder.encode(contrasena))
                .roles("USER")
                .build();


        userDetailsManager.createUser(registrar);
        System.out.println("Usuario creado: " + usuarioRegistrado);
        System.out.println("contraseña creado: " + contrasena);


        return "redirect:/login";
    }
}