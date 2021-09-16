package pe.edu.upeu.tarea.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.tarea.model.Producto;
import pe.edu.upeu.tarea.service.ProductoService;
@RestController
@RequestMapping("/api")
public class ProductoController {
	@Autowired
	private ProductoService productoservice;
	
	@PostMapping("/productos")
	public ResponseEntity<Producto> save(@RequestBody Producto produ){
		try {
			Producto prod = productoservice.create(new Producto(produ.getNombre(), produ.getPrecio(), produ.getStock()));
			return new ResponseEntity<>(prod, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/producto")
	public ResponseEntity<List<Producto>> getProductos(){
		try {
			List<Producto> list = new ArrayList<>();
			list = productoservice.readAll();
			if(list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/producto/{id}")
	public ResponseEntity<Producto> getUser(@PathVariable("id") long id){
		Producto producto = productoservice.read(id);
			if(producto.getIdproducto()>0) {
				return new ResponseEntity<>(producto, HttpStatus.OK);
			}else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	
	@DeleteMapping("producto/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id){
		try {
			productoservice.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("producto/update/{id}")
	public ResponseEntity<Producto> update(@RequestBody Producto produ, @PathVariable("id") long id){
		try {
			Producto ul = productoservice.read(id);
			if (ul.getIdproducto()>0) {
				ul.setNombre(produ.getNombre());
				ul.setPrecio(produ.getPrecio());
				ul.setStock(produ.getStock());
				return new ResponseEntity<>(productoservice.create(ul),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
