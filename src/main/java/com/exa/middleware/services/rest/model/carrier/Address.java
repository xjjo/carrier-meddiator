
package com.exa.middleware.services.rest.model.carrier;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "referente",
    "dni",
    "calle",
    "altura",
    "piso",
    "dpto",
    "observacion",
    "cp",
    "email",
    "telefono",
    "localidad",
    "provincia"
})
@Generated("jsonschema2pojo")
public class Address {

    @JsonProperty("referente")
    @NotNull
    private String referente;
    
    @JsonProperty("dni")
    @NotNull
    private String dni;
    
    @JsonProperty("calle")
    @NotNull
    private String calle;
    
    @JsonProperty("altura")
    @NotNull
    private String altura;
    
    @JsonProperty("piso")
    private String piso;
    
    @JsonProperty("dpto")
    private String dpto;
    
    @JsonProperty("observacion")
    private String observacion;
    
    @JsonProperty("cp")
    @NotNull
    private Integer cp;
    
    @JsonProperty("email")    
    private String email;
    
    @JsonProperty("telefono")
    @NotNull
    private String telefono;
    
    @JsonProperty("localidad")
    @NotNull
    private String localidad;
    
    @JsonProperty("provincia")
    @NotNull
    private String provincia;

    @JsonProperty("referente")
    public String getReferente() {
        return referente;
    }

    @JsonProperty("referente")
    public void setReferente(String referente) {
        this.referente = referente;
    }

    @JsonProperty("dni")
    public String getDni() {
        return dni;
    }

    @JsonProperty("dni")
    public void setDni(String dni) {
        this.dni = dni;
    }

    @JsonProperty("calle")
    public String getCalle() {
        return calle;
    }

    @JsonProperty("calle")
    public void setCalle(String calle) {
        this.calle = calle;
    }

    @JsonProperty("altura")
    public String getAltura() {
        return altura;
    }

    @JsonProperty("altura")
    public void setAltura(String altura) {
        this.altura = altura;
    }

    @JsonProperty("piso")
    public String getPiso() {
        return piso;
    }

    @JsonProperty("piso")
    public void setPiso(String piso) {
        this.piso = piso;
    }

    @JsonProperty("dpto")
    public String getDpto() {
        return dpto;
    }

    @JsonProperty("dpto")
    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    @JsonProperty("observacion")
    public String getObservacion() {
        return observacion;
    }

    @JsonProperty("observacion")
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @JsonProperty("cp")
    public Integer getCp() {
        return cp;
    }

    @JsonProperty("cp")
    public void setCp(Integer cp) {
        this.cp = cp;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("telefono")
    public String getTelefono() {
        return telefono;
    }

    @JsonProperty("telefono")
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @JsonProperty("localidad")
    public String getLocalidad() {
        return localidad;
    }

    @JsonProperty("localidad")
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @JsonProperty("provincia")
    public String getProvincia() {
        return provincia;
    }

    @JsonProperty("provincia")
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

}
