package com.ceiba.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ceiba.biblioteca.model.Libro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Fabian Camayo
 */
public interface LibroRepository extends JpaRepository<Libro, Integer> {
    
    //Query utilizada para consultar un libro por isbn
    @Query(value = "SELECT c FROM Libro c WHERE c.isbn = :isbn")
    public Libro buscarLibroIsbn(@Param("isbn") String isbn);
}
