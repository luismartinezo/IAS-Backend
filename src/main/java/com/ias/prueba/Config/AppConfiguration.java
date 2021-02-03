/**
 * 
 */
package com.ias.prueba.Config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.ias.prueba.Repository.ServicioRepository;
import com.ias.prueba.Service.CalculoService;
import com.ias.prueba.Service.CalculoServiceImp;
import com.ias.prueba.Service.ServicioService;
import com.ias.prueba.Service.ServicioServiceImp;


/**
 * @author Luis Martinez
 * @since 01/2021
 * @version 1.0
 */

@Configuration
public class AppConfiguration {

	@Bean
	@Qualifier("reporteServiceConfiguration")
	public ServicioService reporteServiceConfiguration() {
		return new ServicioServiceImp(); 
	}
	
	@Bean
	@Qualifier("calculoServiceConfiguration")
	public CalculoService calculoServiceConfiguration() {
		return new CalculoServiceImp(); 
	}
	
}
