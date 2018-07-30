package com.heitordonato.northernhemisphere.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import com.heitordonato.northernhemisphere.core.IPfindRest;
import com.heitordonato.northernhemisphere.core.restclient.AbstractRestClient;
import com.heitordonato.northernhemisphere.model.IpVigilanteModel;

/**
 * @author Heitor Donato
 *
 */
@Component
public class IPfindRestImpl extends AbstractRestClient implements IPfindRest {

    public IPfindRestImpl(@Value("${ip.url}") String urlBase) {
        super(urlBase);
    }

    @Override
    public IpVigilanteModel returnCountry(String ip) {
        //@formatter:off
        String url = UriComponentsBuilder
                .fromHttpUrl(gerarUrl(ip)).toUriString();
        
        IpVigilanteModel ipVigilanteModel = getForObject(url, IpVigilanteModel.class);
        
        return ipVigilanteModel;
    }
}
