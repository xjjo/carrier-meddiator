package com.exa.middleware.services.rest.model.carrier;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "tipo", "peso", "dimensiones", "cantidad", "observacion" })
@Generated("jsonschema2pojo")
public class Producto {

	@JsonProperty("tipo")
	private Integer tipo;
	
	@JsonProperty("peso")
	@NotNull	
	private Double peso;
	
	@JsonProperty("dimensiones")
	@NotNull	
	@Valid
	private Dimensiones dimensiones;
	
	@JsonProperty("cantidad")
	@NotNull
	private Integer cantidad;
	
	@JsonProperty("observacion")
	private String observacion;

	@JsonProperty("tipo")
	public Integer getTipo() {
		return tipo;
	}

	@JsonProperty("tipo")
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	@JsonProperty("peso")
	public Double getPeso() {
		return peso;
	}

	@JsonProperty("peso")
	public void setPeso(Double peso) {
		this.peso = peso;
	}

	@JsonProperty("dimensiones")
	public Dimensiones getDimensiones() {
		return dimensiones;
	}

	@JsonProperty("dimensiones")
	public void setDimensiones(Dimensiones dimensiones) {
		this.dimensiones = dimensiones;
	}

	@JsonProperty("cantidad")
	public Integer getCantidad() {
		return cantidad;
	}

	@JsonProperty("cantidad")
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@JsonProperty("observacion")
	public String getObservacion() {
		return observacion;
	}

	@JsonProperty("observacion")
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}