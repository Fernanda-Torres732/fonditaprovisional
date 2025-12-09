package Fondita.Fer.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Fondita.Fer.Client.ClienteClient;
import Fondita.Fer.Client.ReservasClient;
import Fondita.Fer.DTO.VentaDto;
import Fondita.Fer.Entidades.DetalleVenta;
import Fondita.Fer.Entidades.Producto;
import Fondita.Fer.Entidades.Venta;
import Fondita.Fer.Mapper.DetalleVentaMapper;
import Fondita.Fer.Mapper.VentaMapper;
import Fondita.Fer.Repository.ProductoRepository;
import Fondita.Fer.Repository.VentaRepository;
import Fondita.Fer.Service.VentaService;
import feign.FeignException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class VentaServiceImpl implements VentaService {

    private final VentaRepository ventaRepository;
    private final ProductoRepository productoRepository;
    private final ClienteClient clienteClient;
    private final ReservasClient reservasClient;

    @Transactional
    @Override
    public VentaDto createVenta(VentaDto ventaDto) {
        if (ventaDto.getIdCliente() == null) {
            throw new IllegalArgumentException("idCliente es obligatorio");
        }
        try {
            clienteClient.findById(ventaDto.getIdCliente());
        } catch (FeignException.NotFound nf) {
            throw new IllegalArgumentException("Cliente no existe: " + ventaDto.getIdCliente());
        }

        if (ventaDto.getIdReserva() != null) {
            try {
                reservasClient.findById(ventaDto.getIdReserva()); 
            } catch (FeignException.NotFound nf) {
                throw new IllegalArgumentException("Reserva no existe: " + ventaDto.getIdReserva());
            }
        }

        Venta venta = VentaMapper.mapToVenta(ventaDto);

        if (venta.getDetalles() == null || venta.getDetalles().isEmpty()) {
            throw new IllegalArgumentException("La venta debe tener al menos un detalle");
        }

        double total = 0.0;
        for (DetalleVenta det : venta.getDetalles()) {
            det.setIdVenta(venta);

            if (det.getCantidad() == null || det.getCantidad() <= 0)
                det.setCantidad(1);

            Integer idProd = (det.getIdProducto() != null) ? det.getIdProducto().getIdProducto() : null;
            if (idProd == null)
                throw new IllegalArgumentException("idProducto es obligatorio en cada detalle");

            if (det.getPrecioUnitario() == null || det.getPrecioUnitario() <= 0) {
                var p = productoRepository.findById(idProd)
                        .orElseThrow(() -> new IllegalArgumentException("Producto no existe: " + idProd));
                det.setPrecioUnitario(p.getPrecio());
            }

            total += det.getCantidad() * det.getPrecioUnitario();
        }

        venta.setTotal((float) total);
        var guardada = ventaRepository.save(venta);
        return VentaMapper.mapToVentaDto(guardada);
    }

    @Transactional
    @Override
    public VentaDto updateVenta(Long ventaId, VentaDto updateVenta) {
        Venta venta = ventaRepository.findById(ventaId.intValue()) 
                .orElseThrow(() -> new IllegalArgumentException("Venta no encontrada"));

        if (updateVenta.getIdCliente() != null && !updateVenta.getIdCliente().equals(venta.getIdCliente())) {
            try {
                clienteClient.findById(updateVenta.getIdCliente());
            } catch (FeignException.NotFound nf) {
                throw new IllegalArgumentException("Cliente no existe: " + updateVenta.getIdCliente());
            } catch (FeignException fe) {
                throw new IllegalStateException("Error al consultar Cliente: " + fe.getMessage());
            }
            venta.setIdCliente(updateVenta.getIdCliente());
        }

        if (updateVenta.getIdReserva() != null) {
            try {
                reservasClient.findById(updateVenta.getIdReserva()); // Long
                venta.setIdReserva(updateVenta.getIdReserva());
            } catch (FeignException.NotFound nf) {
                throw new IllegalArgumentException("Reserva no encontrada: " + updateVenta.getIdReserva());
            } catch (FeignException fe) {
                throw new IllegalStateException("Error al consultar Reservas: " + fe.getMessage());
            }
        }

        venta.getDetalles().clear();
        double total = 0.0;

        if (updateVenta.getDetalles() != null && !updateVenta.getDetalles().isEmpty()) {
            for (var dDto : updateVenta.getDetalles()) {
                DetalleVenta det = DetalleVentaMapper.mapToDetalleVenta(dDto);
                det.setIdVenta(venta);

                if (det.getCantidad() == null || det.getCantidad() <= 0) {
                    det.setCantidad(1);
                }

                Integer idProd = (det.getIdProducto() != null) ? det.getIdProducto().getIdProducto() : null;
                if (idProd == null)
                    throw new IllegalArgumentException("idProducto es obligatorio en cada detalle");

                Producto p = productoRepository.findById(idProd)
                        .orElseThrow(() -> new IllegalArgumentException("Producto no existe: " + idProd));

                det.setIdProducto(p);
                if (det.getPrecioUnitario() == null || det.getPrecioUnitario() <= 0)
                    det.setPrecioUnitario(p.getPrecio());

                total += det.getCantidad() * det.getPrecioUnitario();
                venta.getDetalles().add(det);
            }
        }

        venta.setTotal((float) total);
        Venta guardada = ventaRepository.save(venta);
        return VentaMapper.mapToVentaDto(guardada);
    }

    @Transactional(readOnly = true)
    @Override
    public VentaDto getVentaById(Long ventaId) {
        Venta venta = ventaRepository.findById(ventaId.intValue())
                .orElseThrow(() -> new IllegalArgumentException("Venta no encontrada"));
        return VentaMapper.mapToVentaDto(venta);
    }

    @Transactional(readOnly = true)
    @Override
    public List<VentaDto> getAllVentas() {
        return ventaRepository.findAll()
                .stream()
                .map(VentaMapper::mapToVentaDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteVenta(Long ventaId) {
        if (!ventaRepository.existsById(ventaId.intValue())) {
            throw new IllegalArgumentException("Venta no encontrada");
        }
        ventaRepository.deleteById(ventaId.intValue());
    }
   


}
