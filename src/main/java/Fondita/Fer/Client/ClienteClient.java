package Fondita.Fer.Client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@FeignClient(name = "restaurante", path = "/api/cliente")
public interface ClienteClient {

    // ✅ Obtener todos los clientes
    @GetMapping
    List<Fondita.Fer.DTO.ClienteDto> findAll();

    // ✅ Obtener cliente por ID
    @GetMapping("/{id}")
    Fondita.Fer.DTO.ClienteDto findById(@PathVariable("id") Integer id);

    // ✅ Crear nuevo cliente
    @PostMapping
    Fondita.Fer.DTO.ClienteDto createCliente(@RequestBody Fondita.Fer.DTO.ClienteDto clienteDto);

    // ✅ Actualizar cliente existente
    @PutMapping("/{id}")
    Fondita.Fer.DTO.ClienteDto updateCliente(@PathVariable("id") Integer id, @RequestBody Fondita.Fer.DTO.ClienteDto clienteDto);

    // ✅ Eliminar cliente por ID
    @DeleteMapping("/{id}")
    void deleteCliente(@PathVariable("id") Integer id);

    // DTO interno opcional (solo si no usas Fondita.Fer.DTO.ClienteDto directamente)
    @JsonIgnoreProperties(ignoreUnknown = true)
    class ClienteDto {
        @JsonAlias({"id", "idCliente"})
        private int id;
        private String nombreCliente;
        private String telefonoCliente;
        private String correoCliente;
        private String password;
    	private String rol;
    	
        // Getters y Setters
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getNombreCliente() {
            return nombreCliente;
        }
        public void setNombreCliente(String nombreCliente) {
            this.nombreCliente = nombreCliente;
        }
        public String getTelefonoCliente() {
            return telefonoCliente;
        }
        public void setTelefonoCliente(String telefonoCliente) {
            this.telefonoCliente = telefonoCliente;
        }
        public String getCorreoCliente() {
            return correoCliente;
        }
        public void setCorreoCliente(String correoCliente) {
            this.correoCliente = correoCliente;
        }
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRol() {
			return rol;
		}
		public void setRol(String rol) {
			this.rol = rol;
		}
        
    }
}
