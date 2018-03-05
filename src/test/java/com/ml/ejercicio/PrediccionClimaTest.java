package com.ml.ejercicio;

import org.junit.Test;

import com.ml.ejercicio.service.PrediccionClima;

public class PrediccionClimaTest {
	
	PrediccionClima prediccionClima = new PrediccionClima();
	
	@Test
	public void predecirClimaTresDias() {
		System.out.println(prediccionClima.getDiasOptimosProximosAnios(1));
		System.out.println(prediccionClima.getDiasOptimosProximosAnios(1000));
	}
	
	@Test
	public void test() {
		System.out.println(400.0%360);
		System.out.println(Math.cos(Math.PI));
	}
}
