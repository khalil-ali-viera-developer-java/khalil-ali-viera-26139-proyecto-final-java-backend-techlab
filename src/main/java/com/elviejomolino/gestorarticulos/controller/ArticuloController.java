package com.elviejomolino.gestorarticulos.controller;

import org.springframework.beans.factory.annotation.Autowired;
// IMPORTO CROSSORIGIN;
import org.springframework.web.bind.annotation.CrossOrigin;

// IMPORTO REQUESTMAPPING;
import org.springframework.web.bind.annotation.RequestMapping;

// IMPORTO RESTCONTROLLER;
import org.springframework.web.bind.annotation.RestController;

// IMPORTO LIST;
import java.util.List;

// IMPORTO ARTICULO;
import com.elviejomolino.gestorarticulos.model.Articulo;

// IMPORTO LA INTERFACE ARTICULOSERVICE;
import com.elviejomolino.gestorarticulos.service.ArticuloService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/articulos")
public class ArticuloController { // INICIO CLASE ARTICULOCONTROLLER;

    // ESTADO: ATRIBUTOS;
    private final ArticuloService articuloService;

    // COMPORTAMIENTO: CONSTRUCTORES - MÉTODOS;
    // CONSTRUCTOR PARAMETRIZADO;
    @Autowired
    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

} // FINAL CLASE ARTICULOCONTROLLER;
