package Fondita.Fer.Service;

import java.util.List;
import Fondita.Fer.DTO.VentaDto;

public interface VentaService {

    // Crea la venta con su lista de detalles; calcula total y asigna fechaVenta si viene null
    VentaDto createVenta(VentaDto ventaDto);

    // Consulta por id
    VentaDto getVentaById(Long ventaId);

    // Lista todas
    List<VentaDto> getAllVentas();

    // Actualiza la venta (incluyendo reemplazar/ajustar detalles)
    VentaDto updateVenta(Long ventaId, VentaDto updateVenta);

    // Elimina la venta (y sus detalles por cascade)
    void deleteVenta(Long ventaId);

}
