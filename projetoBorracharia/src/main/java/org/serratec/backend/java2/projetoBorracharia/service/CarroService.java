package org.serratec.backend.java2.projetoBorracharia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.java2.projetoBorracharia.dto.CarroDTO;
import org.serratec.backend.java2.projetoBorracharia.entidade.Carro;
import org.serratec.backend.java2.projetoBorracharia.exception.CarroException;
import org.serratec.backend.java2.projetoBorracharia.repository.CarroRepository;
import org.serratec.backend.java2.projetoBorracharia.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {

	@Autowired
	CarroRepository carroRepository;
	@Autowired
	ClienteRepository clienteRepository;

// transformar model em DTO
	public CarroDTO modelParaDTO(Carro carro, CarroDTO carroDTO) {
		carroDTO.setIdCarro(carro.getIdCarro());
		carroDTO.setModelo(carro.getModelo());
		carroDTO.setMarca(carro.getMarca());
		carroDTO.setAno(carro.getAno());

		return carroDTO;
	}

// transformar DTO em model
	public Carro DTOparaModel(Carro carro, CarroDTO carroDTO) {
		carro.setModelo(carroDTO.getModelo());
		carro.setMarca(carroDTO.getMarca());
		carro.setAno(carroDTO.getAno());
		if (carroDTO.getIdCliente() != null) {
			carro.setCliente(clienteRepository.findById(carroDTO.getIdCliente()).get());
		}
		return carro;
	}

// criar, adicionar um objeto.
	public String adicionar(CarroDTO carroDTO) {
		Carro carro = new Carro();
		DTOparaModel(carro, carroDTO);
		carroRepository.save(carro);
		return "O carro criado foi com o id: " + carro.getIdCarro();
	}

// buscar o objeto pelo id cadastrado
	public CarroDTO buscarPorId(Integer idCarro) throws CarroException {
		Optional<Carro> carro = carroRepository.findById(idCarro);
		Carro carroNoRegistro = new Carro();
		CarroDTO carroDTO = new CarroDTO();
		if (carro.isPresent()) {
			carroNoRegistro = carro.get();
			modelParaDTO(carroNoRegistro, carroDTO);
			return carroDTO;
		}
		throw new CarroException("O carro com o id informado nao foi encontrado");
	}

// atualizar
	public String atualizar(Integer idCarro, CarroDTO carroDTO) throws CarroException {
		Optional<Carro> carro = carroRepository.findById(idCarro);
		Carro carroRegistro = new Carro();
		if (carro.isPresent()) {
			carroRegistro = carro.get();
			if (carroDTO.getModelo() != null) {
				carroRegistro.setModelo(carroDTO.getModelo());
			}
			if (carroDTO.getMarca() != null) {
				carroRegistro.setModelo(carroDTO.getModelo());

			}
			if (carroDTO.getAno() != 0) {
				carroRegistro.setAno(carroDTO.getAno());
			}

			carroRepository.save(carroRegistro);
			return "O carro com o id " + carroRegistro.getIdCarro() + "foi atualizado com sucesso!";
		}
		throw new CarroException("O registro do carro nao foi atualizado!");
	}

// lista de todos os objetos criados
	public List<CarroDTO> listarTodos() {
		List<Carro> listaCarroModel = carroRepository.findAll();
		List<CarroDTO> listaCarroDTO = new ArrayList<>();

		for (Carro carro : listaCarroModel) {
			CarroDTO carroDTO = new CarroDTO();
			modelParaDTO(carro, carroDTO);
			listaCarroDTO.add(carroDTO);
		}
		return listaCarroDTO;
	}

// salvar uma lista de objetos
	public void salvarListaDeCarro(List<CarroDTO> listaCarroDTO) {
		for (CarroDTO carroDTO : listaCarroDTO) {
			Carro carro = new Carro();
			DTOparaModel(carro, carroDTO);
			carroRepository.save(carro);
		}

	}

// deleta um objeto pelo id
	public void deletar(Integer idCarro) {
		carroRepository.deleteById(idCarro);
	}

}
