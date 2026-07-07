package com.elviejomolino.gestorarticulos.controller;

// IMPORTO AUTOWIRED;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
// IMPORTO RESPONSEENTITY;
import org.springframework.http.ResponseEntity;

// IMPORTO CROSSORIGIN;
import org.springframework.web.bind.annotation.CrossOrigin;

// IMPORTO GETMAPPING;
import org.springframework.web.bind.annotation.GetMapping;

// IMPORTO PATHVARIABLE;
import org.springframework.web.bind.annotation.PathVariable;

// IMPORTO REQUESTMAPPING;
import org.springframework.web.bind.annotation.RequestMapping;

// IMPORTO RESTCONTROLLER;
import org.springframework.web.bind.annotation.RestController;

// IMPORTO LIST;
import java.util.List;

// IMPORTO ARTICULONOTFOUNDEXCEPTION;
import com.elviejomolino.gestorarticulos.exception.ArticuloNotFoundException;

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

    // FINDALL();
    @GetMapping
    public ResponseEntity<List<Articulo>> findAllController() {

        List<Articulo> articulos = this.articuloService.findAllService();

        // RETURN JSON - RETURN HTTP: 200;
        return ResponseEntity.ok(articulos);

    }

    // FINDBYID(ID);
    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdController(@PathVariable Long id) {

        try {

            // ENTITY;
            Articulo articulo = this.articuloService.findByIdService(id);

            // RETURN JSON - RETURN HTTP: 200;
            return ResponseEntity.ok(articulo);

        } catch (IllegalArgumentException e) {

            // ERROR DEL CLIENTE: HTTP 400;
            return ResponseEntity.badRequest().body(e.getMessage());

        } catch (ArticuloNotFoundException e) {

            // RECURSO NO ENCONTRADO: HTTP 404;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }
    }

    // SAVE(ENTITY);

    // MODIFYBYID(ID, ENTITY);

    // DELETEBYID(ID);

} // FINAL CLASE ARTICULOCONTROLLER;
