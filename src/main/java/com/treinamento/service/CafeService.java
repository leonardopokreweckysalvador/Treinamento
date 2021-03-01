package com.treinamento.service;

import java.util.List;

import pasta.treinamento.model.Cafe;
import pasta.treinamento.repository.CafeRepository;

public class CafeService {
	CafeRepository cafeRep;
	
	public CafeService() {
		cafeRep = new CafeRepository();
	}
	
	public List<Cafe> getAllCafes() {
		List<Cafe> cafe = cafeRep.listarCafe();	
		
		return cafe;
	}
	
	public void addCafe(Cafe cafe) throws Exception {
		if(cafe.getNome().length() == 0) {
			throw new Exception("Nome deve possuir mais de 1 caracter");
		}else {
			cafeRep.salvarCafe(cafe);
		}
	}
}
