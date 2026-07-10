package com.elviejomolino.gestorarticulos.service;

// IMPORTO LIST;
import java.util.List;

// IMPORTO ARTICULO;
import com.elviejomolino.gestorarticulos.model.Articulo;

// IMPORTO ARTICULONOTFOUNDEXCEPTION;
import com.elviejomolino.gestorarticulos.exception.ArticuloNotFoundException;

// LA INTERFACE SERA IMPLEMENTADA POR ARTICULOSERVICEIMPL;
public interface ArticuloService { // INICIO INTERFACE ARTICULOSERVICE;

    // FINDALL();
    List<Articulo> findAllService();

    // FINDBYID(ID);
    Articulo findByIdService(Long id) throws ArticuloNotFoundException;

    // SAVE(ENTITY);
    Articulo saveService(Articulo articulo);

    // MODIFYBYID(ID, ENTITY);
    Articulo modifyByIdService(Long id, Articulo articulo) throws ArticuloNotFoundException;

    // DELETEBYID(ID);
    void deleteById(Long id) throws ArticuloNotFoundException;

} // FINAL INTERFACE ARTICULOSERVICE;
