package Fondita.Fer.Controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

import Fondita.Fer.DTO.ClienteDto; 
@RestController
public class ClienteFromRestauranteController {

    private final DiscoveryClient discoveryClient;
    private final RestClient restClient;

    public ClienteFromRestauranteController(DiscoveryClient discoveryClient, RestClient.Builder restClientBuilder) {
        this.discoveryClient = discoveryClient;
        this.restClient = restClientBuilder.build();
    }

    @GetMapping("/fondita/clientes")
    public List<ClienteDto> getClientesFromRestaurante() {
   
        ServiceInstance serviceInstance = discoveryClient.getInstances("restaurante").get(0);

        return restClient.get()
                .uri(serviceInstance.getUri() + "/api/cliente")
                .retrieve()
                .body(List.class); 
    }
}
