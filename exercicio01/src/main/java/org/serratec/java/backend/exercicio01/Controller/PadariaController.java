package org.serratec.java.backend.exercicio01.Controller;

import java.util.List;
import org.serratec.java.backend.exercicio01.Entidade.DocePadaria;
import org.serratec.java.backend.exercicio01.service.PadariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/padaria")
public class PadariaController {

	@Autowired
	PadariaService padariaService;
	
    // lista de objetos dentro do array = GET http://localhost:8080/padaria/lista
	@GetMapping("/lista")
	public List<DocePadaria> getPadaria() {
		return padariaService.listaDeObjetos();
	}
    // pesquisa do objeto dentro da lista pelo id = GET http://localhost:8080/padaria/pesquisa/1
	@GetMapping("/pesquisa/{idPosicao}")
	public DocePadaria listaDeObjetosPeloId(@PathVariable int idPosicao) {
		return padariaService.listaDeObjetosPeloId(idPosicao);
	}
    // adiciona um objeto dentro do array list = POST http://localhost:8080/padaria/adicionar
	@PostMapping("/adicionar")
	public void adicionar(@RequestBody DocePadaria padaria) {
		padariaService.adicionar(padaria);
	}
    // atualiza informações no array list = PUT http://localhost:8080/padaria/atualizar/0
	@PutMapping("/atualizar/{idPosicao}")
	public void atualizar(@PathVariable Integer idPosicao, @RequestBody DocePadaria padaria) {
		padariaService.atualizar(idPosicao, padaria);
	}
    // deleta um objeto pelo id no array list = DELETE http://localhost:8080/padaria/delete/0
	@DeleteMapping("/delete/{idPosicao}")
	public void deletar(@PathVariable int idPosicao) {
		padariaService.deletar(idPosicao);
	}

}


