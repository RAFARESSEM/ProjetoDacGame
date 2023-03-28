package br.edu.ifpb.dac.projetogame;


import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.dac.projetogame.controller.ControllerPeca;
import br.edu.ifpb.dac.projetogame.controller.ControllerTabuleiro;
import br.edu.ifpb.dac.projetogame.model.entity.Peca;
import br.edu.ifpb.dac.projetogame.model.entity.Tabuleiro;



@SpringBootApplication
@RestController
public class ProjetoGameApplication{

	public static void main(String[] args) {
		SpringApplication.run(ProjetoGameApplication.class, args);
	}
	
	@GetMapping("/")
	public String index() {
		return "teste";
	}

}

	

/*

	private ControllerPeca pecaController;
	
	
	private ControllerTabuleiro tabuleiroController;

	
	Scanner input= new Scanner(System.in); 
	Peca peca;
	Tabuleiro tabuleiro;
	

	@Override
	public void run(String... args) throws Exception {
		
		String classe;
		int condicao=0;
		while (condicao!=3) {
			System.out.println("1 adicionar peca e tabuleiro"
					+ "2 mostrar peca e tabuleiro"
					+ "3 sair");
			condicao=Integer.parseInt (input.nextLine());
			
		if (condicao==1){
			System.out.println("nome da classe da peca");
			classe=input.nextLine();
			peca=new Peca(0,classe);
			pecaController.incluirPeca(peca);
			System.out.println("nome do tabuleiro");
			String nome=input.nextLine();
			tabuleiro=new Tabuleiro(0,nome,peca);
			//tabuleiroController.incluirtabuleiro(tabuleiro);
			
		}
	
		else if(condicao==2) {
			System.out.println(pecaController.listarPecas());
			//System.out.println(tabuleiroController.listarTabuleiro());
			
		}
	
		}
		
	} */


