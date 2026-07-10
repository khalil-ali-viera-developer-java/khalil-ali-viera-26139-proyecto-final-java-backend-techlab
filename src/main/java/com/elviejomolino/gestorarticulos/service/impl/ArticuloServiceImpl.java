package com.elviejomolino.gestorarticulos.service.impl;

// IMPORTO AUTOWIRED;
import org.springframework.beans.factory.annotation.Autowired;

// IMPORTO SERVICE;
import org.springframework.stereotype.Service;

// IMPORTO LIST;
import java.util.List;

// IMPORTO OPTIONAL;
import java.util.Optional;

// IMPORTO ARTICULO;
import com.elviejomolino.gestorarticulos.model.Articulo;

// IMPORTO LA INTERFACE ARTICULOREPOSITORY;
import com.elviejomolino.gestorarticulos.repository.ArticuloRepository;

// IMPORTO LA INTERFACE ARTICULOSERVICE;
import com.elviejomolino.gestorarticulos.service.ArticuloService;

// IMPORTO ARTICULONOTFOUNDEXCEPTION;
import com.elviejomolino.gestorarticulos.exception.ArticuloNotFoundException;

@Service
// LA CLASE IMPLEMENTARA DE ARTICULOSERVICE;
public class ArticuloServiceImpl implements ArticuloService { // INICIO CLASE ARTICULOSERVICE;

    // ESTADO: ATRIBUTOS;
    private final ArticuloRepository articuloRepository;

    // COMPORTAMIENTO: CONSTRUCTORES - MÉTODOS;
    // CONSTRUCTOR PARAMETRIZADO;
    @Autowired
    public ArticuloServiceImpl(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    // FINDALL();
    @Override
    public List<Articulo> findAllService() {
        return this.articuloRepository.findAll();
    }

    // FINDBYID(ID);
    @Override
    public Articulo findByIdService(Long id) throws ArticuloNotFoundException {

        // VALIDAR ID;
        if (id == null) {
            throw new IllegalArgumentException("El id del articulo no puede ser nulo.");
        }

        if (id <= 0) {
            throw new IllegalArgumentException("El id del articulo no puede ser 0 o negativo.");
        }

        // VALIDAR ARTICULO;
        Optional<Articulo> articuloOptional = this.articuloRepository.findById(id);

        if (articuloOptional.isEmpty()) {
            throw new ArticuloNotFoundException("El articulo con el id " + id + " no fue encontrado.");
        }

        return articuloOptional.get();

    }

    // SAVE(ENTITY);
    @Override
    public Articulo saveService(Articulo articulo) {

        // VALIDAR ARTICULO;
        if (articulo == null) {
            throw new IllegalArgumentException("El articulo no puede ser nulo.");
        }

        // VALIDAR NOMBRE;
        if (articulo.getNombre() == null) {
            throw new IllegalArgumentException("El nombre del articulo no puede ser nulo.");
        }

        if (articulo.getNombre().isBlank()) {
            throw new IllegalArgumentException(
                    "El nombre del articulo no puede estar vacio, tener espacios en blanco o caracteres de espacios en blanco.");
        }

        // VALIDAR PRECIO;
        if (articulo.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio del articulo no puede ser 0 o negativo.");
        }

        // VALIDAR DESCRIPCION;
        if (articulo.getDescripcion() == null) {
            throw new IllegalArgumentException("La descripción del articulo no puede ser nula.");
        }

        if (articulo.getDescripcion().isBlank()) {
            throw new IllegalArgumentException(
                    "La descripción del articulo no puede estar vacia, tener espacios en blanco o caracteres de espacios en blanco.");
        }

        return this.articuloRepository.save(articulo);
    }

    // MODIFYBYID(ID, ENTITY);
    @Override
    public Articulo modifyByIdService(Long id, Articulo articulo) throws ArticuloNotFoundException {

        // VALIDAR ID;
        if (id == null) {
            throw new IllegalArgumentException("El id del articulo no puede ser nulo.");
        }

        if (id <= 0) {
            throw new IllegalArgumentException("El id del articulo no puede ser 0 o negativo.");
        }

        // VALIDAR ARTICULO;
        if (articulo == null) {
            throw new IllegalArgumentException("El articulo no puede ser nulo.");
        }

        // VALIDAR NOMBRE;
        if (articulo.getNombre() == null) {
            throw new IllegalArgumentException("El nombre del articulo no puede ser nulo.");
        }

        if (articulo.getNombre().isBlank()) {
            throw new IllegalArgumentException(
                    "El nombre del articulo no puede estar vacio, tener espacios en blanco o caracteres de espacios en blanco.");
        }

        // VALIDAR PRECIO;
        if (articulo.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio del articulo no puede ser 0 o negativo.");
        }

        // VALIDAR DESCRIPCION;
        if (articulo.getDescripcion() == null) {
            throw new IllegalArgumentException("La descripción del articulo no puede ser nula.");
        }

        if (articulo.getDescripcion().isBlank()) {
            throw new IllegalArgumentException(
                    "La descripción del articulo no puede estar vacia, tener espacios en blanco o caracteres de espacios en blanco.");
        }

        Optional<Articulo> articuloOptional = this.articuloRepository.findById(id);

        if (articuloOptional.isEmpty()) {
            throw new ArticuloNotFoundException("El articulo con el id " + id + " no fue encontrado.");
        }

        Articulo articuloEncontrado = articuloOptional.get();

        articuloEncontrado.setNombre(articulo.getNombre());
        articuloEncontrado.setPrecio(articulo.getPrecio());
        articuloEncontrado.setDescripcion(articulo.getDescripcion());

        return this.articuloRepository.save(articuloEncontrado);
    }

    // DELETEBYID(ID);
    @Override
    public void deleteById(Long id) throws ArticuloNotFoundException {

        // VALIDAR ID;
        if (id == null) {
            throw new IllegalArgumentException("El id del articulo no puede ser nulo.");
        }

        if (id <= 0) {
            throw new IllegalArgumentException("El id del articulo no pude ser 0 o negativo.");
        }

        if (!(this.articuloRepository.existsById(id))) {
            throw new ArticuloNotFoundException("El articulo con el id " + id + " no fue encontrado.");
        }

        this.articuloRepository.deleteById(id);
    }

} // FINAL CLASE ARTICULOSERVICE;
