package com.ml.ejercicio.domain;

import static com.ml.ejercicio.domain.Estado.*;

public class ResumenModelo {
	
	long cantidadDiasLluvia = 0;
	double valorDiaMasLluvioso = 0;
	double valorDiaMenosLluvioso = 0;
	long cantidadDiasSequia = 0;
	long cantidadDiasDesconocido = 0;
	long cantidadDiasOptimos = 0;

	long diaInicioPeriodo = 0;
	long diaFinPeriodo = 0;
	
	public void add(Dia dia) {
		switch(dia.getEstado()) {
			case LLUVIA:
				this.addCantidadDiasLluvia(1);
				this.setValorDiaMasLluvioso(dia.getNivel());
				break;
			case SEQUIA:
				this.addCantidadDiasSequia(1);
				break;
			case OPTIMO:
				this.addCantidadDiasOptimos(1);
				break;
			default: 
				this.addCantidadDiasDesconocido(1);
				break;	
		}
	}
	
	protected void addCantidadDiasLluvia(long cantidad) {
		cantidadDiasLluvia += cantidad;
	}
	protected void updateValorDiaLluvioso(double nivelLluvioso) {
		this.setValorDiaMasLluvioso(nivelLluvioso);
		this.setValorDiaMenosLluvioso(nivelLluvioso);
	}
	protected void setValorDiaMasLluvioso(double valorDiaMasLluvioso) {
		this.valorDiaMasLluvioso = Math.max(this.valorDiaMasLluvioso, valorDiaMasLluvioso);
	}
	protected void setValorDiaMenosLluvioso(double valorDiaMenosLluvioso) {
		this.valorDiaMasLluvioso = Math.min(this.valorDiaMenosLluvioso, valorDiaMenosLluvioso);
	}
	protected void addCantidadDiasSequia(long cantidad) {
		cantidadDiasSequia += cantidad;
	}
	protected void addCantidadDiasDesconocido(long cantidad) {
		cantidadDiasDesconocido += cantidad;
	}
	protected void addCantidadDiasOptimos(long cantidad) {
		cantidadDiasOptimos += cantidad;
	}
	protected void addDiaInicioPeriodo(long cantidad) {
		diaInicioPeriodo += cantidad;
	}
	protected void addDiaFinPeriodo(long cantidad) {
		diaFinPeriodo += cantidad;
	}
	
	public long getCantidadDiasLluvia() {
		return cantidadDiasLluvia;
	}
	public double getValorDiaMasLluvioso() {
		return valorDiaMasLluvioso;
	}
	public double getValorDiaMenosLluvioso() {
		return valorDiaMenosLluvioso;
	}
	public long getCantidadDiasSequia() {
		return cantidadDiasSequia;
	}
	public long getCantidadDiasDesconocido() {
		return cantidadDiasDesconocido;
	}
	public long getCantidadDiasOptimos() {
		return cantidadDiasOptimos;
	}
	public long getDiaInicioPeriodo() {
		return diaInicioPeriodo;
	}
	public long getDiaFinPeriodo() {
		return diaFinPeriodo;
	}
	
}
