package com.ml.ejercicio.service;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ml.ejercicio.config.SistemaMLConfig;
import com.ml.ejercicio.domain.Dia;
import com.ml.ejercicio.domain.ResumenModelo;
import com.ml.ejercicio.domain.SistemaSolar;
import com.ml.ejercicio.repository.DiaRepository;
import com.ml.ejercicio.util.CalculoDiaStrategy;

/**
 * Requisitos no validados para esta solución:
 * 
 * Dado que se pide realizar el calculo de la cantidad de años, y puesto a que
 * un año está definido por la vuelta al sistema solar (360º), por lo que
 * variará según cada planeta, se asume para la presente solución de que al
 * hablar de años, se supondra equivalente a decir 365 días. Además 1 día
 * también se referirá ua día "terraqueo" y será el mismo para todos los
 * planetas, irrespectivo por el momento de su ciclo de rotación.
 * 
 * 
 * Precondiciones
 * 
 * Se considera para esta solución necesario el indicar la situación actual de
 * cada planeta, es decir, el ángulo actual de cada uno. Para la configuración
 * por defecto, se considera que todos los planetas tienen un ángulo 0º.
 * 
 * El estado actual se consireda como la referencia, el día 0.
 * 
 * @author javier
 *
 */
@Component
public class PrediccionClima {

	private static Logger logger = Logger.getLogger(PrediccionClima.class.getName());

	@Autowired
	private SistemaMLConfig config;

	@Autowired
	private SistemaSolar sistemaSolar;

	@Autowired
	private CalculoDiaStrategy<SistemaSolar> calculoDiaStrategy;

	@Autowired
	private DiaRepository diaRepository;

	/**
	 * Genera y guarda el modelo para los n dias posteriores
	 * 
	 * @param anios
	 * @return
	 */
	public List<Dia> generarModelo(int anios) {
		List<Dia> resultado = this.generarModelo((long) anios * config.diasPorAnio);
		this.diaRepository.saveAll(resultado);
		return resultado;
	}

	/**
	 * Obtiene los valores persistidos para los anios indicados por parámetro
	 * 
	 * @param maximaCantidadDeAnios
	 * @return
	 */
	public List<Dia> findValoresDelModelo(int maximaCantidadDeAnios) {
		return this.diaRepository.findByDiaLessThanOrderByDia(maximaCantidadDeAnios * config.diasPorAnio);
	}

	/**
	 * Obtiene los valores persistids para los dias indicados por parámetro
	 * 
	 * @param maximaCantidadDeDias
	 * @return
	 */
	public List<Dia> findValoresDelModelo(long maximaCantidadDeDias) {
		return this.diaRepository.findByDiaLessThanOrderByDia(maximaCantidadDeDias);
	}

	public List<Dia> generarModelo(long dias) {
		List<Dia> result = new ArrayList<Dia>();
		for (int dia = 0; dia < dias; dia++) {
			result.add(this.getEstadoDelDia(dia));
		}
		return result;
	}

	public ResumenModelo generarResumenModelo(int anios) {
		return this.generarResumenModelo((long) anios * config.diasPorAnio);
	}

	public ResumenModelo generarResumenModelo(long dias) {
		ResumenModelo result = new ResumenModelo();

		for (int dia = 0; dia < dias; dia++) {
			Dia estadoDelDia = this.getEstadoDelDia(dia);
			result.add(estadoDelDia);
		}

		return result;
	}

	public Dia getEstadoDelDia(long dia) {
		SistemaSolar sistemaSolarDelDia = sistemaSolar.desplazar(dia);
		if (calculoDiaStrategy.aplica(sistemaSolarDelDia)) {
			return calculoDiaStrategy.calcular(sistemaSolarDelDia);
		} else {
			String message = new Formatter().format("No se pudo calcular el estado del dia %d", dia).toString();
			logger.severe(message);
			throw new RuntimeException(message);
		}
	}

	public SistemaSolar getSistemaSolar(long dia) {
		return sistemaSolar.desplazar(dia);
	}

}
