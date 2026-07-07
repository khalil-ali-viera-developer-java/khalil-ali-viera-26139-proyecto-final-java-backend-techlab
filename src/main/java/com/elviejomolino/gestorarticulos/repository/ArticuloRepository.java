package com.elviejomolino.gestorarticulos.repository;

// IMPORTO JPAREPOSITORY;
import org.springframework.data.jpa.repository.JpaRepository;

// IMPORTO REPOSITORY;
import org.springframework.stereotype.Repository;

// IMPORTO ARTICULO;
import com.elviejomolino.gestorarticulos.model.Articulo;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> { // INICIO INTERFACE ARTICULOREPOSITORY;

    // ESTADO: ATRIBUTOS;

    // COMPORTAMIENTO: CONSTRUCTORES - MÉTODOS;

} // FINAL INTERFACE ARTICULOREPOSITORY;
