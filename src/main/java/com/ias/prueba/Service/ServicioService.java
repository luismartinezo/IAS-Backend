package com.ias.prueba.Service;

import java.util.List;
import java.util.Optional;

import com.ias.prueba.Model.Servicio;

// import org.springframework.stereotype.Service;

/**
 * @author Luis Martinez
 * @since 01/2021
 * @version 1.0
 */

// @Service
public interface ServicioService {

    // Guardar Servicio
    Servicio save(Servicio servicio);

    // Listar Servicio
    List<Servicio> findAll();

    // actualizar servicio
    Servicio update(Servicio servicio);

    // Eliminar Servicio por el id
    String delete(Long id);

    // Verificar la existencia del id
    boolean existeId(Long id);

    // Detalles del servicio por id
    Optional<Servicio> detail(Long id);

}