package com.ml.ejercicio.util;

import com.ml.ejercicio.domain.Posicion;
import com.ml.ejercicio.domain.Triangulo;
import com.ml.ejercicio.domain.Vector;

public class Utils {

	/**
	 * Indica si las posiciones están alineadas. Para que los elementos estén
	 * alineados, los ángulos entre los distintos puntos no deben variar en más del
	 * ángulo anguloDesvio. Se toma las posiciones de pares una a una para
	 * determinar si están alineadas. No se comparan todos los ángulos de todas las
	 * combinaciones de puntos.
	 * 
	 * @param anguloDesvio
	 *            el ángulo de desvío que se utiliza como tolerancia para el cálculo
	 * @param posiciones
	 *            las posiciones que se quieren determinar si están alineadas
	 * @return devuelve true si están alineadas dentro de la tolerancia indicada, o
	 *         false en caso contrario
	 */
	public static boolean estanAlineados(double anguloDesvio, Posicion... posiciones) {
		if (posiciones == null || posiciones.length < 3) {
			// Si son menos de 3 puntos, ya están alineados, no hace falta calcular nada.
			return true;
		}

		Vector vectorReferencia = Vector.crearVector(posiciones[0], posiciones[1]);

		for (int i = 2; i < posiciones.length; i++) {
			Vector vector = Vector.crearVector(posiciones[i], posiciones[i - 1]);
			if (!vector.esColineal(vectorReferencia, anguloDesvio)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Cálcula la longitud de un perimetro para un polígono
	 * 
	 * @param posiciones
	 * @return
	 */
	public static double calcularPerimetro(Posicion... posiciones) {
		if (posiciones == null || posiciones.length < 2) {
			// Si son menos de 2 puntos, el perimetro es 0.
			return 0.0d;
		}

		double result = 0.0;

		for (int i = 1; i < posiciones.length; i++) {
			Vector vector = Vector.crearVector(posiciones[i], posiciones[i - 1]);
			result += vector.getLongitud();
		}

		// Sumar vector que cierra entre el último y el primer punto
		Vector vectorCierre = Vector.crearVector(posiciones[0], posiciones[posiciones.length - 1]);

		result += vectorCierre.getLongitud();

		return result;
	}

	public static boolean estaContenidoEnTriangulo(Triangulo triangulo, Posicion posicion) {
		return triangulo.continenPosicion(posicion);
	}

}
