package com.exa.middleware.services.rest.model.carrier;

import java.util.List;
import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "cp_origen", "cp_destino", "sucursal", "productos" })
@Generated("jsonschema2pojo")
public class Delivery {

	@JsonProperty("cp_origen")	
	@NotNull	
	private Integer cpOrigen;
	
	@JsonProperty("cp_destino")	
	@NotNull
	private Integer cpDestino;
	
	@JsonProperty("sucursal")
	@NotNull
	private String sucursal;
	
	@JsonProperty("productos")
	@NotNull	
	@Valid
	private List<Producto> productos = null;

	@JsonProperty("cp_origen")
	public Integer getCpOrigen() {
		return cpOrigen;
	}

	@JsonProperty("cp_origen")
	public void setCpOrigen(Integer cpOrigen) {
		this.cpOrigen = cpOrigen;
	}

	@JsonProperty("cp_destino")
	public Integer getCpDestino() {
		return cpDestino;
	}

	@JsonProperty("cp_destino")
	public void setCpDestino(Integer cpDestino) {
		this.cpDestino = cpDestino;
	}

	@JsonProperty("sucursal")
	public String getSucursal() {
		return sucursal;
	}

	@JsonProperty("sucursal")
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	@JsonProperty("productos")
	public List<Producto> getProductos() {
		return productos;
	}

	@JsonProperty("productos")
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

}