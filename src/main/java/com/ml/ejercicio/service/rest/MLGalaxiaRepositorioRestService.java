package com.ml.ejercicio.service.rest;

import java.util.Formatter;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ml.ejercicio.service.PrediccionClima;
import com.ml.ejercicio.service.rest.dto.Dia;

@RestController
@RequestMapping("/repositorio")
public class MLGalaxiaRepositorioRestService {

	private static final Logger logger = Logger.getLogger(MLGalaxiaRepositorioRestService.class.getName());
	
	@Autowired
	private PrediccionClima prediccionClima; 

	@RequestMapping(path = { "/generarModelo" }, method = { RequestMethod.GET })
	public List<Dia> generarModelo(int anios) {
		logger.info(new Formatter().format("Generar Modelo para los próximos %d años", anios).toString());
		return prediccionClima.generarModelo(anios).stream().map(dia -> new Dia(dia)).collect(Collectors.toList());
	}
	
	@RequestMapping(path = { "/generarModeloDias" }, method = { RequestMethod.GET })
	public List<Dia> generarModelo(long dias) {
		logger.info(new Formatter().format("Generar Modelo para los próximos %d días", dias).toString());
		return prediccionClima.generarModelo(dias).stream().map(dia -> new Dia(dia)).collect(Collectors.toList());
	}
	
	@RequestMapping(path = { "/obtenerModelo" }, method = { RequestMethod.GET })
	public List<Dia> obtenerValores(int anios) {
		logger.info(new Formatter().format("Generar Modelo para los próximos %d años", anios).toString());
		return prediccionClima.findValoresDelModelo(anios).stream().map(dia -> new Dia(dia)).collect(Collectors.toList());
	}
	
	@RequestMapping(path = { "/obtenerModeloDias" }, method = { RequestMethod.GET })
	public List<Dia> obtenerValores(long dias) {
		logger.info(new Formatter().format("Generar Modelo para los próximos %d días", dias).toString());
		return prediccionClima.findValoresDelModelo(dias).stream().map(dia -> new Dia(dia)).collect(Collectors.toList());
	}

}
