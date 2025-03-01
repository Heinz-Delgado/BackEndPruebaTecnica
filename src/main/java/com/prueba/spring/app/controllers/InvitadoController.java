package com.prueba.spring.app.controllers;
import com.prueba.spring.app.models.Invitado;
import com.prueba.spring.app.services.FacturaService;
import com.prueba.spring.app.services.InvitadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invitados")
public class InvitadoController {

    private final InvitadoService invitadoService;

    public InvitadoController(InvitadoService invitadoService, FacturaService facturaService) {
        this.invitadoService = invitadoService;
    }

    // Obtener todos los invitados
    @GetMapping
    public ResponseEntity<List<Invitado>> obtenerTodosLosInvitados() {
        return ResponseEntity.ok(invitadoService.obtenerTodosLosInvitados());
    }

    // Eliminar un invitado por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarInvitado(@PathVariable Long id) {
        boolean eliminado = invitadoService.eliminarInvitado(id);
        if (eliminado) {
            return ResponseEntity.ok().body("Invitado eliminado con éxito.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
