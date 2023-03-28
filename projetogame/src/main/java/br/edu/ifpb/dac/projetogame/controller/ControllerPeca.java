package br.edu.ifpb.dac.projetogame.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.dac.projetogame.dto.PecaDTO;
import br.edu.ifpb.dac.projetogame.dto.TabuleiroDTO;
import br.edu.ifpb.dac.projetogame.model.entity.Peca;
import br.edu.ifpb.dac.projetogame.model.entity.Tabuleiro;
import br.edu.ifpb.dac.projetogame.model.repository.PecaRepository;
import br.edu.ifpb.dac.projetogame.model.repository.TabuleiroRepository;
import br.edu.ifpb.dac.projetogame.service.Converter;
import br.edu.ifpb.dac.projetogame.service.PecaService;


@RestController
@RequestMapping("/api/peca")
public class ControllerPeca{
	
	@Autowired
	private PecaRepository pecarepository;
	
	
	private PecaService pecaservice;
	//private ModelMapper modelMapper=new ModelMapper();
	private Converter converter;
	
	
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody PecaDTO dto) {
		try {
			Peca peca=converter.converterPeca(dto);
			peca=pecarepository.save(peca);
			dto=converter.converterPecaDTO(peca);
			
			return new ResponseEntity<Object>(dto,HttpStatus.CREATED);
			
			
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
			
		
	}
	
	
	
	public ResponseEntity<String> delete(@PathVariable("id") long id) {
		try {
			pecarepository.deleteById(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Object> update(@PathVariable("id") long id,@RequestBody PecaDTO dto) {
	try {	
		dto.setId(id);
		Peca peca=converter.converterPeca(dto);
		peca=pecarepository.save(peca);
		dto=converter.converterPecaDTO(peca);
		
		return ResponseEntity.ok(dto);
	}catch(Exception e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
	}
	

}
