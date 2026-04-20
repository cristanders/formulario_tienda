package com.alejandromax.tienda.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    @NotBlank(message = "El nombre del producto no puede ir vacio.")
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres.")
    @Column(name = "nombre_categoria")
    private String nombreCategoria;

    @NotBlank(message = "El nombre del producto no puede ir vacio.")
    @Size(min = 2, max = 150, message = "El nombre debe tener entre 2 y 150 caracteres.")
    @Column(name = "descripcion_categoria")
    private String descripcionCategoria;

    public @NotBlank(message = "El nombre del producto no puede ir vacio.") @Size(min = 2, max = 150, message = "El nombre debe tener entre 2 y 150 caracteres.") String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(@NotBlank(message = "El nombre del producto no puede ir vacio.") @Size(min = 2, max = 150, message = "El nombre debe tener entre 2 y 150 caracteres.") String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public @NotBlank(message = "El nombre del producto no puede ir vacio.") @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres.") String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(@NotBlank(message = "El nombre del producto no puede ir vacio.") @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres.") String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}
