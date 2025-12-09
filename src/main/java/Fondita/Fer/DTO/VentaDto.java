package Fondita.Fer.DTO;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VentaDto {

    private Long idVenta; 

    @JsonProperty(access = Access.READ_ONLY)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime fechaVenta;

    private Integer idCliente;

    private Long idReserva; 

    @JsonProperty(access = Access.READ_ONLY)
    private Float total;
    private String empleado;

    @JsonProperty(access = Access.READ_ONLY)
    private String nombreCliente;

    private List<DetalleVentaDto> detalles;

	
}

