package com.ml.ejercicio.domain;

/**
 * Esta clase será inmutable. Las coordenadas polares serán la principal
 * referencia. Las coordenadas cartesianas se calcularan de manera tardía cuando
 * se empleen y se guardaran dentro de las variables correspondientes. Al ser la
 * clase inmutable, este cálculo se hará una sóla vez (consideración de threading...)
 * 
 * 
 * Consideraciones: Cómo se va a optar por tener un cierto error cuando se
 * calcule la linealidad de los planetas (para cuando no están alineados con el
 * sol), se utilizará un double que tendrá una precisión más que suficiente para
 * los cálculos.
 * 
 * @author javier
 *
 */
public class Posicion {

	// Coordenadas polares
	private double distanciaCentro;
	private double angulo;
	// coordenadas cartesianas
	private Vector vector;

	public Posicion(double distanciaSol, double anguloGrados) {
		super();
		this.distanciaCentro = distanciaSol;
		this.angulo = anguloGrados;
	}

	public double getAngulo() {
		return angulo;
	}

	public double getDistanciaSol() {
		return distanciaCentro;
	}
	
	public Vector getVector() {
		if (vector==null) {
			this.vector = new Vector(this.getX(), this.getY());
		}
		return this.vector;
	}

	private double getX() {
		return Math.cos(angulo*Math.PI/180.0) * distanciaCentro;
	}

	private double getY() {
		return Math.sin(angulo*Math.PI/180.0) * distanciaCentro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(angulo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(distanciaCentro);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		if (this.angulo != other.getAngulo())
			return false;
		if (this.distanciaCentro != other.distanciaCentro)
			return false;
		return true;
	}

}
