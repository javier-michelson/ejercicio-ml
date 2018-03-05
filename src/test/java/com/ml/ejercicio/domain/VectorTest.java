package com.ml.ejercicio.domain;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class VectorTest {
	
	
	@Test
	public void testCalcularAngulo() throws Exception {
		Assert.assertEquals(90.0, new Vector(0,1).getAngulo(), 0.0001);
		Assert.assertEquals(0.0, new Vector(1,0).getAngulo(), 0.0001);
		Assert.assertEquals(45.0, new Vector(1,1).getAngulo(), 0.0001);
	}

}
