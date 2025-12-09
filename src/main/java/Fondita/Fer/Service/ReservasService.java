package Fondita.Fer.Service;

import java.util.List;
import Fondita.Fer.DTO.ReservarDto;

public interface ReservasService {

    ReservarDto getReservaById(Long id);

    List<ReservarDto> getAllReservas();
}
