/**
 * 
 */
package com.ias.prueba.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Luis Martinez
 * @since 01/2021
 * @version 1.0
 */
@Entity
@Table(name = "Servicio")
public class Servicio {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String descripcion;

    @Column
    private String idServicio;

    @Column
    private String idTecnico;

    @Column
    private String fechaInicio;

    @Column
    private String fechaFin;

//	public Servicio(Long id, String nombre, String descripcion, String idServicio, String idTecnico, String fechaInicio,
//			String fechaFin) {
//		super();
//		this.id = id;
//		this.nombre = nombre;
//		this.descripcion = descripcion;
//		this.idServicio = idServicio;
//		this.idTecnico = idTecnico;
//		this.fechaInicio = fechaInicio;
//		this.fechaFin = fechaFin;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(String idServicio) {
		this.idServicio = idServicio;
	}

	public String getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(String idTecnico) {
		this.idTecnico = idTecnico;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

}
