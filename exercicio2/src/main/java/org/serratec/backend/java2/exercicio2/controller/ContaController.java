package org.serratec.backend.java2.exercicio2.controller;

import java.util.List;

import org.serratec.backend.java2.exercicio2.entidade.Conta;
import org.serratec.backend.java2.exercicio2.service.ContaService;
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
@RequestMapping("/conta")
public class ContaController {

	@Autowired
	ContaService contaService;

	@GetMapping("/lista")
	public ResponseEntity<List<Conta>> listaTodasAsContas() {
		return ResponseEntity.ok(contaService.listaTodasAsContas());
	}

	@GetMapping("/buscar/{numeroConta}")
	public ResponseEntity<Conta> buscarPorNumero(@PathVariable Integer numeroConta) {
		return ResponseEntity.ok(contaService.buscarPorNumero(numeroConta));
	}

	@PostMapping("/adicionar")
	public ResponseEntity<Void> adicionar(@RequestBody Conta conta) {
		contaService.adicionar(conta);
		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	@PutMapping("/atualizar/{numeroConta}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer numeroConta, @RequestBody Conta conta) {
		contaService.atualizar(numeroConta, conta);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{numeroConta}")
	public ResponseEntity<Void> delete(@PathVariable Integer numeroConta) {
		contaService.delete(numeroConta);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
