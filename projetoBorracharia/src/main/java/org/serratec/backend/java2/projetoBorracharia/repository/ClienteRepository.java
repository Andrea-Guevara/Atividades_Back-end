package org.serratec.backend.java2.projetoBorracharia.repository;

import org.serratec.backend.java2.projetoBorracharia.entidade.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
