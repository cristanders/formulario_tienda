package com.alejandromax.tienda.controller;

import com.alejandromax.tienda.entity.Producto;
import com.alejandromax.tienda.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import com.alejandromax.tienda.service.CategoriaService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@Validated
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;
    private final CategoriaService categoriaService;

    public ProductoController(ProductoService productoService, CategoriaService categoriaService) {
        this.productoService = productoService;
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String lista(Model model) {
        model.addAttribute("productos", productoService.listar());
        return "productos";
    }

    // Método para abrir una vista
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaService.listar());
        model.addAttribute("modoEdicion", false);
        return "producto-formulario";
    }

    // Método para crear un nuevo producto
    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("producto") Producto producto, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("modoEdicion", producto.getIdProducto() != null);
            model.addAttribute("categorias", categoriaService.listar());
            return producto.getIdProducto() != null ? "producto-edicion" : "producto-formulario";
        }
        productoService.guardar(producto);
        return "redirect:/productos";
    }

    // Método para eliminar un producto
    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") Integer id) {
        productoService.eliminar(id);
        System.out.println( id + " eliminado ");
        return "redirect:/productos";
    }

    // Metodo para editar un producto
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Integer id, Model model) {
        Producto producto = productoService.obtenerPorId(id);

        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categoriaService.listar());
        model.addAttribute("modoEdicion", true);

        return "producto-edicion";
    }
}
