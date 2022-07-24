package br.com.tiacademy.jogos.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.jogos.domain.Jogo;
import br.com.tiacademy.jogos.service.JogoService;

@RestController
@RequestMapping("/jogo")
public class JogoController {
	
	
	@Autowired 
	private JogoService jogoService;
	
	@GetMapping
	public ResponseEntity<List<Jogo>> listar(){
		List<Jogo> vendedores = jogoService.listar();
		return ResponseEntity.ok(vendedores);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Jogo> especifico(@PathVariable("id") Long id){
		
		Jogo resultado = jogoService.porId(id);
		
		if(Objects.isNull(resultado)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(resultado);
	}
	
	@PostMapping
	public ResponseEntity<Jogo> criar(@RequestBody Jogo jogo){
		Jogo salvo = jogoService.criar(jogo);
		
		return ResponseEntity.ok(salvo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Jogo> editar(@PathVariable("id") Long id, @RequestBody Jogo jogo){
		return ResponseEntity.ok(jogoService.editar(id, jogo));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
		jogoService.excluir(id);
		return ResponseEntity.ok().build();
	}
}
