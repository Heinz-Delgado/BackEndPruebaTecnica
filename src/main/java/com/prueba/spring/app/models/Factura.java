package com.prueba.spring.app.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "facturas")
public class Factura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fac_id")
    private Long facId;

    @Column(name = "fac_fecha_factura", nullable = false)
    private LocalDate facFechaFactura;

    @Column(name = "fac_detalle", nullable = false)
    private String facDetalle;

    @Column(name = "fac_nombre_establecimiento", nullable = false)
    private String facNombreEstablecimiento;

    @Column(name = "fac_identificacion_establecimiento", nullable = false)
    private String facIdentificacionEstablecimiento;

    @Column(name = "fac_numero_factura", nullable = false)
    private String facNumeroFactura;

    @Column(name = "fac_subtotal", nullable = false)
    private Double facSubtotal;

    @Column(name = "fac_iva", nullable = false)
    private Double facIva;

    @Column(name = "fac_total", nullable = false)
    private Double facTotal;

    @Column(name = "fac_numero_invitados", nullable = false)
    private Integer facNumeroInvitados;

    public Long getFacId() {
        return facId;
    }

    public void setFacId(Long facId) {
        this.facId = facId;
    }

    public LocalDate getFacFechaFactura() {
        return facFechaFactura;
    }

    public void setFacFechaFactura(LocalDate facFechaFactura) {
        this.facFechaFactura = facFechaFactura;
    }

    public String getFacDetalle() {
        return facDetalle;
    }

    public void setFacDetalle(String facDetalle) {
        this.facDetalle = facDetalle;
    }

    public String getFacNombreEstablecimiento() {
        return facNombreEstablecimiento;
    }

    public void setFacNombreEstablecimiento(String facNombreEstablecimiento) {
        this.facNombreEstablecimiento = facNombreEstablecimiento;
    }

    public String getFacIdentificacionEstablecimiento() {
        return facIdentificacionEstablecimiento;
    }

    public void setFacIdentificacionEstablecimiento(String facIdentificacionEstablecimiento) {
        this.facIdentificacionEstablecimiento = facIdentificacionEstablecimiento;
    }

    public String getFacNumeroFactura() {
        return facNumeroFactura;
    }

    public void setFacNumeroFactura(String facNumeroFactura) {
        this.facNumeroFactura = facNumeroFactura;
    }

    public Double getFacSubtotal() {
        return facSubtotal;
    }

    public void setFacSubtotal(Double facSubtotal) {
        this.facSubtotal = facSubtotal;
    }

    public Double getFacIva() {
        return facIva;
    }

    public void setFacIva(Double facIva) {
        this.facIva = facIva;
    }

    public Double getFacTotal() {
        return facTotal;
    }

    public void setFacTotal(Double facTotal) {
        this.facTotal = facTotal;
    }

    public Integer getFacNumeroInvitados() {
        return facNumeroInvitados;
    }

    public void setFacNumeroInvitados(Integer facNumeroInvitados) {
        this.facNumeroInvitados = facNumeroInvitados;
    }

    // Getters y Setters
    // ...
}
