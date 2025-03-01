package com.prueba.spring.app.models;

import jakarta.persistence.*;

@Entity
@Table(name = "invitados")
public class Invitado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inv_id")
    private Long invId;

    @Column(name = "inv_nombre", nullable = false)
    private String invNombre;

    @Column(name = "inv_cargo", nullable = false)
    private String invCargo;

    // Relación con Factura (muchos invitados para una factura)
    @ManyToOne
    @JoinColumn(name = "inv_factura_id", nullable = false)
    private Factura factura;

    public Long getInvId() {
        return invId;
    }

    public void setInvId(Long invId) {
        this.invId = invId;
    }

    public String getInvNombre() {
        return invNombre;
    }

    public void setInvNombre(String invNombre) {
        this.invNombre = invNombre;
    }

    public String getInvCargo() {
        return invCargo;
    }

    public void setInvCargo(String invCargo) {
        this.invCargo = invCargo;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    // Getters y Setters
    // ...
}
