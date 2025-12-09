package Fondita.Fer.Mapper;

import java.util.List;
import java.util.stream.Collectors;
import Fondita.Fer.DTO.DetalleVentaDto;
import Fondita.Fer.DTO.VentaDto;
import Fondita.Fer.Entidades.DetalleVenta;
import Fondita.Fer.Entidades.Venta;

public class VentaMapper {

    public static VentaDto mapToVentaDto(Venta venta) {
        if (venta == null) return null;

        List<DetalleVentaDto> detallesDto = (venta.getDetalles() == null) ? null
                : venta.getDetalles().stream()
                       .map(DetalleVentaMapper::mapToDetalleVentaDto)
                       .collect(Collectors.toList());

        VentaDto dto = new VentaDto();
        dto.setIdVenta(venta.getIdVenta());
        dto.setFechaVenta(venta.getFechaVenta());
        dto.setIdCliente(venta.getIdCliente());
        dto.setIdReserva(venta.getIdReserva());
        dto.setTotal(venta.getTotal());
        dto.setEmpleado(venta.getEmpleado());
        dto.setDetalles(detallesDto);

        return dto;
    }

    public static Venta mapToVenta(VentaDto dto) {
        if (dto == null) return null;

        Venta venta = new Venta();
        venta.setIdVenta(dto.getIdVenta());
        venta.setFechaVenta(dto.getFechaVenta());
        venta.setIdCliente(dto.getIdCliente());
        venta.setIdReserva(dto.getIdReserva());
        venta.setTotal(dto.getTotal());
        venta.setEmpleado(dto.getEmpleado());
        if (dto.getDetalles() != null) {
            List<DetalleVenta> detalles = dto.getDetalles().stream()
                    .map(DetalleVentaMapper::mapToDetalleVenta)
                    .collect(Collectors.toList());

            for (DetalleVenta d : detalles) {
                d.setIdVenta(venta);
            }
            venta.setDetalles(detalles);
        }

        return venta;
    }
}
