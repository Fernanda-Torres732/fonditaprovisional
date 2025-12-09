package Fondita.Fer.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Fondita.Fer.DTO.TipoDto;
import Fondita.Fer.Entidades.TipoProducto;
import Fondita.Fer.Repository.TipoProductoRepository;
import lombok.AllArgsConstructor;

@Service
public interface TipoProductoService {
    TipoDto createTipo(TipoDto tipoDto);
    TipoDto getTipoById(int id);
    List<TipoDto> getAllTipos();
    TipoDto updateTipo(int id, TipoDto updateDto);
    void deleteTipo(int id);
}