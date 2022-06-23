package com.ceiba.biblioteca.service;

import java.util.Map;
import com.ceiba.biblioteca.model.dto.PrestamoDto;

/**
 *
 * @author Fabian Camayo
 */
public interface PrestamoService {

    public Map<String, Object> crear(PrestamoDto prestamoDto);
    public Map<String, Object> buscar(Long id);
}
