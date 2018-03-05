package com.ml.ejercicio.util;

import com.ml.ejercicio.domain.Dia;
import com.ml.ejercicio.domain.SistemaSolar;

/**
 * Permite calcular el pronóstico del tiempo para el estado del Sistema Solar.
 * 
 * @param <T>  clase que extiende {@code SistemaSolar} para el que se usará la estrategia.
 * @author javier
 */
public interface CalculoDiaStrategy<T extends SistemaSolar> {
	
	/**
	 * Indica is la estregia se aplica o no al estado del Sistema Solar
	 * 
	 * @param sistemaSolar
	 * @return
	 */
	public boolean aplica(T sistemaSolar);
	
	
	/**
	 * Calcula el estado del día para el estado del Sistema Solar
	 * @param sistemaSolar
	 * @return
	 */
	public Dia calcular(T sistemaSolar);
	
}
