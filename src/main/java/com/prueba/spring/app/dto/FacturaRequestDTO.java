package com.prueba.spring.app.dto;

import java.time.LocalDate;
import java.util.List;

public class FacturaRequestDTO {
    private LocalDate facFechaFactura;
    private String facDetalle;
    private String facNombreEstablecimiento;
    private String facIdentificacionEstablecimiento;
    private String facNumeroFactura;
    private Double facSubtotal;
    private Double facIva;
    private Double facTotal;
    private Integer facNumeroInvitados;
    private List<InvitadoDTO> invitados;

    // Getters y Setters

    public static class InvitadoDTO {
        private String invNombre;
        public String getInvNombre() {
            return invNombre;
        }
        public void setInvNombre(String invNombre) {
            this.invNombre = invNombre;
        }
        private String invCargo;
        public String getInvCargo() {
            return invCargo;
        }
        public void setInvCargo(String invCargo) {
            this.invCargo = invCargo;
        }

        // Getters y Setters
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

    public List<InvitadoDTO> getInvitados() {
        return invitados;
    }

    public void setInvitados(List<InvitadoDTO> invitados) {
        this.invitados = invitados;
    }
}
