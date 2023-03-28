package br.edu.ifpb.dac.projetogame.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.projetogame.model.entity.Peca;


@Repository
public interface PecaRepository extends JpaRepository<Peca,Long>{

}
