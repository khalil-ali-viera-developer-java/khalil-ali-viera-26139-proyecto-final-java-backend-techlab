package com.elviejomolino.gestorarticulos.service;

// IMPORTO LIST;
import java.util.List;

// IMPORTO ARTICULO;
import com.elviejomolino.gestorarticulos.model.Articulo;

public interface ArticuloService { // INICIO INTERFACE ARTICULOSERVICE;

    // FINDALL();
    List<Articulo> findAllService();

    // FINDBYID(ID);
    Articulo findByIdService(Long id);

    // SAVE(ENTITY);
    Articulo saveService(Articulo articulo);

    // MODIFYBYID(ID, ENTITY);
    Articulo modifyByIdService(Long id, Articulo articulo);

    // DELETEBYID(ID);
    boolean deleteById(Long id);

} // FINAL INTERFACE ARTICULOSERVICE;
