package pe.edu.upeu.tarea.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HomeControlller {
	@GetMapping("/")
	public String mensaje() {
		return "Tarea Crear Tabla Producto (Postman)";
	}
}
