package com.desafio.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.desafio.model.Jogador;
import com.desafio.model.ListaLigaDaJustica;
import com.desafio.model.ListaVingadores;
import com.desafio.model.Vingadores;
import com.desafio.service.JogadorService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
public class JogadorController {

	private static final String VINGADORES_NAME = "vingadores";
	private static final String JUSTICEIROS_NAME = "liga_da_justica";
	private static final String JOGADORES_NAME = "jogadores";

	@Autowired
	private JogadorService jogService;

	private ListaLigaDaJustica justiceiros;
	private ListaVingadores vingadores;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() throws JAXBException, JsonProcessingException, IOException {
		if (this.vingadores == null) {
			this.vingadores = jogService.consultaVingadores();
		}
		if (this.justiceiros == null) {
			this.justiceiros = jogService.consultaLigaJustica();
		}
		return new ModelAndView("jogador", "command", new Jogador());
	}

	@RequestMapping(value = "/add-jogador", method = RequestMethod.POST)
	public ModelAndView adicionarCliente(@ModelAttribute("SpringWeb") Jogador jogador, ModelMap model,
			HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		List<Jogador> jogadores = (List<Jogador>) request.getSession().getAttribute(JOGADORES_NAME);
		if (jogadores == null) {
			jogadores = new ArrayList<>();
		}

		if (jogador.getTime().equalsIgnoreCase(VINGADORES_NAME)) {
			List<Vingadores> ving = this.vingadores.getVingadores();

			if (ving.isEmpty()) {
				return new ModelAndView("usuarioNaoDisponivelVingadores");
			}

			Random random = new Random();
			int index = random.nextInt(ving.size());
			
			jogador.setTime(VINGADORES_NAME);
			jogador.setCodinome(ving.get(index).getCodinome());
			
			ving.remove(index);
			
		} else if (jogador.getTime().equalsIgnoreCase(JUSTICEIROS_NAME)) {
			List<String> nomes = this.justiceiros.getCodinomes().getCodinome();

			if (nomes.isEmpty()) {
					return new ModelAndView("usuarioNaoDisponivelLiga");
				}


			Random random = new Random();
			int index = random.nextInt(nomes.size());
			
			jogador.setTime(JUSTICEIROS_NAME);
			jogador.setCodinome(nomes.get(index));
			
			nomes.remove(index);
		}
		
		jogadores.add(jogador);
		request.getSession().setAttribute(JOGADORES_NAME, jogadores);

		return new ModelAndView("/adicionado", "jogadores", jogadores);
	}

	@RequestMapping(value = "/lista-jogadores", method = RequestMethod.GET)
	public ModelAndView listarJogadores(HttpServletRequest request) {

		@SuppressWarnings("unchecked")
		List<Jogador> jogadores = (List<Jogador>) request.getSession().getAttribute(JOGADORES_NAME);

		return new ModelAndView("lista-jogadores", JOGADORES_NAME, jogadores);
	}

}