package com.exa.middleware.services.rest.model.carrier;

import java.util.List;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.ParameterScriptAssert;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "cp_destino",
    "orden_id",
    "franja",
    "fragil",
    "sucursal",
    "sucursal_entrega_id",
    "origen",
    "destino",
    "productos"
})
@Generated("jsonschema2pojo")
public class NewDelivery {

    @JsonProperty("id")
    @NotNull
    @Pattern(regexp = "(1000|1101|2000|2101|3000|3101)")
    private String id;
    
    @JsonProperty("cp_destino")
    private Integer cpDestino;
    
    @JsonProperty("orden_id")
    private String ordenId;
    
    @JsonProperty("franja")
    private String franja;
    
    @JsonProperty("fragil")
    private String fragil;
    
    @JsonProperty("sucursal")
    private String sucursal;    
    
    @JsonProperty("sucursal_entrega_id")
    private String sucursalEntregaId;
    
    @JsonProperty("origen")
    @NotNull
	@Valid
    private List<Address> origen = null;
    
    @JsonProperty("destino")
	@Valid
    private List<Address> destino = null;
    
    @JsonProperty("productos")
    @NotNull
	@Valid
    private List<Producto> productos = null;

    
    
    
    
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("cp_destino")
    public Integer getCpDestino() {
        return cpDestino;
    }

    @JsonProperty("cp_destino")
    public void setCpDestino(Integer cpDestino) {
        this.cpDestino = cpDestino;
    }

    @JsonProperty("orden_id")
    public String getOrdenId() {
        return ordenId;
    }

    @JsonProperty("orden_id")
    public void setOrdenId(String ordenId) {
        this.ordenId = ordenId;
    }

    @JsonProperty("franja")
    public String getFranja() {
        return franja;
    }

    @JsonProperty("franja")
    public void setFranja(String franja) {
        this.franja = franja;
    }

    @JsonProperty("fragil")
    public String getFragil() {
        return fragil;
    }

    @JsonProperty("fragil")
    public void setFragil(String fragil) {
        this.fragil = fragil;
    }

    @JsonProperty("sucursal")
    public String getSucursal() {
        return sucursal;
    }

    @JsonProperty("sucursal")
    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }   

    @JsonProperty("sucursal_entrega_id")
    public String getSucursalEntregaId() {
        return sucursalEntregaId;
    }

    @JsonProperty("sucursal_entrega_id")
    public void setSucursalEntregaId(String sucursalEntregaId) {
        this.sucursalEntregaId = sucursalEntregaId;
    }

    @JsonProperty("origen")
    public List<Address> getOrigen() {
        return origen;
    }

    @JsonProperty("origen")
    public void setOrigen(List<Address> origen) {
        this.origen = origen;
    }

    @JsonProperty("destino")
    public List<Address> getDestino() {
        return destino;
    }

    @JsonProperty("destino")
    public void setDestino(List<Address> destino) {
        this.destino = destino;
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