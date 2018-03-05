## Introducción

El proyecto utiliza spring-boot debido a la rapidez y facilidad de construcción, así como también por la madurez de su desarrollo.


## Configuración

Las siguiente configuraciónes se pueden proporcionar al deployar la aplicación:

- **com.ml.ejercicio.anguloFerengi (por defecto 0)**: es el ángulo inicial al que se encuentra Ferengi 
	
- **com.ml.ejercicio.anguloBetasoide (por defecto 0)**: es el ángulo inicial al que se encuentra Betasoide
	
- **com.ml.ejercicio.anguloVulcano (por defecto 0)**: es el ángulo inicial al que se encuentra Vulcano

- **com.ml.dias.por.diasPorAnio (por defecto 365)**: es la cantidad de dias que tiene un año para los cálculos
	
- **com.ml.tolerancia.angulo.calculo.colineal (por defecto 1)**: es el ángulo de tolerancia para calcular al colinealidad de los cuerpos


## Uso

Se puede acceder a la url http://[HOST]/swagger-ui.html para poder ver la definición e invocar los endpoints rest de los distintos servicios que expone la aplicación.

**Nota** : Tener en cuenta que la configuración del angulo de tolerancia para determinar la colinealidad y las condiciones iniciales afectan el resultado de la ejecución 


## Requisitos a revisar

**Concepto de año**: en el ejercicio se habla sobre el concepto de año, por el momento se considerará al año como el equivalene a 365 días, ya que en otro caso deberíamos indicar con referencia a que planeta estamos considerando al mismo.

  