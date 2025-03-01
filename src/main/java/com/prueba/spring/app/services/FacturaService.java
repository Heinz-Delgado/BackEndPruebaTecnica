package com.prueba.spring.app.services;

import com.prueba.spring.app.dto.FacturaRequestDTO;
import com.prueba.spring.app.models.Factura;
import com.prueba.spring.app.models.Invitado;
import com.prueba.spring.app.repositories.FacturaRepository;
import com.prueba.spring.app.repositories.InvitadoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FacturaService {

    private final FacturaRepository facturaRepository;
    private final InvitadoRepository invitadoRepository;

    public FacturaService(FacturaRepository facturaRepository, InvitadoRepository invitadoRepository) {
        this.facturaRepository = facturaRepository;
        this.invitadoRepository = invitadoRepository;
    }

    public Factura crearFacturaConInvitados(FacturaRequestDTO dto) {
        
        // 1) Validación de fechas
        LocalDate fechaHoy = LocalDate.now();
        if (dto.getFacFechaFactura().isAfter(fechaHoy)) {
            throw new IllegalArgumentException("La fecha no puede ser mayor que hoy.");
            
        }
        if (dto.getFacFechaFactura().isBefore(fechaHoy.minusDays(90))) {
            throw new IllegalArgumentException("La fecha de la factura no puede ser menor a 90 días.");
        }

        // 2) Validación de número de invitados
        if (dto.getFacNumeroInvitados() > 15) {
            throw new IllegalArgumentException("El número de invitados no puede ser mayor a 15.");
        }
        if (dto.getFacNumeroInvitados() != dto.getInvitados().size()) {
            throw new IllegalArgumentException("El número de invitados no coincide con la lista enviada.");
        }

        // 3) Crear la Factura
        Factura factura = new Factura();
        factura.setFacFechaFactura(dto.getFacFechaFactura());
        factura.setFacDetalle(dto.getFacDetalle());
        factura.setFacNombreEstablecimiento(dto.getFacNombreEstablecimiento());
        factura.setFacIdentificacionEstablecimiento(dto.getFacIdentificacionEstablecimiento());
        factura.setFacNumeroFactura(dto.getFacNumeroFactura());
        factura.setFacSubtotal(dto.getFacSubtotal());
        factura.setFacIva(dto.getFacIva());
        factura.setFacTotal(dto.getFacTotal());
        factura.setFacNumeroInvitados(dto.getFacNumeroInvitados());

        // Guardar la factura en BD
        Factura facturaGuardada = facturaRepository.save(factura);

        // 4) Crear y guardar Invitados
        List<Invitado> invitados = new ArrayList<>();
        for (FacturaRequestDTO.InvitadoDTO invDto : dto.getInvitados()) {
            Invitado invitado = new Invitado();
            invitado.setInvNombre(invDto.getInvNombre());
            invitado.setInvCargo(invDto.getInvCargo());
            invitado.setFactura(facturaGuardada);
            invitados.add(invitado);
        }
        invitadoRepository.saveAll(invitados);

        return facturaGuardada;
    }

    public List<Factura> obtenerFacturasPorEstablecimiento(String identificacion) {
        return facturaRepository.findByFacIdentificacionEstablecimiento(identificacion);
    }

    public List<Invitado> obtenerInvitadosPorFactura(Long facturaId) {
        return invitadoRepository.findByFacturaFacId(facturaId);
    }
    public List<Factura> obtenerTodasFacturas() {
        return facturaRepository.findAll();
    }
    public void agregarInvitados(Long facturaId, List<FacturaRequestDTO.InvitadoDTO> invitadosDTO) {
        Factura factura = facturaRepository.findById(facturaId)
            .orElseThrow(() -> new IllegalArgumentException("Factura no encontrada"));
    
        List<Invitado> invitados = new ArrayList<>();
        for (FacturaRequestDTO.InvitadoDTO invDto : invitadosDTO) {
            Invitado invitado = new Invitado();
            invitado.setInvNombre(invDto.getInvNombre());
            invitado.setInvCargo(invDto.getInvCargo());
            invitado.setFactura(factura);
            invitados.add(invitado);
        }
        invitadoRepository.saveAll(invitados);
    }
    
    
}
