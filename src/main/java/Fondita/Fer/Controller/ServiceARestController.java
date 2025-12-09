package Fondita.Fer.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceARestController {

	@GetMapping("/helloWorld")
	public String helloWorld() {
		return "Hola profaaa, este es mi servicio A que es la fondita owo!";
	}

}