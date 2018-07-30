package com.heitordonato.northernhemisphere.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Heitor Donato
 *
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown=true)
public class IpVigilanteModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2147725502646441735L;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("data")
	private IpVigilanteDataModel data;
}
