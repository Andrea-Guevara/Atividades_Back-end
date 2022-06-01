package org.serratec.backend.java2.projetoBorracharia.repository;

import java.util.List;

import org.serratec.backend.java2.projetoBorracharia.dto.RelatorioDTO;
import org.serratec.backend.java2.projetoBorracharia.entidade.Borracharia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface BorrachariaRepository extends JpaRepository<Borracharia, Integer>{
	@Query(value="select\r\n"
			+ "c1.CLIENTE_TX_NOME as cliente,\r\n"
			+ "c.CARRO_TX_MODELO as modelo,\r\n"
			+ "b.BORRACHARIA_TX_TIPO_SERVICO as descricaoDoServico,\r\n"
			+ "b.BORRACHARIA_TX_VALOR as valor\r\n"
			+ "from BORRACHARIA b join CARRO c on(b.ID_CARRO = c.CARRO_CD_ID  )\r\n"
			+ "join CLIENTE c1 on(c1.CLIENTE_CD_ID =c.CLIENTE_ID)\r\n"
			+ "order by b.BORRACHARIA_CD_ID \r\n"
			+ "desc\r\n"
			+ "limit 5;", nativeQuery=true)
	List<RelatorioDTO> relatorio();
}
