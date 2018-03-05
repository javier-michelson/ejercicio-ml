package com.ml.ejercicio.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ml.ejercicio.domain.Estrella;
import com.ml.ejercicio.domain.Planeta;
import com.ml.ejercicio.domain.Posicion;
import com.ml.ejercicio.domain.SistemaUnario;
import com.ml.ejercicio.util.CalculoDiaComposite;
import com.ml.ejercicio.util.CalculoDiaEstrellaEnTriangulo;
import com.ml.ejercicio.util.CalculoDiaPlanetasAlineados;
import com.ml.ejercicio.util.CalculoDiaPorDefecto;
import com.ml.ejercicio.util.CalculoDiaStrategy;


@Configuration
@ComponentScan
public class SistemaMLConfig {

	@Value("${com.ml.ejercicio.anguloFerengi:0}")
	public double anguloFerengi;
	
	@Value("${com.ml.ejercicio.anguloBetasoide:0}")
	public double anguloBetasoide;
	
	@Value("${com.ml.ejercicio.anguloVulcano:0}")
	public double anguloVulcano;

	@Value("${com.ml.dias.por.anio:365}")
	public int diasPorAnio;
	
	@Value("${com.ml.tolerancia.angulo.calculo.colineal:1}")
	public float toleranciaAnguloParaCalculoColineal;

	/**
	 * Notas: en un refactor posterior se puede agregar una Abstract Factory u otro
	 * patron de construcción. Está fuera del alcance de la solución actual.
	 * 
	 * @param anguloFerengi
	 *            angulo de Ferengi en el instante actual
	 * @param anguloBetasoide
	 *            angulo de Betasoide en el instante actual
	 * @param anguloVulcano
	 *            angulo de Vulcano en el instante actual
	 * @return
	 */
	@Bean
	public SistemaUnario createSistema() {
		Planeta ferengi = new Planeta(new Posicion(500, anguloFerengi), -1); // -1 grado, ya que es en sentido antihorario
		Planeta betasoide = new Planeta(new Posicion(2000, anguloBetasoide), -3); // -3 grado, ya que es en sentido antihorario
		Planeta vulcano = new Planeta(new Posicion(1000, anguloVulcano), 5); // 5 grado, ya que es en sentido antihorario

		List<Planeta> planetas = new ArrayList<Planeta>();
		planetas.add(ferengi);
		planetas.add(betasoide);
		planetas.add(vulcano);

		Estrella estrella = new Estrella(new Posicion(0, 0));

		SistemaUnario sistema = new SistemaUnario(0, estrella, planetas);

		return sistema;
	}
	
	@Bean
	public CalculoDiaStrategy crearCalculoDiaStrategy(){
		List<CalculoDiaStrategy<SistemaUnario>> calculoDiaStrategies = new ArrayList<>();
		
		calculoDiaStrategies.add(new CalculoDiaPlanetasAlineados(toleranciaAnguloParaCalculoColineal));
		calculoDiaStrategies.add(new CalculoDiaEstrellaEnTriangulo(toleranciaAnguloParaCalculoColineal));
		calculoDiaStrategies.add(new CalculoDiaPorDefecto<>());
		
		CalculoDiaComposite<SistemaUnario> calculoDiaComposite = new CalculoDiaComposite<SistemaUnario>(calculoDiaStrategies);
		
		return calculoDiaComposite;
	}

}

