package br.com.tiacademy.jogos.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tiacademy.jogos.domain.Desenvolvedor;
import br.com.tiacademy.jogos.repository.DesenvolvedorRepository;

@Service
public class DesenvolvedorService {
	
	@Autowired
	private DesenvolvedorRepository desenvolvedorRepository;
	
	public List<Desenvolvedor> listar(){
		return desenvolvedorRepository.findAll();
	}
	
	public Desenvolvedor porId(Long id) {
		return desenvolvedorRepository.findById(id).orElse(null);
	}
	
	public Desenvolvedor criar(Desenvolvedor desenvolvedor) {
		return desenvolvedorRepository.save(desenvolvedor);
	}
	
	public Desenvolvedor editar(Long id, Desenvolvedor editado) {
		Desenvolvedor recuperado = porId(id);
		
		if(Objects.isNull(recuperado)) {
			throw new RuntimeException("não foi encontrado");
		}
		
		recuperado.setNome(editado.getNome());
		
		return desenvolvedorRepository.save(recuperado);
	}
	
	public void excluir(Long id) {
		desenvolvedorRepository.deleteById(id);
	}
}
