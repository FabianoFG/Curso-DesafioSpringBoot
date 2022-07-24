package br.com.tiacademy.jogos.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tiacademy.jogos.domain.Jogo;
import br.com.tiacademy.jogos.repository.JogoRepository;

@Service
public class JogoService {
	
	@Autowired
	private JogoRepository jogoRepository;
	
	public List<Jogo> listar(){
		return jogoRepository.findAll();
	}
	
	public Jogo porId(Long id) {
		return jogoRepository.findById(id).orElse(null);
	}
	
	public Jogo criar(Jogo jogo) {
		return jogoRepository.save(jogo);
	}
	
	public Jogo editar(Long id, Jogo editado) {
		Jogo recuperado = porId(id);
		
		if(Objects.isNull(recuperado)) {
			throw new RuntimeException("não foi encontrado");
		}
		
		recuperado.setNome(editado.getNome());
		
		return jogoRepository.save(recuperado);
	}
	
	public void excluir(Long id) {
		jogoRepository.deleteById(id);
	}
}

