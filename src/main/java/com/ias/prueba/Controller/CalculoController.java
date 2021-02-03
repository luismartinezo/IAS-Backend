/**
 * 
 */
package com.ias.prueba.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ias.prueba.Excepciones.IasExcepcion;
import com.ias.prueba.Model.CalculoHoras;
import com.ias.prueba.Model.Servicio;
import com.ias.prueba.Service.CalculoService;
import com.ias.prueba.Util.restResponse;

/**
 * @author Luis Martinez
 * @since 01/2021
 * @version 1.0
 */

@RestController
@RequestMapping("/api/v1/calculo")
@CrossOrigin(origins = "*")
public class CalculoController {

	 	@Autowired
	    @Qualifier("calculoServiceConfiguration")
	    protected CalculoService calculoService;

	    protected ObjectMapper mapper;
	    

	    @PostMapping("/")
	    public restResponse save(@RequestBody String reporteJson) throws JsonMappingException, JsonProcessingException, IasExcepcion {
	        
	    	this.mapper = new ObjectMapper();
	        Servicio calculo = this.mapper.readValue(reporteJson, Servicio.class);
	        
	        if (!this.validate(calculo)) {
	            return new restResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Campo obligatorio sin diligenciar");
	        }

	        if (!calculoService.existeIdTecnico(calculo.getIdTecnico())) {
	            return new restResponse(HttpStatus.NOT_FOUND.value(), "El ID del tecnico no existe");
	        }
	        
	       
	        return new restResponse(HttpStatus.OK.value(), "Reporte de Servicio guardado con exito");
	    }
	    
	    
	    
	 // Validaciones
	    private boolean validate(Servicio calculo) {
	        boolean isValid = true;
	        
	       
	        if (calculo.getIdTecnico() == null || calculo.getIdTecnico() == "") {
	            isValid = false;
	        }
	        if (calculo.getNumSemana() == 0) {
	            isValid = false;
	        }
	        
	        return isValid;
	    }
	    
}
