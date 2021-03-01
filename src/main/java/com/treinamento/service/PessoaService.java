package com.treinamento.service;

import java.util.List;

import pasta.treinamento.model.Cafe;
import pasta.treinamento.model.Pessoa;
import pasta.treinamento.model.Sala;
import pasta.treinamento.repository.PessoaRepository;

public class PessoaService {
	PessoaRepository pessoaRep;
	Cafe cafe = new Cafe();
	Sala sala = new Sala();
	int cafe1 =1;
	int cafe2 =1;
	int sala1 =1;
	int sala2 =1;
	
	public PessoaService() {
		pessoaRep = new PessoaRepository();
	}
	
	public List<Pessoa> getAllPessoas() {
		List<Pessoa> pessoas = pessoaRep.listarPessoa();
		
		return pessoas;
	}
	
	public void addPessoa(Pessoa pessoa) throws Exception {
		if (pessoa.getNome().length() == 0) {
			throw new Exception("Nome deve possuir mais de 1 caracter");
		}else {
			
			cafe.setId(cafe1);
			pessoa.setCafe1(cafe);
			cafe.setId(cafe2);
			pessoa.setCafe2(cafe);
			sala.setId(sala1);
			pessoa.setSala1(sala);
			sala.setId(sala2);
			pessoa.setSala2(sala);
			
			pessoaRep.salvarPessoa(pessoa);	
		}
	}
}
