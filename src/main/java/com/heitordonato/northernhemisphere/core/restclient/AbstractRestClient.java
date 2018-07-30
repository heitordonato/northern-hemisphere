package com.heitordonato.northernhemisphere.core.restclient;

import org.springframework.web.client.RestTemplate;

/**
 * @author Heitor Donato
 *
 */
public abstract class AbstractRestClient extends RestTemplate implements IRestClient {

    protected String urlBase;

    public AbstractRestClient(String urlBase) {
        this.urlBase = urlBase;
    }

    public String gerarUrl(String...paths) {
        StringBuilder url = new StringBuilder(urlBase);
        for (String path : paths) {
            url.append(path);
        }
        return url.toString();
    }
}
