package Fondita.Fer.Service.Impl;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import Fondita.Fer.Client.ReservasClient;
import Fondita.Fer.DTO.ReservarDto;
import Fondita.Fer.Service.ReservasService;

@Service
@RequiredArgsConstructor
public class ReservasServiceImpl implements ReservasService {

    private final ReservasClient reservasClient; // ✅ nombre correcto

    @Override
    public ReservarDto getReservaById(Long id) {
        var reservaDto = reservasClient.findById(id);
        if (reservaDto == null) {
            throw new RuntimeException("Reserva no encontrada con id " + id);
        }

        ReservarDto dto = new ReservarDto();
        dto.setIdReserva(reservaDto.getIdReserva());
        dto.setIdCliente(reservaDto.getIdCliente());
        dto.setIdMesa(reservaDto.getIdMesa());
        dto.setEstatus(reservaDto.getEstatus());

        try {
            if (reservaDto.getFecha() != null)
                dto.setFecha(java.time.LocalDate.parse(reservaDto.getFecha()));
            if (reservaDto.getHora() != null)
                dto.setHora(java.time.LocalTime.parse(reservaDto.getHora()));
        } catch (Exception e) {
            System.err.println("⚠️ Error al parsear fecha/hora desde ReservasClient: " + e.getMessage());
        }

        return dto;
    }

    @Override
    public List<ReservarDto> getAllReservas() {
        throw new UnsupportedOperationException("Este método no está implementado en el Feign Client aún.");
    }
}
