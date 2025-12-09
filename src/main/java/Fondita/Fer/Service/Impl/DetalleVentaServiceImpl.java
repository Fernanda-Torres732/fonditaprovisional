package Fondita.Fer.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Fondita.Fer.DTO.DetalleVentaDto;
import Fondita.Fer.Entidades.DetalleVenta;
import Fondita.Fer.Mapper.DetalleVentaMapper;
import Fondita.Fer.Repository.DetalleVentaRepository;
import Fondita.Fer.Service.DetalleVentaService;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DetalleVentaServiceImpl implements DetalleVentaService {

    private final DetalleVentaRepository detalleVentaRepository;

    @Transactional(readOnly = true)
    @Override
    public DetalleVentaDto getDetalleById(Integer detalleId) {
        DetalleVenta dv = detalleVentaRepository.findById(detalleId)
                .orElseThrow(() -> new IllegalArgumentException("Detalle de venta no encontrado"));
        return DetalleVentaMapper.mapToDetalleVentaDto(dv);
    }

    @Transactional(readOnly = true)
    @Override
    public List<DetalleVentaDto> getAllDetallesVenta() {
        return detalleVentaRepository.findAll().stream().map(DetalleVentaMapper::mapToDetalleVentaDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<DetalleVentaDto> getDetallesByVenta(Integer idVenta) {
        // Aquí asumimos que en el repositorio hay método findByIdVenta_IdVenta
        return detalleVentaRepository.findByIdVenta_IdVenta(idVenta).stream()
                .map(DetalleVentaMapper::mapToDetalleVentaDto).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteDetalleVenta(Integer detalleId) {
        if (!detalleVentaRepository.existsById(detalleId)) {
            throw new IllegalArgumentException("Detalle de venta no encontrado");
        }
        detalleVentaRepository.deleteById(detalleId);
    }
}
