package org.serratec.backend.java2.projetoBorracharia.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.serratec.backend.java2.projetoBorracharia.dto.BorrachariaDTO;
import org.serratec.backend.java2.projetoBorracharia.exception.BorrachariaException;
import org.serratec.backend.java2.projetoBorracharia.exception.EmailException;
import org.serratec.backend.java2.projetoBorracharia.service.BorrachariaService;
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
@RequestMapping("/borracharia")
public class BorrachariaController {

	@Autowired
	BorrachariaService borrachariaService;

	@PostMapping("/adicionar")
	public ResponseEntity<String> adicionar(@RequestBody BorrachariaDTO borrachariaDTO)
			throws BorrachariaException, MessagingException, EmailException {
		return ResponseEntity.ok(borrachariaService.adicionar(borrachariaDTO));
	}

	@PostMapping("/salvar-lista")
	public ResponseEntity<Void> salvarLista(@RequestBody List<BorrachariaDTO> listaBorrachariaDTO) {
		borrachariaService.salvarListaBorracharia(listaBorrachariaDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("buscar/{idBorracharia}")
	public ResponseEntity<BorrachariaDTO> buscarPorId(@PathVariable Integer idBorracharia) throws BorrachariaException {
		return ResponseEntity.ok(borrachariaService.buscarPorId(idBorracharia));
	}

	@GetMapping("/lista")
	public ResponseEntity<List<BorrachariaDTO>> listaTodos() {
		return ResponseEntity.ok(borrachariaService.listarTodos());
	}

	@PutMapping("/atualizar/{idBorracharia}")
	public ResponseEntity<String> atualizar(@PathVariable Integer idBorracharia,
			@RequestBody BorrachariaDTO borrachariaDTO) throws BorrachariaException {
		return ResponseEntity.ok(borrachariaService.atualizar(idBorracharia, borrachariaDTO));

	}

	@DeleteMapping("/delete/{idBorracharia}")
	public ResponseEntity<Void> delete(@PathVariable Integer idBorracharia) {
		borrachariaService.delete(idBorracharia);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}
