package com.heitordonato.northernhemisphere.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Heitor Donato
 *
 */
@Getter
@Setter
@ToString(of = { "ipv4", "country_name", "latitude" })
@JsonIgnoreProperties(ignoreUnknown=true)
public class IpVigilanteDataModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3885221672501863282L;
	
	@JsonProperty("ipv4")
	private String ipv4;
	
	@JsonProperty("continent_name")
	private String continent_name;
	
	@JsonProperty("country_name")
	private String country_name;
	
	@JsonProperty("subdivision_1_name")
	private String subdivision_1_name;
	
	@JsonProperty("subdivision_2_name")
	private String subdivision_2_name;
	
	@JsonProperty("city_name")
	private String city_name;
	
	@JsonProperty("latitude")
	private String latitude;
	
	@JsonProperty("longitude")
	private String longitude;
	
}
