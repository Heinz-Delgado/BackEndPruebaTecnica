package com.prueba.spring.app.dto;

public class InvitadoRequestDTO {
    private String nombre;
    private String cargo;
    private Long facturaId; // ID de la factura a la que pertenece el invitado
      
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Long getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Long facturaId) {
        this.facturaId = facturaId;
    }
}

