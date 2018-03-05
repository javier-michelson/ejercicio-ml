package com.ml.ejercicio.util;

import java.util.Iterator;

import com.ml.ejercicio.domain.Dia;
import com.ml.ejercicio.domain.Estado;
import com.ml.ejercicio.domain.Planeta;
import com.ml.ejercicio.domain.SistemaUnario;
import com.ml.ejercicio.domain.Triangulo;

public class CalculoDiaEstrellaEnTriangulo implements CalculoDiaStrategy<SistemaUnario> {
	
	private double anguloDesvio;

	public CalculoDiaEstrellaEnTriangulo(double anguloDesvio) {
		this.anguloDesvio = anguloDesvio;
	}

	@Override
	public boolean aplica(SistemaUnario sistemaUnario) {
		if (sistemaUnario.getPlanetas().size() != 3) {
			return true;
		}
		
		Iterator<Planeta> iterator = sistemaUnario.getPlanetas().iterator();
		Planeta planeta1 = iterator.next();
		Planeta planeta2 = iterator.next();
		Planeta planeta3 = iterator.next();
		Triangulo triangulo = new Triangulo(planeta1.getPosicion(), planeta2.getPosicion(),planeta3.getPosicion());
		
		return !Utils.estanAlineados(this.anguloDesvio, planeta1.getPosicion(), planeta2.getPosicion(),planeta3.getPosicion());
	}
	
	@Override
	public Dia calcular(SistemaUnario sistemaUnario) {
		Iterator<Planeta> iterator = sistemaUnario.getPlanetas().iterator();
		Planeta planeta1 = iterator.next();
		Planeta planeta2 = iterator.next();
		Planeta planeta3 = iterator.next();
		Triangulo triangulo = new Triangulo(planeta1.getPosicion(), planeta2.getPosicion(),planeta3.getPosicion());
		
		// Dia de lluvia
		if (triangulo.continenPosicion(sistemaUnario.getEstrella().getPosicion())) {
			return new Dia(sistemaUnario.getDia(), Estado.LLUVIA, triangulo.calcularPerimetro());
		}else {
			return new Dia(sistemaUnario.getDia(), Estado.DESCONOCIDO, null);
		}
	}
	
}
