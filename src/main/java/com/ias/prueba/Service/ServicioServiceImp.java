package com.ias.prueba.Service;

import java.util.List;
import java.util.Optional;

// import com.prueba.Model.Department;
import com.ias.prueba.Model.Servicio;
import com.ias.prueba.Repository.ServicioRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Luis Martinez
 * @since 01/2021
 * @version 1.0
 */

@Service
public class ServicioServiceImp implements ServicioService {
	
    @Autowired
    protected ServicioRepository servicioRepository;

    @Override
    public Servicio save(Servicio servicio) {
        // Metodo Autogenerado para guardar servicio
        return this.servicioRepository.save(servicio);
    }

    @Override
    public List<Servicio> findAll() {
        // Metodo Autogenerado para listar servicio
        return this.servicioRepository.findAll();
        
    }

    @Override
    public String delete(Long id) {
        // Metodo Autogenerado para eliminar servicio
        if (servicioRepository.findById(id).isPresent()) {
            servicioRepository.deleteById(id);
            return "Servicio eliminado correctamente.";
        }
        return "Error! El Servicio no existe";
        

    }

    @Override
    public boolean existeId(Long id) {
        // Metodo Autogenerado para verificar si exite el id
        return this.servicioRepository.existsById(id);
    }

    @Override
    public Servicio update(Servicio servicio) {
        // Metodo Autogenerado para actualizar servicio
        return this.servicioRepository.save(servicio);
    }

    @Override
    public Optional<Servicio> detail(Long id) {
        // Metodo Autogenerado para mostrar detalles del servicio por medio del id
        Optional<Servicio> servicio = servicioRepository.findById(id);
        return servicio;
    }

	@Override
	public boolean existeIdServicio(String idServicio) {
		return this.servicioRepository.existsByIdServicio(idServicio);
	}

}