package com.ml.ejercicio.service.rest;

import java.util.Formatter;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ml.ejercicio.domain.ResumenModelo;
import com.ml.ejercicio.service.PrediccionClima;
import com.ml.ejercicio.service.rest.dto.Dia;

@RestController
@RequestMapping("/pronostico")
public class MLGalaxiaRespuestaRestService {

	private static final Logger logger = Logger.getLogger(MLGalaxiaRespuestaRestService.class.getName());

	@Autowired
	private PrediccionClima prediccionClima; 

	@RequestMapping(path = { "/generarModelo" }, method = { RequestMethod.GET })
	public List<Dia> generarModelo(int anios) {
		logger.info(new Formatter().format("Generar Modelo para los próximos %d años", anios).toString());
		return prediccionClima.generarModelo(anios).stream().map(dia -> new Dia(dia)).collect(Collectors.toList());
	}
	
	@RequestMapping(path = { "/resumenModelo" }, method = { RequestMethod.GET })
	public ResumenModelo generarResumenModelo(long dias) {
		logger.info(new Formatter().format("Generar Modelo para los próximos %d días", dias).toString());
		return prediccionClima.generarResumenModelo(dias);
	}
	
	@RequestMapping(path = { "/resumenModelo" }, method = { RequestMethod.GET })
	public ResumenModelo generarResumenModelo(int anios) {
		logger.info(new Formatter().format("Generar Modelo para los próximos %d años", anios).toString());
		return prediccionClima.generarResumenModelo(anios);
	}

	@RequestMapping(path = { "/getEstadoClima" }, method = { RequestMethod.GET })
	public Dia getEstadoTiempo(int dia) {
		logger.info(new Formatter().format("Generar Modelo el día %d", dia).toString());
		return new Dia(prediccionClima.getEstadoDelDia(dia));
	}

}
