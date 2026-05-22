package org.serratec.ong_animais.repository;

import org.serratec.ong_animais.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
    boolean existsByEmail(String email);
}
