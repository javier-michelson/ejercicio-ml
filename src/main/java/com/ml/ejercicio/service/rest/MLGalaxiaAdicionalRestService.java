package com.ml.ejercicio.service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ml.ejercicio.domain.SistemaSolar;
import com.ml.ejercicio.service.PrediccionClima;

@RestController
@RequestMapping("/adicional")
public class MLGalaxiaAdicionalRestService {
	
	@Autowired
	private PrediccionClima prediccionClima;

	@RequestMapping(path = { "/echo" }, method = { RequestMethod.GET })
	public String echo(String value) {
		return value;
	}

	@RequestMapping(path = { "/sistemaSolar" }, method = { RequestMethod.GET })
	public SistemaSolar getSistemaSolarInicial(long dia) {
		return prediccionClima.getSistemaSolar(dia);
	}
}
