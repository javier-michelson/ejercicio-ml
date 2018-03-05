package com.ml.ejercicio.util;

import org.junit.Assert;
import org.junit.Test;

import com.ml.ejercicio.domain.Posicion;

public class UtilsTest {

	@Test
	public void testEstanAlineados() throws Exception {
		Assert.assertFalse(
				Utils.estanAlineados(0.1, 
					new Posicion(500, 180),
					new Posicion(2000, 0),
					new Posicion(1000, 0.3))
				);
		
		Assert.assertTrue(
				Utils.estanAlineados(1, 
					new Posicion(0, 70),
					new Posicion(500, 0),
					new Posicion(2000, 0),
					new Posicion(1000, 0))
				);
	}
	
	@Test
	public void testCalcularPerimetro() throws Exception {
		double longitudTrianguloUnitario = Utils.calcularPerimetro(new Posicion(1,0), new Posicion(1,90), new Posicion(0,0));
		Assert.assertEquals(2+Math.sqrt(2), longitudTrianguloUnitario, 0.1);
	}
	
	
}
