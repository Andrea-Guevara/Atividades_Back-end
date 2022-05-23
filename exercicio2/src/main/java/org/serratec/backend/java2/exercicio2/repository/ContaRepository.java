package org.serratec.backend.java2.exercicio2.repository;

import org.serratec.backend.java2.exercicio2.entidade.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta,Integer>{

}
