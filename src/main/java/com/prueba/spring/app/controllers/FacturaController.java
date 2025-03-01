package com.prueba.spring.app.controllers;

import com.prueba.spring.app.dto.FacturaRequestDTO;
import com.prueba.spring.app.models.Factura;
import com.prueba.spring.app.models.Invitado;
import com.prueba.spring.app.services.FacturaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    // 1) Crear factura con invitados
    @PostMapping
    public ResponseEntity<Factura> crearFactura(@RequestBody FacturaRequestDTO facturaDTO) {
        Factura factura = facturaService.crearFacturaConInvitados(facturaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(factura);
    }

    // 2) Consultar facturas por identificación de establecimiento
    @GetMapping
    public List<Factura> obtenerFacturas(
            @RequestParam(value = "identificacion", required = false) String identificacion) {

        if (identificacion != null) {

            return facturaService.obtenerFacturasPorEstablecimiento(identificacion);
        } else {
            // Si no se envía el parámetro, podrías retornar todas las facturas
            // o manejarlo como prefieras.
            return facturaService.obtenerFacturasPorEstablecimiento("");
        }
    }

    @GetMapping("/todas")
    public List<Factura> obtenerTodasFacturas() {
        List<Factura> facturas = facturaService.obtenerTodasFacturas();
        System.out.println("Cantidad de facturas encontradas: " + facturas.size());
        return facturas;
    }

    // 3) Consultar invitados de una factura específica
    @GetMapping("/{id}/invitados")
    public List<Invitado> obtenerInvitados(@PathVariable Long id) {
        return facturaService.obtenerInvitadosPorFactura(id);
    }

    @PostMapping("/{id}/invitados")
    public ResponseEntity<String> agregarInvitados(@PathVariable Long id,       
    @RequestBody List<FacturaRequestDTO.InvitadoDTO> invitadosDTO) {
        facturaService.agregarInvitados(id, invitadosDTO);
        return ResponseEntity.ok("Invitados agregados correctamente");
    }

}
