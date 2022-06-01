package org.serratec.backend.java2.projetoBorracharia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.serratec.backend.java2.projetoBorracharia.dto.BorrachariaDTO;
import org.serratec.backend.java2.projetoBorracharia.dto.RelatorioDTO;
import org.serratec.backend.java2.projetoBorracharia.entidade.Borracharia;
import org.serratec.backend.java2.projetoBorracharia.exception.BorrachariaException;
import org.serratec.backend.java2.projetoBorracharia.exception.EmailException;
import org.serratec.backend.java2.projetoBorracharia.repository.BorrachariaRepository;
import org.serratec.backend.java2.projetoBorracharia.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrachariaService {
	@Autowired
	BorrachariaRepository borrachariaRepository;

	@Autowired
	CarroRepository carroRepository;

	@Autowired
	EmailService emailService;

// transformar model em DTO
	public BorrachariaDTO modelParaDTO(Borracharia borracharia, BorrachariaDTO borrachariaDTO) {
		borrachariaDTO.setIdBorracharia(borracharia.getIdBorracharia());
		borrachariaDTO.setValor(borracharia.getValor());
		borrachariaDTO.setData(borracharia.getData());
		borrachariaDTO.setTipoDeServico(borracharia.getTipoDeServico());

		return borrachariaDTO;
	}

// transformar DTO em model
	public Borracharia DTOparaModel(Borracharia borracharia, BorrachariaDTO borrachariaDTO) {
		borracharia.setValor(borrachariaDTO.getValor());
		borracharia.setData(borrachariaDTO.getData());
		borracharia.setTipoDeServico(borrachariaDTO.getTipoDeServico());
          if (borrachariaDTO.getIdCarro() != null)
			borracharia.setCarro(carroRepository.findById(borrachariaDTO.getIdCarro()).get());

		return borracharia;
	}

// criar, adicionar um objeto.
	public String adicionar(BorrachariaDTO borrachariaDTO)
			throws BorrachariaException, MessagingException, EmailException {

		Borracharia borracharia = new Borracharia();
		DTOparaModel(borracharia, borrachariaDTO);
		borrachariaRepository.save(borracharia);

		emailService.emailTeste(borrachariaDTO);
		return "O servico da borracharia foi com o id: " + borracharia.getIdBorracharia();
	}

// buscar o objeto pelo id cadastrado
	public BorrachariaDTO buscarPorId(Integer idBorracharia) throws BorrachariaException {
		Optional<Borracharia> borracharia = borrachariaRepository.findById(idBorracharia);
		Borracharia borrachariaNoRegistro = new Borracharia();
		BorrachariaDTO borrachariaDTO = new BorrachariaDTO();

		if (borracharia.isPresent()) {
			borrachariaNoRegistro = borracharia.get();
			modelParaDTO(borrachariaNoRegistro, borrachariaDTO);
			return borrachariaDTO;
		}
		throw new BorrachariaException("Id informado nao encontrado");

	}

// atualizar
	public String atualizar(Integer idBorracharia, BorrachariaDTO borrachariaDTO) throws BorrachariaException {
		Optional<Borracharia> borracharia = borrachariaRepository.findById(idBorracharia);
		Borracharia borrachariaNoRegistro = new Borracharia();

		if (borracharia.isPresent()) {
			borrachariaNoRegistro = borracharia.get();
			if (borrachariaDTO.getValor() != null) {
				borrachariaNoRegistro.setValor(borrachariaDTO.getValor());
			}
			if (borrachariaDTO.getData() != null) {
				borrachariaNoRegistro.setData(borrachariaDTO.getData());
			}
			if (borrachariaDTO.getTipoDeServico() != null) {
				borrachariaNoRegistro.setTipoDeServico(borrachariaDTO.getTipoDeServico());
			}
			borrachariaRepository.save(borrachariaNoRegistro);
			return "O servico da borracharia com o id " + borrachariaNoRegistro.getIdBorracharia()
					+ "foi atualizado com sucesso";
		}
		throw new BorrachariaException("O registro da borracharia nao foi atualizado!");

	}

// lista de todos os objetos criados
	public List<BorrachariaDTO> listarTodos() {
		List<Borracharia> listaBorrachariaModel = borrachariaRepository.findAll();
		List<BorrachariaDTO> listaBorrachariaDTO = new ArrayList<>();

		for (Borracharia borracharia : listaBorrachariaModel) {
			BorrachariaDTO borrachariaDTO = new BorrachariaDTO();
			modelParaDTO(borracharia, borrachariaDTO);
			listaBorrachariaDTO.add(borrachariaDTO);
		}
		return listaBorrachariaDTO;
	}

// salvar uma lista de objetos
	public void salvarListaBorracharia(List<BorrachariaDTO> listaBorrachariaDTO) {
		for (BorrachariaDTO borrachariaDTO : listaBorrachariaDTO) {
			Borracharia borracharia = new Borracharia();
			DTOparaModel(borracharia, borrachariaDTO);

			borrachariaRepository.save(borracharia);

		}
	}

// deletar um objeto pelo id
	public void delete(Integer idBorracharia) {
		borrachariaRepository.deleteById(idBorracharia);
	}

//relatorio
	public List<RelatorioDTO> relatorio() {
		return borrachariaRepository.relatorio();
	}

}
