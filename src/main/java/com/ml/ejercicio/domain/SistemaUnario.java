package com.ml.ejercicio.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Configuration;

/**
 * Representa a un sistema solar unario (de una sola estrella) en un instante
 * dado. Esta clase es inmutable, por lo que cuando se realizar un
 * desplazamiento del tiempo para obtener un nuevo estado, el nuevo estado del
 * sistema es devuelto en un nuevo objeto.
 * 
 * @author javier
 *
 */
public class SistemaUnario implements SistemaSolar {

	private long dia;

	private Estrella estrella;

	private List<Planeta> planetas;

	public SistemaUnario(long dia, Estrella estrella, List<Planeta> planetas) {
		this.dia = dia;
		this.estrella = estrella;
		this.planetas = Collections.unmodifiableList(planetas);
	}

	@Override
	public SistemaUnario desplazar(long dias) {
		List<Planeta> nuevoEstadoPlanetas = this.planetas.stream().map(planeta -> planeta.desplazar(dias))
				.collect(Collectors.toList());
		Estrella estrella = this.estrella.desplazar(dias);
		long nuevoDia = this.dia + dias;
		return new SistemaUnario(nuevoDia, estrella, nuevoEstadoPlanetas);
	}

	public long getDia() {
		return dia;
	}

	public List<Planeta> getPlanetas() {
		return planetas;
	}

	public Estrella getEstrella() {
		return this.estrella;
	}

}
