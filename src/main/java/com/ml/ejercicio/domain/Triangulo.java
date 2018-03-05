package com.ml.ejercicio.domain;

import com.ml.ejercicio.util.Utils;

public class Triangulo {
	
	private Posicion punto1;
	private Posicion punto2;
	private Posicion punto3;
	
	public Triangulo(Posicion punto1, Posicion punto2, Posicion punto3) {
		this.punto1 = punto1;
		this.punto2 = punto2;
		this.punto3 = punto3;
	}
	
	public boolean esOrientacionPositiva() {
		double x1 = this.punto1.getVector().getX();
		double x2 = this.punto2.getVector().getX();
		double x3 = this.punto3.getVector().getX();
		double y1 = this.punto1.getVector().getY();
		double y2 = this.punto2.getVector().getY();
		double y3 = this.punto3.getVector().getY();
		
		double orientacion = ((x1-x3)*(y2-y3))-((y1-y3)*(x2-x3));
		
		return orientacion > 0;
	}
	
	public boolean continenPosicion(Posicion posicion) {
		boolean orientacion = this.esOrientacionPositiva();
		boolean orientacionT1 = new Triangulo(this.punto1, this.punto2, posicion).esOrientacionPositiva();
		boolean orientacionT2 = new Triangulo(this.punto2, this.punto3, posicion).esOrientacionPositiva();
		boolean orientacionT3 = new Triangulo(this.punto3, this.punto1, posicion).esOrientacionPositiva();
		
		if (orientacion && orientacionT1 && orientacionT2 && orientacionT3) {
			return true;
		}else if (!orientacion && !orientacionT1 && !orientacionT2 && !orientacionT3) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Cálcula la longitud de un perimetro para el triangulo
	 * 
	 * @param posiciones
	 * @return
	 */
	public double calcularPerimetro() {
		return Utils.calcularPerimetro(this.punto1, this.punto2, this.punto3);
	}
	
}
