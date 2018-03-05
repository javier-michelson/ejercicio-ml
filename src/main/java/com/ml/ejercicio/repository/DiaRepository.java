package com.ml.ejercicio.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ml.ejercicio.domain.Dia;

public interface DiaRepository extends CrudRepository<Dia, Long>{

	List<Dia> findByDiaLessThanOrderByDia(long dia);
}
