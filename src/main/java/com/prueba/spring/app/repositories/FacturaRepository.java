package com.prueba.spring.app.repositories;

import com.prueba.spring.app.models.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
    
    // Consulta por la identificación del establecimiento
    List<Factura> findByFacIdentificacionEstablecimiento(String identificacion);
}
