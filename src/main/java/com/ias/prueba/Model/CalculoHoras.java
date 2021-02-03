package com.ias.prueba.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "calculo")
public class CalculoHoras {

		@Id
	    @Column
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column
	    private String idTecnico;
	    
	    @Column
	    private int numSemana;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getIdTecnico() {
			return idTecnico;
		}

		public void setIdTecnico(String idTecnico) {
			this.idTecnico = idTecnico;
		}

		public int getNumSemana() {
			return numSemana;
		}

		public void setNumSemana(int numSemana) {
			this.numSemana = numSemana;
		}
	    
	    
}
