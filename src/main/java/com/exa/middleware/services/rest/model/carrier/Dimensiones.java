package com.exa.middleware.services.rest.model.carrier;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "alto", "largo", "ancho" })
@Generated("jsonschema2pojo")
public class Dimensiones {

	@JsonProperty("alto")
	@NotNull
	private Double alto;
	
	@JsonProperty("largo")
	@NotNull	
	private Double largo;
	
	@JsonProperty("ancho")
	@NotNull
	private Double ancho;

	@JsonProperty("alto")
	public Double getAlto() {
		return alto;
	}

	@JsonProperty("alto")
	public void setAlto(Double alto) {
		this.alto = alto;
	}

	@JsonProperty("largo")
	public Double getLargo() {
		return largo;
	}

	@JsonProperty("largo")
	public void setLargo(Double largo) {
		this.largo = largo;
	}

	@JsonProperty("ancho")
	public Double getAncho() {
		return ancho;
	}

	@JsonProperty("ancho")
	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}

}