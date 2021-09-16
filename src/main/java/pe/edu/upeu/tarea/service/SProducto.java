package pe.edu.upeu.tarea.service;
import java.util.List;

import pe.edu.upeu.tarea.model.Producto;
public interface SProducto {
	Producto create(Producto prod);
	List<Producto> readAll();
	Producto read(Long id);
	void delete(Long id);
	Producto update(Producto prod);
}
