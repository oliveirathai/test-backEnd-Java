package com.desafio.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "liga_da_justica")
public class ListaLigaDaJustica {

	private Codinomes codinomes;

	public Codinomes getCodinomes() {
		return codinomes;
	}

	public void setCodinomes(Codinomes codinomes) {
		this.codinomes = codinomes;
	}


}
