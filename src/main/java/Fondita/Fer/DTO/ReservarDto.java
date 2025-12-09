package Fondita.Fer.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservarDto {
    private Long idReserva;
    private LocalDate fecha;
    private LocalTime hora;
    private Integer idCliente; 
    private Long idMesa;   
    private int estatus;

    // Getters y Setters
    public Long getIdReserva() {
        return idReserva;
    }
    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public LocalTime getHora() {
        return hora;
    }
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    public Integer getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    public Long getIdMesa() {
        return idMesa;
    }
    public void setIdMesa(Long idMesa) {
        this.idMesa = idMesa;
    }
    public int getEstatus() {
        return estatus;
    }
    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
}
