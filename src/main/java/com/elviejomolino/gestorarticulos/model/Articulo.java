package com.elviejomolino.gestorarticulos.model;

public class Articulo { // INICIO CLASE ARTICULO;

    // ESTADO: ATRIBUTOS;
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
