package com.heitordonato.northernhemisphere.core;

import com.heitordonato.northernhemisphere.core.restclient.IRestClient;
import com.heitordonato.northernhemisphere.model.IpVigilanteModel;

/**
 * @author Heitor Donato
 *
 */
public interface IPfindRest extends IRestClient {

	IpVigilanteModel returnCountry(String ip);

}
