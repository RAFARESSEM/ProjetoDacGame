package br.edu.ifpb.dac.projetogame.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.projetogame.model.entity.Tabuleiro;
import br.edu.ifpb.dac.projetogame.model.repository.TabuleiroRepository;

@Service
public class TabuleiroService {
	
		private TabuleiroRepository tabuleiroRepository;

	    public TabuleiroService(TabuleiroRepository tabuleiroRepository) {
	        this.tabuleiroRepository = tabuleiroRepository;
	    }

	  
	    public Tabuleiro save(Tabuleiro tabuleiro) {
	        return this.tabuleiroRepository.save(tabuleiro);
	    }

	    public Tabuleiro findById(long id){
	        Optional<Tabuleiro> tabuleiroModel = this.tabuleiroRepository.findById(id);
	        return tabuleiroModel.get();
	    }

	    public List<Tabuleiro> findAll() {
	        return this.tabuleiroRepository.findAll();
	    }

	    public Tabuleiro update(long id, String nome) {
	        Tabuleiro tabuleiro = this.findById(id);
	        tabuleiro.setNome(nome);
	        return this.save(tabuleiro);
	    }

	    public void delete(long id) {
	        Tabuleiro tabuleiro = this.findById(id);
	        this.tabuleiroRepository.delete(tabuleiro);
	    }

	

}
