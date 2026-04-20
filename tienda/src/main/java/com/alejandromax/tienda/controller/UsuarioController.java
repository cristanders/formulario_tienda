package com.alejandromax.tienda.controller;

import com.alejandromax.tienda.entity.Usuario;
import com.alejandromax.tienda.repository.UsuarioRepository;
import com.alejandromax.tienda.service.UsuarioService;
import com.alejandromax.tienda.service.UsuarioServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Validated
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Método para listar los registros
    @GetMapping
    public String lista(Model model) {
        model.addAttribute("usuarios", usuarioService.listar());
        return "usuarios";
    }

    // Método para abrir una vista
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("modeEdicion", false);
        return "usuario-formulario";
    }

    // Método para crear un nuevo usuario
    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("modoEdicion", usuario.getIdUsuario() != null);
            return usuario.getIdUsuario() != null ? "usuario-edicion" : "usuario-formulario";
        }
        usuarioService.guardar(usuario);
        return "redirect:/usuarios";
    }

    // Método para eliminar un usuario
    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable("id") Integer id) {
        usuarioService.eliminar(id);
        System.out.println( id + " eliminado ");
        return "redirect:/usuarios";
    }

    // Metodo para editar un usuario
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Integer id, Model model) {
        Usuario usuario = usuarioService.obtenerPorId(id);

        model.addAttribute("usuario", usuario);
        model.addAttribute("modoEdicion", true);

        return "usuario-edicion";
    }
}