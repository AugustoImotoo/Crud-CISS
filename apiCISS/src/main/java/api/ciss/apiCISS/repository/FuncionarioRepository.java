package api.ciss.apiCISS.repository;

import api.ciss.apiCISS.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Integer> {
    Funcionario findFuncionarioById (Integer id);
}
