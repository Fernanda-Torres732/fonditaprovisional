	package Fondita.Fer.Service.Impl;
	
	import java.util.List;
	import org.springframework.stereotype.Service;
	import lombok.RequiredArgsConstructor;
	import Fondita.Fer.Client.ClienteClient;
	import Fondita.Fer.DTO.ClienteDto;
	import Fondita.Fer.Service.ClienteService;
	
	@Service
	@RequiredArgsConstructor
	public class ClienteServiceImpl implements ClienteService {
	
	    private final ClienteClient clienteClient;
	
	    @Override
	    public List<ClienteDto> getAllClientes() {
	        return clienteClient.findAll();
	    }
	
	    @Override
	    public ClienteDto getClienteById(Integer id) {
	        return clienteClient.findById(id);
	    }
	
	    @Override
	    public ClienteDto createCliente(ClienteDto clienteDto) {
	        return clienteClient.createCliente(clienteDto);
	    }
	
	    @Override
	    public ClienteDto updateCliente(Integer id, ClienteDto clienteDto) {
	        return clienteClient.updateCliente(id, clienteDto);
	    }
	
	    @Override
	    public void deleteCliente(Integer id) {
	        clienteClient.deleteCliente(id);
	    }
	}
