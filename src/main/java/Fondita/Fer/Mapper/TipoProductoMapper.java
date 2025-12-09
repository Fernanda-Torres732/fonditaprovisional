package Fondita.Fer.Mapper;
import Fondita.Fer.DTO.*;
import Fondita.Fer.Entidades.TipoProducto;
public class TipoProductoMapper {

	public static TipoDto mapToTipoProductoDto(TipoProducto tipoProducto) {
		return new TipoDto(tipoProducto.getIdTipo(), tipoProducto.getTipo(), tipoProducto.getDescripcion());
	}

	public static TipoProducto mapToTipoProducto(TipoDto tipoDto) {
		return new TipoProducto(tipoDto.getIdTipo(), tipoDto.getTipo(),
				tipoDto.getDescripcion());
	}
}