package org.serratec.backend.java2.exercicio03.repository;

import org.serratec.backend.java2.exercicio03.entidade.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

}
