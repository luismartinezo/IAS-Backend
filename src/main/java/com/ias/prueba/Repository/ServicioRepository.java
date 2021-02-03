package com.ias.prueba.Repository;

// import java.util.List;

import com.ias.prueba.Model.Servicio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Luis Martinez
 * @since 01/2021
 * @version 1.0
 */

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long> {

	boolean existsByIdServicio(String idServicio);

}