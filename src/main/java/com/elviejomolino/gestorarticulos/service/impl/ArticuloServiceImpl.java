package com.elviejomolino.gestorarticulos.service.impl;

// IMPORTO AUTOWIRED;
import org.springframework.beans.factory.annotation.Autowired;

// IMPORTO SERVICE;
import org.springframework.stereotype.Service;

// IMPORTO LIST;
import java.util.List;
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

        if (id <= 0L) {
            throw new IllegalArgumentException("El id del articulo no puede ser 0 o negativo.");
        }

        // VALIDAR ARTICULO;
        Optional<Articulo> articuloOptional = this.articuloRepository.findById(id);

        if (articuloOptional.isEmpty()) {
            throw new ArticuloNotFoundException("El articulo con el id " + id + " no encontrado.");
        }

        return articuloOptional.get();

    }

    // SAVE(ENTITY);

    // MODIFYBYID(ID, ENTITY);

    // DELETEBYID(ID);

} // FINAL CLASE ARTICULOSERVICE;
