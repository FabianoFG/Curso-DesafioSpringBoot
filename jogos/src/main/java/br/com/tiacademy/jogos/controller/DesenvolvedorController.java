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

import br.com.tiacademy.jogos.domain.Desenvolvedor;
import br.com.tiacademy.jogos.service.DesenvolvedorService;

@RestController
@RequestMapping("/desenvolvedor")
public class DesenvolvedorController {
	
	@Autowired 
	private DesenvolvedorService desenvolvedorService;
	
	@GetMapping
	public ResponseEntity<List<Desenvolvedor>> listar(){
		List<Desenvolvedor> desenvolvedores = desenvolvedorService.listar();
		return ResponseEntity.ok(desenvolvedores);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Desenvolvedor> especifico(@PathVariable("id") Long id){
		
		Desenvolvedor resultado = desenvolvedorService.porId(id);
		
		if(Objects.isNull(resultado)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(resultado);
	}
	
	@PostMapping
	public ResponseEntity<Desenvolvedor> criar(@RequestBody Desenvolvedor desenvolvedor){
		Desenvolvedor salvo = desenvolvedorService.criar(desenvolvedor);
		
		return ResponseEntity.ok(salvo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Desenvolvedor> editar(@PathVariable("id") Long id, @RequestBody Desenvolvedor desenvolvedor){
		return ResponseEntity.ok(desenvolvedorService.editar(id, desenvolvedor));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
		desenvolvedorService.excluir(id);
		return ResponseEntity.ok().build();
	}
}
