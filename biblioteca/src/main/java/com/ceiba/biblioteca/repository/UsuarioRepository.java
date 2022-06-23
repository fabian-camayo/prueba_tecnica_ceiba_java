package com.ceiba.biblioteca.repository;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ceiba.biblioteca.model.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Fabian Camayo
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    //Query utilizada para consultar un usuario por identificacion, respuesta usuario
    @Query(value = "SELECT c FROM Usuario c WHERE c.identificacion = :identificacion")
    public Usuario buscarUsuarioIdentificacion(@Param("identificacion") String identificacion);
    
    //Query utilizada para consultar un usuario por identificacion, respuesta lista usuario
    @Query(value = "SELECT c FROM Usuario c WHERE c.identificacion = :identificacion")
    public List<Usuario> buscarListUsuarioIdentificacion(@Param("identificacion") String identificacion);
}
