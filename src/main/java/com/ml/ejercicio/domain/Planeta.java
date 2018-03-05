package com.ml.ejercicio.domain;

/**
 * Representa un planeta en el instante dado, esta clase es inmutable.
 * 
 * @author javier
 *
 */
public class Planeta extends Cuerpo{

	private double anguloDesplazamientoPorDia;
	
	public Planeta(Posicion posicion, double anguloDesplazamientoPorDia) {
		super(posicion);
		this.anguloDesplazamientoPorDia = anguloDesplazamientoPorDia;
	}

	
	/**
	 * Recalcula la posición del planeta n dias en el futuro (número positivo) o
	 * pasado (número negativo)
	 * 
	 * @param dias
	 */
	@Override
	public Planeta desplazar(long dias) {
		double nuevoAngulo = this.getPosicion().getAngulo();
		nuevoAngulo = nuevoAngulo + (anguloDesplazamientoPorDia * dias);
		nuevoAngulo = nuevoAngulo % 360;
		Posicion nuevaPosicion = new Posicion(this.getPosicion().getDistanciaSol(), nuevoAngulo);
		return new Planeta(nuevaPosicion, anguloDesplazamientoPorDia);
	}

	public double getAnguloDesplazamientoPorDia() {
		return anguloDesplazamientoPorDia;
	}
	
}
