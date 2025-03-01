package com.prueba.spring.app.services;
import com.prueba.spring.app.dto.InvitadoRequestDTO;
import com.prueba.spring.app.models.Factura;
import com.prueba.spring.app.models.Invitado;
import com.prueba.spring.app.repositories.FacturaRepository;
import com.prueba.spring.app.repositories.InvitadoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvitadoService {

    private final InvitadoRepository invitadoRepository;
    private final FacturaRepository facturaRepository;

    public InvitadoService(InvitadoRepository invitadoRepository, FacturaRepository facturaRepository) {
        this.invitadoRepository = invitadoRepository;
        this.facturaRepository = facturaRepository;
    }

    // 1) Crear Invitado asociado a una Factura
    public Invitado crearInvitado(InvitadoRequestDTO dto) {
        // Validar existencia de la Factura
        Factura factura = facturaRepository.findById(dto.getFacturaId())
                .orElseThrow(() -> new IllegalArgumentException("Factura no encontrada"));

        // Crear y guardar el invitado
        Invitado invitado = new Invitado();
        invitado.setInvNombre(dto.getNombre());
        invitado.setInvCargo(dto.getCargo());
        invitado.setFactura(factura);

        return invitadoRepository.save(invitado);
    }

    // 2) Obtener todos los invitados
    public List<Invitado> obtenerTodosLosInvitados() {
        return invitadoRepository.findAll();
    }

    // 3) Obtener Invitado por ID
    public Invitado obtenerInvitadoPorId(Long id) {
        return invitadoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invitado no encontrado"));
    }

    // 4) Obtener todos los invitados de una Factura específica
    public List<Invitado> obtenerInvitadosPorFactura(Long facturaId) {
        return invitadoRepository.findByFacturaFacId(facturaId);
    }

    // 5) Agregar múltiples invitados a una Factura
    public void agregarInvitados(Long facturaId, List<InvitadoRequestDTO> invitadosDTO) {
        Factura factura = facturaRepository.findById(facturaId)
                .orElseThrow(() -> new IllegalArgumentException("Factura no encontrada"));

        List<Invitado> invitados = new ArrayList<>();
        for (InvitadoRequestDTO dto : invitadosDTO) {
            Invitado invitado = new Invitado();
            invitado.setInvNombre(dto.getNombre());
            invitado.setInvCargo(dto.getCargo());
            invitado.setFactura(factura);
            invitados.add(invitado);
        }
        invitadoRepository.saveAll(invitados);
    }

    // 6) Eliminar un invitado por ID
    public boolean eliminarInvitado(Long id) {
        if (invitadoRepository.existsById(id)) {
            invitadoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

