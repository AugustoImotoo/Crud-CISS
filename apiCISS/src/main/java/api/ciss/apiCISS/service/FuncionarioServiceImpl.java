package api.ciss.apiCISS.service;

import api.ciss.apiCISS.model.Funcionario;
import api.ciss.apiCISS.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServiceImpl {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> buscarTodosFuncionarios() {
        List<Funcionario> listFuncionario = funcionarioRepository.findAll();
        return listFuncionario;
    }

    public Optional<Object> deleteFuncionario (@PathVariable Integer id) {
        return funcionarioRepository.findById(id)
                .map(recordFound -> { funcionarioRepository.deleteById(id);
                return ResponseEntity.noContent().<Void>build();
        });
    }


    public Optional<Funcionario> updateFuncionario(@NotNull @Positive Integer id, @Valid @NotNull Funcionario funcionario) {
        return funcionarioRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setNome(funcionario.getNome());
                    recordFound.setSobrenome(funcionario.getSobrenome());
                    recordFound.setEmail(funcionario.getEmail());
                    recordFound.setNis(funcionario.getNis());
                    return funcionarioRepository.save(recordFound);
                });
    }


    public ResponseEntity<Funcionario> createFuncionario (@RequestBody Funcionario funcionario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioRepository.save(funcionario));
    }
}
