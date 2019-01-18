package com.desafio.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "vingadores" })
public class ListaVingadores {

	@JsonProperty("vingadores")
	private List<Vingadores> vingadores;

	public List<Vingadores> getVingadores() {
		return vingadores;
	}

	public void setVingadores(List<Vingadores> vingadores) {
		this.vingadores = vingadores;
	}

}
