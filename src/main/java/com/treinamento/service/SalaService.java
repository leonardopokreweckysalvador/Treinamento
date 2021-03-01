package com.treinamento.service;

import java.util.List;

import pasta.treinamento.model.Sala;
import pasta.treinamento.repository.SalaRepository;

public class SalaService {
	SalaRepository salaRep;
	
	public SalaService() {
		salaRep = new SalaRepository();
	}
	
	public List<Sala> getAllSalas() {
		List<Sala> salas = salaRep.listarSala();
		
		return salas;
	}
	
	public void addSala(Sala sala) throws Exception {
		if (sala.getNome().length() == 0) {
			throw new Exception("Nome deve possuir mais de 1 caracter");
		}else {
			salaRep.salvarSala(sala);
		}
	}
}
