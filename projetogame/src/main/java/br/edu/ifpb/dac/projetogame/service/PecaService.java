package br.edu.ifpb.dac.projetogame.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.projetogame.model.entity.Peca;
import br.edu.ifpb.dac.projetogame.model.entity.Tabuleiro;
import br.edu.ifpb.dac.projetogame.model.repository.PecaRepository;
import br.edu.ifpb.dac.projetogame.model.repository.TabuleiroRepository;

@Service
public class PecaService {

	private PecaRepository pecaRepository;

    public PecaService(PecaRepository pecaRepository) {
        this.pecaRepository = pecaRepository;
    }

  
    public Peca save(Peca peca) {
        return this.pecaRepository.save(peca);
    }

    public Peca findById(long id){
        Optional<Peca> pecaModel = this.pecaRepository.findById(id);
        return pecaModel.get();
    }

    public List<Peca> findAll() {
        return this.pecaRepository.findAll();
    }

    public Peca update(long id, String classe) {
        Peca peca = this.findById(id);
        peca.setClasse(classe);
        return this.save(peca);
    }

    public void delete(long id) {
        Peca peca = this.findById(id);
        this.pecaRepository.delete(peca);
    }
   
   



}
