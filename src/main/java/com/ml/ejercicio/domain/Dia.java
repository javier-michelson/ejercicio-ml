package com.ml.ejercicio.domain;

public class Dia {

	private long dia;
	
	private Estado estado;
	
	private Double nivel;
	
	public Dia(long dia, Estado estado, Double nivel) {
		this.dia = dia;
		this.estado = estado;
		this.nivel = nivel;
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
