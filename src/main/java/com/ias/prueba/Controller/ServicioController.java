package com.ias.prueba.Controller;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ias.prueba.Excepciones.IasExcepcion;
import com.ias.prueba.Model.Servicio;
import com.ias.prueba.Service.ServicioService;
// import com.prueba.Util.queryResult;
import com.ias.prueba.Util.restResponse;
// import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Luis Martinez
 * @since 01/2021
 * @version 1.0
 */

@RestController
@RequestMapping("/api/v1/servicio")
@CrossOrigin(origins = "*")
public class ServicioController {

    @Autowired
    @Qualifier("reporteServiceConfiguration")
    protected ServicioService servicioService;

    protected ObjectMapper mapper;

    // Nuevo Servicio
    @PostMapping("/nuevo")
    public restResponse save(@RequestBody String reporteJson) throws JsonMappingException, JsonProcessingException, IasExcepcion {
        this.mapper = new ObjectMapper();
        Servicio servicio = this.mapper.readValue(reporteJson, Servicio.class);
        
        this.validator(servicio);
        
        if (!this.validate(servicio)) {
            return new restResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Campo obligatorio sin diligenciar");
        }
        if (servicioService.existeIdServicio(servicio.getIdServicio())) {
            return new restResponse(HttpStatus.NOT_FOUND.value(), "El numero de Servicio ya existe");
        }

        this.servicioService.save(servicio);
        return new restResponse(HttpStatus.OK.value(), "Reporte de Servicio guardado con exito");
    }

    // Actualizar Servicio
    @PostMapping("/actualizar")
    public restResponse update(@RequestBody String reporteJson) throws JsonMappingException, JsonProcessingException, IasExcepcion {
        this.mapper = new ObjectMapper();
        
        Servicio servicio = this.mapper.readValue(reporteJson, Servicio.class);
        
        this.validator(servicio);
        
        if (!servicioService.existeId(servicio.getId())) {
            return new restResponse(HttpStatus.NOT_FOUND.value(), "No existe el reporte del servicio en la base de datos");
        }

        if (!this.validate(servicio)) {
            return new restResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Campo obligatorio sin diligenciar");
        }
        this.servicioService.update(servicio);
        return new restResponse(HttpStatus.OK.value(), "Reporte de Servicio actualizo con exito");
    }

    // Listar todos los reportes de servicios
    @GetMapping("/lista")
    public List<Servicio> getReportes() {
        return this.servicioService.findAll();

    }

    // Eliminar Servicio
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.PATCH)
    public String deleteReporte(@PathVariable Long id) {
        return servicioService.delete(id);
    }

    // Detalles Servicio
    @RequestMapping(value = "/detalle/{idTecnico}", method = RequestMethod.GET)
    public Optional<Servicio> detail(@PathVariable Long id) {
        return servicioService.detail(id);
    }

    // Validaciones
    private boolean validate(Servicio servicio) {
        boolean isValid = true;
        
        if (servicio.getNombre() == null || servicio.getNombre() == "") {
            isValid = false;
        }
        if (servicio.getIdServicio() == null || servicio.getIdServicio() == "") {
            isValid = false;
        }
        if (servicio.getIdTecnico() == null || servicio.getIdTecnico() == "") {
            isValid = false;
        }
        if (servicio.getFechaInicio() == null || servicio.getFechaFin() == null) {
            isValid = false;
        }
        
        return isValid;
    }
    
    public void validator(Servicio servicio) throws IasExcepcion {
		if(servicio.getFechaInicio().after(servicio.getFechaFin())) {
			message("La fecha de inicio debe ser menor que la fecha de fin");
		}
		
	}
    private void message(String mensaje) throws IasExcepcion {
    	throw new IasExcepcion(mensaje);
    }
}