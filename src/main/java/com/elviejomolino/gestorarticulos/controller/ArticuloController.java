package com.elviejomolino.gestorarticulos.controller;

// IMPORTO AUTOWIRED;
import org.springframework.beans.factory.annotation.Autowired;

// IMPORTO HTTPSTATUS;
import org.springframework.http.HttpStatus;

// IMPORTO RESPONSEENTITY;
import org.springframework.http.ResponseEntity;

// IMPORTO CROSSORIGIN;
import org.springframework.web.bind.annotation.CrossOrigin;

// IMPORTO DELETEMAPPING;
import org.springframework.web.bind.annotation.DeleteMapping;

// IMPORTO GETMAPPING;
import org.springframework.web.bind.annotation.GetMapping;

// IMPORTO PATHVARIABLE;
import org.springframework.web.bind.annotation.PathVariable;

// IMPORTO POSTMAPPING;
import org.springframework.web.bind.annotation.PostMapping;

// IMPORTO PUTMAPPING;
import org.springframework.web.bind.annotation.PutMapping;

// IMPORTO REQUESTBODY;
import org.springframework.web.bind.annotation.RequestBody;

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
    @PostMapping
    public ResponseEntity<?> saveController(@RequestBody Articulo articulo) {

        try {

            // ENTITY;
            Articulo articuloSaveController = this.articuloService.saveService(articulo);

            // RETURN JSON - RETURN HTTP: 201;
            return ResponseEntity.status(HttpStatus.CREATED).body(articuloSaveController);

        } catch (IllegalArgumentException e) {

            // ERROR DEL CLIENTE: HTTP 400;
            return ResponseEntity.badRequest().body(e.getMessage());

        }

    }

    // MODIFYBYID(ID, ENTITY);
    @PutMapping("/{id}")
    public ResponseEntity<?> modifyByIdController(@PathVariable Long id, @RequestBody Articulo articulo) {

        try {

            // ENTITY;
            Articulo articuloModificado = this.articuloService.modifyByIdService(id, articulo);

            // RETURN JSON - RETURN HTTP: 200;
            return ResponseEntity.ok(articuloModificado);

        } catch (IllegalArgumentException e) {

            // ERROR DEL CLIENTE: HTTP 400;
            return ResponseEntity.badRequest().body(e.getMessage());

        } catch (ArticuloNotFoundException e) {

            // RECURSO NO ENCONTRADO: HTTP 404;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }
    }

    // DELETEBYID(ID);
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByController(@PathVariable Long id) {

        try {

            this.articuloService.deleteById(id);

            // RETURN HTTP 204;
            return ResponseEntity.noContent().build();

        } catch (IllegalArgumentException e) {

            // ERROR DEL CLIENTE: HTTP 400;
            return ResponseEntity.badRequest().body(e.getMessage());

        } catch (ArticuloNotFoundException e) {

            // REGISTRO NO ENCONTRADO: HTTP 404;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }
    }

} // FINAL CLASE ARTICULOCONTROLLER;
