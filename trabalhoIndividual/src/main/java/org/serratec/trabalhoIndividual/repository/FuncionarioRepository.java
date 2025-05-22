package org.serratec.trabalhoIndividual.repository;

import org.serratec.trabalhoIndividual.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
