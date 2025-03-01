package com.prueba.spring.app.repositories;

import com.prueba.spring.app.models.Invitado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvitadoRepository extends JpaRepository<Invitado, Long> {
    
    // Consulta los invitados asociados a una factura
    List<Invitado> findByFacturaFacId(Long facturaId);
}
