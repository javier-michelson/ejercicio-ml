package com.ml.ejercicio.util;

import java.util.Iterator;

import com.ml.ejercicio.domain.Dia;
import com.ml.ejercicio.domain.Estado;
import com.ml.ejercicio.domain.Planeta;
import com.ml.ejercicio.domain.Posicion;
import com.ml.ejercicio.domain.SistemaUnario;

public class CalculoDiaPlanetasAlineados implements CalculoDiaStrategy<SistemaUnario> {
	
	private double anguloDesvio;

	public CalculoDiaPlanetasAlineados(double anguloDesvio) {
		this.anguloDesvio = anguloDesvio;
	}

	@Override
	public boolean aplica(SistemaUnario sistemaUnario) {
		if (sistemaUnario.getPlanetas().size() != 3) {
			return true;
		}
		
		Iterator<Planeta> iterator = sistemaUnario.getPlanetas().iterator();
		Posicion posicion1 = iterator.next().getPosicion();
		Posicion posicion2 = iterator.next().getPosicion();
		Posicion posicion3 = iterator.next().getPosicion();
		
		// Al menos los planetas deben estar alineados para esta estrategia
		return Utils.estanAlineados(this.anguloDesvio, posicion1, posicion2, posicion3);
	}
	
	@Override
	public Dia calcular(SistemaUnario sistemaUnario) {
		Iterator<Planeta> iterator = sistemaUnario.getPlanetas().iterator();
		Posicion posicion1 = iterator.next().getPosicion();
		Posicion posicion2 = iterator.next().getPosicion();
		Posicion posicion3 = iterator.next().getPosicion();
		
		
		if (Utils.estanAlineados(this.anguloDesvio, sistemaUnario.getEstrella().getPosicion(), posicion1, posicion2, posicion3)){
			// Alineados con el sol, hay sequía
			return new Dia(sistemaUnario.getDia(), Estado.SEQUIA, null);
		}else {
			// Sin alinear con el sol, condiciones óptimas
			return new Dia(sistemaUnario.getDia(), Estado.OPTIMO, null);
		}
	}
	
}
