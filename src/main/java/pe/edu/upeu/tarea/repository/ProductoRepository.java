package pe.edu.upeu.tarea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upeu.tarea.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
