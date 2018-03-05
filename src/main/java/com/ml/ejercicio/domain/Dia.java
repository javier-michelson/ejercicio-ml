package com.ml.ejercicio.domain;

import javax.annotation.Nullable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dia {

	@Id
	@Column
	private Long dia;
	
	@Column
	private Estado clima;
	
	@Column
	@Nullable
	private Double nivel;
	
	public Dia() {
	}
	
	public Dia(long dia, Estado estado, Double nivel) {
		this.dia = dia;
		this.clima = estado;
		this.nivel = nivel;
	}

	public long getDia() {
		return dia;
	}

	public Estado getEstado() {
		return clima;
	}

	public Double getNivel() {
		return nivel;
	}

}
