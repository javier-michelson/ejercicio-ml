package com.ml.ejercicio.util;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import com.ml.ejercicio.domain.Dia;
import com.ml.ejercicio.domain.SistemaSolar;

public class CalculoDiaComposite<T extends SistemaSolar> implements CalculoDiaStrategy<T>{
	
	private static final Logger log = Logger.getLogger(CalculoDiaComposite.class.getName());
	
	List<CalculoDiaStrategy<T>> calculoDiaStrategies;

	public CalculoDiaComposite(List<CalculoDiaStrategy<T>> calculoDiaStrategies) {
		this.calculoDiaStrategies = Collections.unmodifiableList(calculoDiaStrategies);
	}
	
	@Override
	public boolean aplica(T sistemaSolar) {
		return this.calculoDiaStrategies.stream().anyMatch(strategy -> strategy.aplica(sistemaSolar));
	}
	
	@Override
	public Dia calcular(T sistemaSolar) {
		Optional<CalculoDiaStrategy<T>> appliedStrategy = this.calculoDiaStrategies.stream().filter(strategy -> strategy.aplica(sistemaSolar)).findFirst();
		if (appliedStrategy.isPresent()) {
			return appliedStrategy.get().calcular(sistemaSolar);
		}else {
			// Esto nunca debería pasar
			String errorMessage = "Se intentó calcular, pero no se pudo obtener la estrategia aplicable";
			log.severe(errorMessage);
			throw new RuntimeException(errorMessage);
		}
	}

}
