package Fondita.Fer.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Fondita.Fer.DTO.TipoDto;
import Fondita.Fer.Service.TipoProductoService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/tipo")
public class TipoProductoController {

    private final TipoProductoService tipoService;

    @PostMapping
    public ResponseEntity<TipoDto> crearTipo(@RequestBody TipoDto tipoDto) {
        TipoDto guardarTipo = tipoService.createTipo(tipoDto);
        return new ResponseEntity<>(guardarTipo, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TipoDto> getTipoById(@PathVariable("id") Integer id) {
        TipoDto tipoDto = tipoService.getTipoById(id);
        return ResponseEntity.ok(tipoDto);
    }

    @GetMapping
    public ResponseEntity<List<TipoDto>> getAllTipos() {
        List<TipoDto> tipos = tipoService.getAllTipos();
        return ResponseEntity.ok(tipos);
    }

    @PutMapping("{id}")
    public ResponseEntity<TipoDto> updateTipo(@PathVariable("id") Integer id,
                                              @RequestBody TipoDto updateTipo) {
        TipoDto tipoDto = tipoService.updateTipo(id, updateTipo);
        return ResponseEntity.ok(tipoDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTipo(@PathVariable("id") Integer id) {
        tipoService.deleteTipo(id);
        return ResponseEntity.ok("Tipo eliminado exitosamente");
    }
}
