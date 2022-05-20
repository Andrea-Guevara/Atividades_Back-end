package org.serratec.java.backend.exercicio01.service;

import java.util.ArrayList;
import java.util.List;
import org.serratec.java.backend.exercicio01.Entidade.DocePadaria;
import org.springframework.stereotype.Service;

@Service
public class PadariaService {
	List<DocePadaria> lista = new ArrayList<>();

	public void adicionar(DocePadaria padaria) {
		lista.add(padaria);
	}

	public List<DocePadaria> listaDeObjetos() {
		return this.lista;
	}

	public DocePadaria listaDeObjetosPeloId(int idPosicao) {
		DocePadaria idPadaria = new DocePadaria();
		for (DocePadaria padaria : lista) {
			if (padaria.getId().equals(idPosicao)) {
				idPadaria = padaria;
			}
		}
		return idPadaria;

	}

	public void atualizar(Integer idPosicao, DocePadaria padaria) {
		DocePadaria padariaPosicao = new DocePadaria();
		padariaPosicao = lista.get(idPosicao);
		padariaPosicao.setId(padaria.getId());
		padariaPosicao.setTipoDeDoce(padaria.getTipoDeDoce());
		padariaPosicao.setPreco(padaria.getPreco());
		padariaPosicao.setDescricao(padaria.getDescricao());
	}

	public void deletar(int idPosicao) {
		lista.remove(idPosicao);

	}
}
