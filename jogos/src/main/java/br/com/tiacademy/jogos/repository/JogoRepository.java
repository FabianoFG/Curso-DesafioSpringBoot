package br.com.tiacademy.jogos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tiacademy.jogos.domain.Jogo;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long>{

}

