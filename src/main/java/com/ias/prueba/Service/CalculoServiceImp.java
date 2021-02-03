/**
 * 
 */
package com.ias.prueba.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ias.prueba.Repository.CalculoRepository;


/**
 * @author Luis Martinez
 * @since 01/2021
 * @version 1.0
 */

@Service
public class CalculoServiceImp implements CalculoService{

	@Autowired
    protected CalculoRepository calculoRepository;


	@Override
	public boolean existeIdTecnico(String idTecnico) {
		return this.calculoRepository.existsByIdTecnico(idTecnico);
	}

}
