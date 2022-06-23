package com.ceiba.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ceiba.biblioteca.model.Prestamo;
import com.ceiba.biblioteca.model.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Fabian Camayo
 */
public interface PrestamoRespository extends JpaRepository<Prestamo, Long> {

    //Query utilizada para consultar un prestamo por id, respuesta objeto Prestamo
    @Query(value = "SELECT c FROM Prestamo c WHERE c.id = :id")
    public Prestamo buscarPrestamoId(@Param("id") Long id);

    //Query utilizada para consultar un prestamo por usuario, respuesta lista Prestamo
    @Query(value = "SELECT c FROM Prestamo c WHERE c.usuario = :usuario")
    public List<Prestamo> buscarPrestamoUsuario(@Param("usuario") Usuario usuario);
}
