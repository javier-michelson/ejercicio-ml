package com.ml.ejercicio.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrianguloTest {
	
	@Test
	public void testContiene() throws Exception {
		Triangulo triangulo = new Triangulo(new Posicion(1,-1), new Posicion(1,181), new Posicion(1,90));
		assertTrue(triangulo.continenPosicion(new Posicion(0, 0)));
	}
	
	@Test
	public void testNoContiene() throws Exception {
		Triangulo triangulo = new Triangulo(new Posicion(1,1), new Posicion(1,179), new Posicion(1,90));
		assertFalse(triangulo.continenPosicion(new Posicion(0, 0)));
	}

}
