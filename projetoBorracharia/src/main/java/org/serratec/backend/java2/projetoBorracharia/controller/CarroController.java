package org.serratec.backend.java2.projetoBorracharia.controller;

import java.util.List;

import org.serratec.backend.java2.projetoBorracharia.dto.CarroDTO;
import org.serratec.backend.java2.projetoBorracharia.exception.CarroException;
import org.serratec.backend.java2.projetoBorracharia.service.CarroService;
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

@RestController
@RequestMapping("/carro")
public class CarroController {

	@Autowired
	CarroService carroService;

	@PostMapping("/adicionar")
	public ResponseEntity<String> adicionar(@RequestBody CarroDTO carroDTO) {
		return ResponseEntity.ok(carroService.adicionar(carroDTO));
	}

	@GetMapping("/buscar/{idCarro}")
	public ResponseEntity<CarroDTO> bucarPorId(@PathVariable Integer idCarro) throws CarroException {
		return ResponseEntity.ok(carroService.buscarPorId(idCarro));
	}

	@GetMapping("/lista")
	public ResponseEntity<List<CarroDTO>> listarTodos() {
		return ResponseEntity.ok(carroService.listarTodos());
	}

	@PutMapping("/atualizar/{idCarro}")
	public ResponseEntity<String> atualizar(@PathVariable Integer idCarro, @RequestBody CarroDTO carroDTO)
			throws CarroException {
		return ResponseEntity.ok(carroService.atualizar(idCarro, carroDTO));
	}

	@PostMapping("/salvar-lista")
	public ResponseEntity<Void> salvarLista(@RequestBody List<CarroDTO> listaCarroDTO) {
		carroService.salvarListaDeCarro(listaCarroDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping("/deletar/{idCarro}")
	public ResponseEntity<Void> deletar(@PathVariable Integer idCarro) {
		carroService.deletar(idCarro);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}
