package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)//buscou o game no banco de dados
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get(); // usar o .get porque dentro do id está como optional
		GameDTO dto = new GameDTO(result); // convertendo em GameDTO
		return dto;
	}
	
	@Transactional(readOnly = true)//buscou no banco de dados a lista de games
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
}
