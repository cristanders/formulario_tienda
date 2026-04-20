package com.alejandromax.tienda.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@JsonPropertyOrder({
        "idProducto",
        "nombreProducto",
        "precioProducto",
        "stockProducto",
        "categoria"
})
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @NotBlank(message = "El nombre del producto no puede ir vacio.")
    @Size(min = 2, max = 80, message = "El nombre debe tener entre 2 y 60 caracteres.")
    @Column(name = "nombre_producto")
    private String nombreProducto;

    @NotNull(message = "El precio no puede ir vacio")
    @DecimalMin(value = "0.0", message = "El precio no puede ser negativo")
    @DecimalMax(value = "670000.0", message = "El precio excede el límite permitido")
    @Column(name = "precio_producto")
    private Float precioProducto;

    @NotNull(message = "El stock no puede ir vacio.")
    @Min(value = 0, message = "el stock debe ser mayor o igual a 0")
    @Max(value = 10120, message = "el stock debe ser menor o igual a 10120.")
    @Column(name = "stock")
    private Integer stockProducto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public @NotBlank(message = "El nombre del producto no puede ir vacio.") @Size(min = 2, max = 80, message = "El nombre debe tener entre 2 y 60 caracteres.") String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(@NotBlank(message = "El nombre del producto no puede ir vacio.") @Size(min = 2, max = 80, message = "El nombre debe tener entre 2 y 60 caracteres.") String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public @NotNull(message = "El precio no puede ir vacio") @DecimalMin(value = "0.0", message = "El precio no puede ser negativo") @DecimalMax(value = "670000.0", message = "El precio excede el límite permitido") Float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(@NotNull(message = "El precio no puede ir vacio") @DecimalMin(value = "0.0", message = "El precio no puede ser negativo") @DecimalMax(value = "670000.0", message = "El precio excede el límite permitido") Float precioProducto) {
        this.precioProducto = precioProducto;
    }

    public @NotNull(message = "El stock no puede ir vacio.") @Min(value = 0, message = "el stock debe ser mayor o igual a 0") @Max(value = 10120, message = "el stock debe ser menor o igual a 10120.") Integer getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(@NotNull(message = "El stock no puede ir vacio.") @Min(value = 0, message = "el stock debe ser mayor o igual a 0") @Max(value = 10120, message = "el stock debe ser menor o igual a 10120.") Integer stockProducto) {
        this.stockProducto = stockProducto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
