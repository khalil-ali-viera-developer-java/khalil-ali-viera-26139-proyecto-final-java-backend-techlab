package com.elviejomolino.gestorarticulos.model;

// IMPORTO ENTITY;
import jakarta.persistence.Entity;

// IMPORTO GENERATEDVALUE;
import jakarta.persistence.GeneratedValue;

// IMPORTO GENERATIONTYPE;
import jakarta.persistence.GenerationType;

// IMPORTO ID;
import jakarta.persistence.Id;

// IMPORTO TABLE;
import jakarta.persistence.Table;

// ESTA CLASE SE MAPEARA EN UNA TABLA EN LA BD;
@Entity

// NOMBRE DE LA TABLA;
@Table(name = "articulos")

public class Articulo { // INICIO CLASE ARTICULO;

    // ESTADO: ATRIBUTOS;
    // CLAVE PRIMARIA AUTOINCREMENTAL;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private double precio;
    private String descripcion;

    // COMPORTAMIENTO: CONSTRUCTORES - MÉTODOS;
    // CONSTRUCTOR POR DEFECTO;
    public Articulo() {

    }

    // CONSTRUCTOR PARAMETRIZADO;
    public Articulo(
            Long id,
            String nombre,
            double precio,
            String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public Articulo(
            String nombre,
            double precio,
            String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    // GETTERS Y SETTERS;
    // ID;
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // NOMBRE;
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // PRECIO;
    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // DESCRIPCION;
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

} // FINAL CLASE ARTICULO;
