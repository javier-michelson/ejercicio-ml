package com.ml.ejercicio.util;

import com.ml.ejercicio.domain.Dia;
import com.ml.ejercicio.domain.Estado;
import com.ml.ejercicio.domain.SistemaSolar;

public class CalculoDiaPorDefecto<T extends SistemaSolar> implements CalculoDiaStrategy<T> {
	
	@Override
	public boolean aplica(T sistemaUnario) {
		return true;
	}
	
	@Override
	public Dia calcular(T sistemaUnario) {
		return new Dia(sistemaUnario.getDia(), Estado.DESCONOCIDO, null);
	}
	
}
