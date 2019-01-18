package com.desafio.service;

import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.desafio.model.ListaLigaDaJustica;
import com.desafio.model.ListaVingadores;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

@Service
public class JogadorService {

	public ListaVingadores consultaVingadores() throws JAXBException {
		final String uri = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

		return new Gson().fromJson(result.getBody(), ListaVingadores.class);

	}

	public ListaLigaDaJustica consultaLigaJustica() throws JsonProcessingException, IOException, JAXBException {
		final String uri = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		JAXBContext jaxbContext = JAXBContext.newInstance(ListaLigaDaJustica.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		return (ListaLigaDaJustica) jaxbUnmarshaller.unmarshal(new StringReader(result.getBody()));
	}
}
