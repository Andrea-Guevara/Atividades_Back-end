package org.serratec.backend.java2.exercicio2.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.java2.exercicio2.entidade.Conta;
import org.serratec.backend.java2.exercicio2.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

	@Autowired
	ContaRepository contaRepository;

	public List<Conta> listaTodasAsContas() {
		return contaRepository.findAll();
	}

	public void adicionar(Conta conta) {
		contaRepository.save(conta);
	}

	public Conta buscarPorNumero(Integer idConta) {
		Optional<Conta> conta = contaRepository.findById(idConta);
		Conta contaNoBanco = new Conta();
		if (conta.isPresent()) {
			contaNoBanco = conta.get();
		}
		return contaNoBanco;
	}

	public void atualizar(Integer numeroConta, Conta conta) {
		Conta contaNoBanco = buscarPorNumero(numeroConta);
		if (conta.getTitular() != null) {
			contaNoBanco.setTitular(conta.getTitular());
		}
		if (conta.getNumeroDaConta() != null) {
			contaNoBanco.setNumeroDaConta(conta.getNumeroDaConta());
		}
		if (conta.getSaldo() != null) {
			contaNoBanco.setSaldo(conta.getSaldo());
		}
		contaRepository.save(contaNoBanco);
	}

	public void delete(Integer conta) {
		contaRepository.deleteById(conta);

	}
}