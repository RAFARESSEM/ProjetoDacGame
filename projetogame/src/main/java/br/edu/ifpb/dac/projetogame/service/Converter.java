package br.edu.ifpb.dac.projetogame.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.edu.ifpb.dac.projetogame.dto.PecaDTO;
import br.edu.ifpb.dac.projetogame.dto.TabuleiroDTO;
import br.edu.ifpb.dac.projetogame.model.entity.Peca;
import br.edu.ifpb.dac.projetogame.model.entity.Tabuleiro;

@Mapper
public class Converter {
	
	//Converter CONVERTER= Mappers.getMapper(Converter.class);
	
	

	
	
	public  Tabuleiro converterTabuleiro(TabuleiroDTO dto) {	
		Tabuleiro tabuleiro = new Tabuleiro();
		
		tabuleiro.setId(dto.getId());
		tabuleiro.setNome(dto.getNome());
		tabuleiro.setPeca(dto.getPeca());
		
		return tabuleiro;
	}
	
	
	
	public TabuleiroDTO converterTabuleiroDTO(Tabuleiro tabuleiro) {
		TabuleiroDTO dto=new TabuleiroDTO();
		
		dto.setId(tabuleiro.getId());
		dto.setNome(tabuleiro.getNome());
		dto.setPeca(tabuleiro.getPeca());
		
		return dto;
		
	}
	
	
	public  Peca converterPeca(PecaDTO dto) {	
		Peca peca = new Peca();
		
		peca.setId(dto.getId());
		peca.setClasse(dto.getClasse());
		
		return peca;
	}
	
	public PecaDTO converterPecaDTO(Peca peca) {
		PecaDTO dto=new PecaDTO();
		
		dto.setId(peca.getId());
		dto.setClasse(peca.getClasse());
		return dto;
		
	}
	
	
	//@Mapping(source= "id",target="iddto")
	//@Mapping(source="nome", target="nomedto")
	//Tabuleiro converterEntity();
	
	
	//@Mapping(source= "iddto",target="id")
	//@Mapping(source="nomedto", target="nome")
	//TabuleiroDTO converterDto();
	

}
