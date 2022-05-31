package org.serratec.backend.java2.projetoBorracharia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.java2.projetoBorracharia.dto.ClienteDTO;
import org.serratec.backend.java2.projetoBorracharia.entidade.Cliente;
import org.serratec.backend.java2.projetoBorracharia.exception.ClienteException;
import org.serratec.backend.java2.projetoBorracharia.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

// transformar model em DTO
	public ClienteDTO modelParaDTO(Cliente cliente, ClienteDTO clienteDTO) {
		clienteDTO.setIdCliente(cliente.getIdCliente());
		clienteDTO.setNome(cliente.getNome());
		clienteDTO.setCpf(cliente.getCpf());
		clienteDTO.setNumeroDeTelefone(cliente.getNumeroDeTelefone());
		clienteDTO.setGmail(cliente.getGmail());

		return clienteDTO;
	}

// transformar DTO para model
	public Cliente DTOparaModel(Cliente cliente, ClienteDTO clienteDTO) {
		cliente.setNome(clienteDTO.getNome());
		cliente.setCpf(clienteDTO.getNome());
		cliente.setNumeroDeTelefone(clienteDTO.getNumeroDeTelefone());
		cliente.setGmail(clienteDTO.getGmail());

		return cliente;
	}

// criar, adicionar um objeto.
	public String adicionar(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		DTOparaModel(cliente, clienteDTO);
		clienteRepository.save(cliente);
		return "O cliente criado foi com o id: " + cliente.getIdCliente();
	}

// buscar o objeto pelo id cadastrado
	public ClienteDTO buscarPorId(Integer idCliente) throws ClienteException {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		Cliente clienteNoRegistro = new Cliente();
		ClienteDTO clienteDTO = new ClienteDTO();
		if (cliente.isPresent()) {
			clienteNoRegistro = cliente.get();
			modelParaDTO(clienteNoRegistro, clienteDTO);
			return clienteDTO;
		}
		throw new ClienteException("O cliente com id informado nao foi encontrado");
	}

// atualizar
	public String atualizar(Integer idCliente, ClienteDTO clienteDTO) throws ClienteException {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		Cliente clienteNoRegistro = new Cliente();
		if (cliente.isPresent()) {
			clienteNoRegistro = cliente.get();
			if (clienteDTO.getNome() != null) {
				clienteNoRegistro.setNome(clienteDTO.getNome());
			}
			if (clienteDTO.getCpf() != null) {
				clienteNoRegistro.setCpf(clienteDTO.getCpf());
			}
			if (clienteDTO.getNumeroDeTelefone() != null) {
				clienteNoRegistro.setNumeroDeTelefone(clienteDTO.getNumeroDeTelefone());
			}
			if (clienteDTO.getGmail() != null) {
				clienteNoRegistro.setGmail(clienteDTO.getGmail());
			}
			clienteRepository.save(clienteNoRegistro);
			return "O cliente com o id: " + clienteNoRegistro.getIdCliente() + "foi atualizado com sucesso!";
		}
		throw new ClienteException("O cliente nao foi atualizado!");
	}

//lista de todos os objetos criados
	public List<ClienteDTO> listarTodos() {
		List<Cliente> listaClienteModel = clienteRepository.findAll();
		List<ClienteDTO> listaClienteDTO = new ArrayList<>();

		for (Cliente cliente : listaClienteModel) {
			ClienteDTO clienteDTO = new ClienteDTO();
			modelParaDTO(cliente, clienteDTO);

		}
		return listaClienteDTO;
	}

// salvar uma lista de objetos
	public void salvarListaDeClientes(List<ClienteDTO> listaClienteDTO) {
		for (ClienteDTO clienteDTO : listaClienteDTO) {
			Cliente cliente = new Cliente();
			DTOparaModel(cliente, clienteDTO);
			clienteRepository.save(cliente);
		}
	}

// deletar um objeto pelo id
	public void delete(Integer idCliente) {
		clienteRepository.deleteById(idCliente);
	}
}
