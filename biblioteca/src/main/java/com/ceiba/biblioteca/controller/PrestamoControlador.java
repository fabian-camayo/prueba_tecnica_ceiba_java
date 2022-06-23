package com.ceiba.biblioteca.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import com.ceiba.biblioteca.model.dto.PrestamoDto;
import com.ceiba.biblioteca.service.PrestamoService;
import com.ceiba.biblioteca.repository.PrestamoRespository;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/")
@SuppressWarnings("unchecked")
public class PrestamoControlador {

    @Autowired
    protected PrestamoService prestamoService;

    @Autowired
    protected PrestamoRespository prestamoRepository;

    @GetMapping("/prestamo/{id}")
    public ResponseEntity<Map<String, Object>> getPrestamo(
            @PathVariable("id") Long id) {
        try {
            Map<String, Object> map = prestamoService.buscar(id);
            HttpStatus statusresponse = HttpStatus.valueOf(Integer.parseInt(map.get("status").toString()));
            return new ResponseEntity(map, statusresponse);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/prestamo")
    public ResponseEntity<Map<String, Object>> crearPrestamo(@Valid @RequestBody PrestamoDto prestamoDto) {

        try {
            Map<String, Object> map = prestamoService.crear(prestamoDto);
            HttpStatus statusresponse = HttpStatus.valueOf(Integer.parseInt(map.get("status").toString()));
            return new ResponseEntity(map, statusresponse);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.BAD_REQUEST);

        }

    }

}
