package com.ml.ejercicio.domain;

/**
 * @author javier
 *
 */
public class Estrella extends Cuerpo{

	public Estrella(Posicion posicion) {
		super(posicion);
	}
	
	/** Las estrellas no tendrán deplazamiento en el sistema de referencia planteado
	 * @see com.ml.ejercicio.domain.Cuerpo#desplazar(long)
	 */
	@Override
	public Estrella desplazar(long dias) {
		return this;
	}

}
