package Fondita.Fer.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Fondita.Fer.DTO.TipoDto;
import Fondita.Fer.Entidades.TipoProducto;
import Fondita.Fer.Repository.TipoProductoRepository;
import Fondita.Fer.Service.TipoProductoService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TipoProductoServiceImpl implements TipoProductoService {

    private final TipoProductoRepository tipoRepository;

    @Override
    public TipoDto createTipo(TipoDto tipoDto) {
        TipoProducto tipo = mapToEntity(tipoDto);
        TipoProducto saved = tipoRepository.save(tipo);
        return mapToDto(saved);
    }

    @Override
    public TipoDto getTipoById(int id) {
        TipoProducto tipo = tipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo no encontrado con id " + id));
        return mapToDto(tipo);
    }

    @Override
    public List<TipoDto> getAllTipos() {
        return tipoRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TipoDto updateTipo(int id, TipoDto updateDto) {
        TipoProducto tipo = tipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo no encontrado con id " + id));

        tipo.setTipo(updateDto.getTipo()); 
        tipo.setDescripcion(updateDto.getDescripcion());

        TipoProducto updated = tipoRepository.save(tipo);
        return mapToDto(updated);
    }

    @Override
    public void deleteTipo(int id) {
        tipoRepository.deleteById(id);
    }

    // Helpers
    private TipoDto mapToDto(TipoProducto tipo) {
        return new TipoDto(
                tipo.getIdTipo(),
                tipo.getTipo(),  
                tipo.getDescripcion()
        );
    }

    private TipoProducto mapToEntity(TipoDto dto) {
        return new TipoProducto(
                dto.getIdTipo(),
                dto.getTipo(),    
                dto.getDescripcion()
        );
    }
}
