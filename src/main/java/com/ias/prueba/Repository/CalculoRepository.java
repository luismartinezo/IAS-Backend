/**
 * 
 */
package com.ias.prueba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ias.prueba.Model.Servicio;


/**
 * @author Luis Martinez
 * @since 01/2021
 * @version 1.0
 */

@Repository
public interface CalculoRepository extends JpaRepository<Servicio, Long>{

	boolean existsByIdTecnico(String idTecnico);
}
