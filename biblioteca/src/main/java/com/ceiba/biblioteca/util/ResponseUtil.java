package com.ceiba.biblioteca.util;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Fabian Camayo
 */
public class ResponseUtil {
        public static String fechaMaxima(Date fecha, int dias) {

        ZoneId defaultZoneId = ZoneId.systemDefault();
        Instant instant = fecha.toInstant();
        LocalDate fecharesultante = instant.atZone(defaultZoneId).toLocalDate();

        int agregarDias = 0;
        while (agregarDias < dias) {
            fecharesultante = fecharesultante.plusDays(1);
            if (!(fecharesultante.getDayOfWeek() == DayOfWeek.SATURDAY || fecharesultante.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++agregarDias;
            }
        }

        Date fecharesultanteTemporal = Date
                .from(fecharesultante.atStartOfDay(defaultZoneId).toInstant());
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String fechaMaximaDevolucion = simpleDateFormat.format(fecharesultanteTemporal);
        return fechaMaximaDevolucion;
    }

    public static Map<String, Object> mapOk(Long id, String fechaMaximaDevolucion, String isbn, String identificacionUsuario, Long tipoUsuario) {
        Map<String, Object> modelMap = new HashMap<>(6);
        modelMap.put("id", id);
        modelMap.put("fechaMaximaDevolucion", fechaMaximaDevolucion);
        modelMap.put("isbn", isbn);
        modelMap.put("identificacionUsuario", identificacionUsuario);
        modelMap.put("tipoUsuario", tipoUsuario);
        modelMap.put("status", 200);
        return modelMap;
    }

    public static Map<String, Object> mapError(String e) {
        Map<String, Object> modelMap = new HashMap<>(2);
        modelMap.put("mensaje", e);
        modelMap.put("status", 400);
        return modelMap;
    }
}
