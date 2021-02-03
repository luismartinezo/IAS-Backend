package com.ias.prueba;

import java.time.LocalDate;
import java.time.temporal.WeekFields;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	private static long obtenerNumeroSemanasAnio(LocalDate date) {
	       LocalDate mediadoAnio = date.withDayOfMonth(1).withMonth(6);
	       return mediadoAnio.range(WeekFields.ISO.weekOfWeekBasedYear()).getMaximum();
	}
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		
		for (int anio = 2000; anio < 2030; anio++) {
	        long numeroSemanas = obtenerNumeroSemanasAnio(LocalDate.of(anio, 1, 1));
//	        if (numberOfWeeks != 52) {
	            System.out.println("El "+anio + " Tiene " + numeroSemanas + " Semanas");
//	        }
	    }
	}
	
	
	 
	
}
