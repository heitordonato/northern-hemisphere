/**
 * 
 */
package com.heitordonato.northernhemisphere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.heitordonato.northernhemisphere.core.IPSearchService;

import lombok.Setter;

/**
 * @author Heitor Donato
 *
 */
@RestController
@RequestMapping("/northcountries")
@Setter
public class IpSearchController {

	@Autowired
	protected IPSearchService service;
	
	@GetMapping()
	public String consultar(@RequestParam(value = "ip", required = true) String[] ipList) {
		return this.service.search(ipList);
	}
}
