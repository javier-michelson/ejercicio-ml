package com.ml.ejercicio.service.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ml.ejercicio.domain.Estado;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dia {
	private long dia;
	private Estado estado;
	private Double nivel;
	
	public Dia(com.ml.ejercicio.domain.Dia dia) {
		this.dia = dia.getDia();
		this.estado = dia.getEstado();
		this.nivel = dia.getNivel();
	}

	public long getDia() {
		return dia;
	}

	public Estado getEstado() {
		return estado;
	}

	public Double getNivel() {
		return nivel;
	}
	
}
