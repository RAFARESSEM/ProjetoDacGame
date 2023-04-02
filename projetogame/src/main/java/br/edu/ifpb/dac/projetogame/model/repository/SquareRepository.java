package br.edu.ifpb.dac.projetogame.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.projetogame.model.entity.Tabuleiro;

@Repository
public interface TabuleiroRepository extends JpaRepository<Tabuleiro,Long>{

}
