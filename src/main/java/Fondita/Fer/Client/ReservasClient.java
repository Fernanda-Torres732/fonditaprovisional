package Fondita.Fer.Client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@FeignClient(name = "reservas", path = "/api/reservas")
public interface ReservasClient {

    // ✅ Obtener todas las reservas
    @GetMapping
    List<ReservaDto> findAll();

    // ✅ Obtener una reserva por ID
    @GetMapping("/{id}")
    ReservaDto findById(@PathVariable("id") Long id); // cambiamos a Long por consistencia

    // DTO interno que Feign usará para deserializar
    @JsonIgnoreProperties(ignoreUnknown = true)
    class ReservaDto {
        @JsonAlias({"idReserva", "id"})
        private Long idReserva;
        private String fecha;
        private String hora;
        private Integer idCliente;
        private Long idMesa;
        private int estatus;

        public Long getIdReserva() {
            return idReserva;
        }
        public void setIdReserva(Long idReserva) {
            this.idReserva = idReserva;
        }
        public String getFecha() {
            return fecha;
        }
        public void setFecha(String fecha) {
            this.fecha = fecha;
        }
        public String getHora() {
            return hora;
        }
        public void setHora(String hora) {
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
}
