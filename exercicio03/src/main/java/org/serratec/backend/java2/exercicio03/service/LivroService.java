package org.serratec.backend.java2.exercicio03.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.java2.exercicio03.dto.LivroDTO;
import org.serratec.backend.java2.exercicio03.entidade.Livro;
import org.serratec.backend.java2.exercicio03.exception.LivroException;
import org.serratec.backend.java2.exercicio03.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
	@Autowired
	LivroRepository livroRepository;

	public LivroDTO modelParaDTO(Livro livro, LivroDTO livroDTO) {
		livroDTO.setIdLivro(livro.getIdLivro());
		livroDTO.setTitulo(livro.getTitulo());
		livroDTO.setTipo(livro.getTipo());
		livroDTO.setAutor(livro.getAutor());
		livroDTO.setDataDePublicacao(livro.getDataDePublicacao());

		return livroDTO;
	}

	public Livro DTOparaModel(Livro livro, LivroDTO livroDTO) {
		livro.setTitulo(livroDTO.getTitulo());
		livro.setTipo(livroDTO.getTipo());
		livro.setAutor(livroDTO.getAutor());
		livro.setDataDePublicacao(livroDTO.getDataDePublicacao());

		return livro;

	}

	public String adicionar(LivroDTO livroDTO) {
		Livro livro = new Livro();
		DTOparaModel(livro, livroDTO);
		livroRepository.save(livro);
		return "O livro criado foi com o id: " + livro.getIdLivro();
	}

	public LivroDTO buscarPorId(Integer idLivro) throws LivroException {
		Optional<Livro> livro = livroRepository.findById(idLivro);
		Livro livroNaBiblioteca = new Livro();
		LivroDTO livroDTO = new LivroDTO();
		if (livro.isPresent()) {
			livroNaBiblioteca = livro.get();
			modelParaDTO(livroNaBiblioteca, livroDTO);

			return livroDTO;
		}
		throw new LivroException("O livro com o id informado nao foi encontrado!");
	}

	public String atualizar(Integer idLivro, LivroDTO livroDTO) throws LivroException {
		Optional<Livro> livro = livroRepository.findById(idLivro);
		Livro livroNaBiblioteca = new Livro();
		if (livro.isPresent()) {
			livroNaBiblioteca = livro.get();
			if (livroDTO.getTitulo() != null) {
				livroNaBiblioteca.setTitulo(livroDTO.getTitulo());
			}
			if (livroDTO.getTipo() != null) {
				livroNaBiblioteca.setTipo(livroDTO.getTipo());
			}
			if (livroDTO.getAutor() != null) {
				livroNaBiblioteca.setAutor(livroDTO.getAutor());
			}
			if (livroDTO.getDataDePublicacao() != null) {
				livroNaBiblioteca.setDataDePublicacao(livroDTO.getDataDePublicacao());

			}
			livroRepository.save(livroNaBiblioteca);
			return "O cartao com o id " + livroNaBiblioteca.getIdLivro() + "foi atualizado com sucesso";
		}
		throw new LivroException("O livro nao foi atualizado");
	}

	public void deletar(Integer idLivro) {
		livroRepository.deleteById(idLivro);

	}

	public List<LivroDTO> buscarTodos() {
		List<Livro> listaLivroModel = livroRepository.findAll();
		List<LivroDTO> listaLivroDTO = new ArrayList<>();

		for (Livro livro : listaLivroModel) {
			LivroDTO livroDTO = new LivroDTO();
			modelParaDTO(livro, livroDTO);
			listaLivroDTO.add(livroDTO);

		}
		return listaLivroDTO;
	}

	public void salvarListaDeLivros(List<LivroDTO> listaLivroDTO) {
		for (LivroDTO livroDTO : listaLivroDTO) {
			Livro livro = new Livro();
			DTOparaModel(livro, livroDTO);
		}
	}

}