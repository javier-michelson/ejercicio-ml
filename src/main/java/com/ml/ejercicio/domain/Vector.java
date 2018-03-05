package com.ml.ejercicio.domain;

/**
 * Clase inmutable con un vector en coordenadas cartesianas
 * 
 * @author javier
 *
 */
/**
 * @author javier
 *
 */
public class Vector {

	private final double x;
	private final double y;
	
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public static Vector crearVector (Posicion posicion1, Posicion posicion2) {
		return posicion2.getVector().restar(posicion1.getVector());
	}
	
	public static Vector crearVectorNormalizado(Posicion posicion1, Posicion posicion2) {
		Vector vectorSinNormalizar = crearVector(posicion1, posicion2);
		return vectorSinNormalizar.normalizar();
	}

	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public boolean esColineal(Vector vector, double anguloDesvio) {
		// TODO : considerar angulos negativos de atan2
		double diferenciaAnguloEntreVectores = Math.abs(this.getAngulo() - vector.getAngulo()); 
		
		if (diferenciaAnguloEntreVectores < anguloDesvio) {
			return true;
		}else if (Math.abs(diferenciaAnguloEntreVectores-180) < anguloDesvio ){
			// Vector en direccion opuesta
			return true;
		}else {
			return false;
		}
	}
	
	public Vector multiplicar(double multiplicador) {
		return new Vector(this.getX()*multiplicador, this.getY()*multiplicador);
	}
	
	public Vector normalizar() {
		double longitud = this.getLongitud();
		return new Vector(x/longitud, y/longitud);
	}
	
	public Vector restar(Vector vector) {
		return new Vector(this.x-vector.getX(), this.y-vector.getY());
	}
	
	/**
	 * Calcula el ángulo en grados de este vector con respecto al eje X
	 * 
	 * @return El angulo en grados de este vector con respecto al eje X
	 */
	public double getAngulo() {
		double angle = Math.atan2(this.y,this.x) * 180.0 / Math.PI;
		return angle;
	}
	
	public double getLongitud() {
		return Math.sqrt((x*x)+(y*y));
	}

	@Override
	public String toString() {
		return "Vector [x=" + x + ", y=" + y + "]";
	}

}
