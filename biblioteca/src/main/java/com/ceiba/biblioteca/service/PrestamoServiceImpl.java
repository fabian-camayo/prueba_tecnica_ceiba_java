package com.ceiba.biblioteca.service;

import com.ceiba.biblioteca.model.Libro;
import com.ceiba.biblioteca.model.Prestamo;
import com.ceiba.biblioteca.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.ceiba.biblioteca.util.ResponseUtil;
import com.ceiba.biblioteca.model.dto.PrestamoDto;
import com.ceiba.biblioteca.repository.LibroRepository;
import com.ceiba.biblioteca.repository.PrestamoRespository;
import com.ceiba.biblioteca.repository.UsuarioRepository;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Fabian Camayo
 */
@Service("prestamoService")
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    protected PrestamoRespository prestamoRepository;

    @Autowired
    protected UsuarioRepository usuarioRepository;

    @Autowired
    protected LibroRepository libroRepository;

    @Override
    public Map<String, Object> crear(PrestamoDto prestamoDto) {
        Libro libro = libroRepository.buscarLibroIsbn(prestamoDto.getIsbn());
        List<Usuario> usuarios = usuarioRepository.buscarListUsuarioIdentificacion(prestamoDto.getIdentificacionUsuario());
        // Usuario usuario = usuarioRepository.buscarUsuarioIdentificacion(prestamoDto.getIdentificacionUsuario());

        //Codigo opcional, se recomienda manejar el campo identificacion como unico
        Long tipoUsuario = new Long(0);
        Usuario usuario = new Usuario();
        for (Usuario elemento : usuarios) {
            Long temp1 = elemento.getTipoUsuario().getId();
            Long temp2 = new Long(prestamoDto.getTipoUsuario());
            if (temp1.equals(temp2)) {
                usuario = elemento;
                tipoUsuario = elemento.getTipoUsuario().getId();
            }

        }
        
        
        //Long tipoUsuario = usuario.getTipoUsuario().getId();
        try {
            if (tipoUsuario == 3) {
                List<Prestamo> prestamos = prestamoRepository.buscarPrestamoUsuario(usuario);
                if (prestamos.size() >= 1) {
                    return ResponseUtil.mapError("El usuario con identificación " + usuario.getIdentificacion() + " ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo");
                }
            }

            int dias = diasDevolucion().get(String.valueOf(tipoUsuario));

            Prestamo prestamo = new Prestamo();
            prestamo.setLibro(libro);
            prestamo.setUsuario(usuario);
            prestamo.setFechaPrestamo(new Date());

            prestamoRepository.save(prestamo);
            return ResponseUtil.mapOk(prestamo.getId(), ResponseUtil.fechaMaxima(prestamo.getFechaPrestamo(), dias), prestamo.getLibro().getIsbn(), prestamo.getUsuario().getIdentificacion(), prestamo.getUsuario().getTipoUsuario().getId());
        } catch (Exception e) {

            return ResponseUtil.mapError("Tipo de usuario no permitido en la biblioteca");
        }
    }

    @Override
    public Map<String, Object> buscar(Long id) {
        try {
            Prestamo prestamo = prestamoRepository.buscarPrestamoId(id);
            Long tipoUsuario = prestamo.getUsuario().getTipoUsuario().getId();
            int dias = diasDevolucion().get(String.valueOf(tipoUsuario));
            return ResponseUtil.mapOk(prestamo.getId(), ResponseUtil.fechaMaxima(prestamo.getFechaPrestamo(), dias), prestamo.getLibro().getIsbn(), prestamo.getUsuario().getIdentificacion(), prestamo.getUsuario().getTipoUsuario().getId());

        } catch (Exception e) {
            return ResponseUtil.mapError("Tipo de usuario no permitido en la biblioteca");
        }
    }

    public Map<String, Integer> diasDevolucion() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("1", 10);
        map.put("2", 8);
        map.put("3", 7);
        return map;
    }
}
