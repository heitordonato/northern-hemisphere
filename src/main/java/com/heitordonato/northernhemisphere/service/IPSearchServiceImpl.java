package com.heitordonato.northernhemisphere.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heitordonato.northernhemisphere.core.IPSearchService;
import com.heitordonato.northernhemisphere.core.IPfindRest;
import com.heitordonato.northernhemisphere.core.exception.IpNotFoundException;
import com.heitordonato.northernhemisphere.core.exception.WrongNumberOfIpException;
import com.heitordonato.northernhemisphere.model.IpVigilanteModel;

import java.util.TreeSet;

/**
 * @author Heitor Donato
 *
 */
@Service
public class IPSearchServiceImpl implements IPSearchService{

	@Autowired
	private IPfindRest ipfindrest;
	
	private static final int IP_NOT_FOUND = 0;
	
	private static final int MAX_NUMBER_OF_IP = 5;
	
	private static final String SOUTH_HEMISPHERE_LATITUDE = "-";
	
	public String search(String[] ipList) {

		validateIpList(ipList);
		TreeSet<String> treelist = getCountries(ipList);
		String jsonString = writeJson(treelist);
		return jsonString;
	}

	private TreeSet<String> getCountries(String[] ipList) {
		TreeSet<String> treelist = new TreeSet<>();

		try {
			for(String ip : ipList) {
				IpVigilanteModel ipVigilanteModel = ipfindrest.returnCountry(ip);

				if(!ipVigilanteModel.getData().getLatitude().startsWith(SOUTH_HEMISPHERE_LATITUDE)) {
					treelist.add(ipVigilanteModel.getData().getCountry_name());
				}	
			}	
		} catch (HttpClientErrorException  e) {
			throw e;
		}
		

		return treelist;
	}

	private void validateIpList(String[] ipList) {
		if(ipList.length <= IP_NOT_FOUND) {
			throw new IpNotFoundException();
		} else if(ipList.length > MAX_NUMBER_OF_IP) {
			throw new WrongNumberOfIpException();
		}
	}

	private String writeJson(TreeSet<String> treelist) {
		String json ="";
		ObjectMapper mapper = new ObjectMapper();

		try {
			json = mapper.writeValueAsString(treelist);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return json;
	}
}
