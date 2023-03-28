package br.edu.ifpb.dac.projetogame.controller;


import java.util.Optional;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.dac.projetogame.dto.TabuleiroDTO;
import br.edu.ifpb.dac.projetogame.model.entity.Tabuleiro;
import br.edu.ifpb.dac.projetogame.model.repository.TabuleiroRepository;
import br.edu.ifpb.dac.projetogame.service.Converter;



@RestController
@RequestMapping("/api/tabuleiro")
public class ControllerTabuleiro {
//	@Autowired
	//private TabuleiroRepository tabuleiroRepository;
	
	//private Tabuleiro tabuleiro;
	
	@Autowired
	private TabuleiroRepository tabuleirorepository;
	
	
	//private ModelMapper modelMapper=new ModelMapper();
	
	private Converter converter;
	
	
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody TabuleiroDTO dto) {
		try {
			Tabuleiro tabuleiro=converter.converterTabuleiro(dto);
			tabuleiro=tabuleirorepository.save(tabuleiro);
			dto=converter.converterTabuleiroDTO(tabuleiro);
			
			return new ResponseEntity<Object>(dto,HttpStatus.CREATED);
			
			
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
			
		
	}
	
//	public List<Tabuleiro> listarTabuleiro() {
//		return (List<Tabuleiro>) tabuleiroRepository.findAll();
//	}
	
	
	 @GetMapping("{id}")
	 public ResponseEntity<Object> findById(@PathVariable(value = "id") long id) {
	        try {
	            Optional<Tabuleiro> tabuleiro = tabuleirorepository.findById(id);
	            return ResponseEntity.status(HttpStatus.OK).body(tabuleiro);
	        } catch (Exception exception) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("tabuleiro nao encontrado.");
	        }
	    }
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable("id") long id) {
		try {
			tabuleirorepository.deleteById(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	@PutMapping("{id}")
	public ResponseEntity<Object> update(@PathVariable("id") long id,@RequestBody TabuleiroDTO dto) {
	try {	
		dto.setId(id);
		Tabuleiro tabuleiro=converter.converterTabuleiro(dto);
		tabuleiro=tabuleirorepository.save(tabuleiro);
		dto=converter.converterTabuleiroDTO(tabuleiro);
		
		return ResponseEntity.ok(dto);
	}catch(Exception e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
	}
	


}
