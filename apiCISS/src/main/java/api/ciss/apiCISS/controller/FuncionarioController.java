package api.ciss.apiCISS.controller;

import api.ciss.apiCISS.model.Funcionario;
import api.ciss.apiCISS.repository.FuncionarioRepository;
import api.ciss.apiCISS.service.FuncionarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(value = "/api/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioServiceImpl funcionarioService;

    @GetMapping
    public List<Funcionario> buscarUsuario(){
       return funcionarioService.buscarTodosFuncionarios();
    }

    @PostMapping
    public ResponseEntity<Funcionario> salvarFuncionario (@RequestBody Funcionario funcionario) {
        return funcionarioService.createFuncionario(funcionario);
    }

    @DeleteMapping("/{id}")
    public Optional<Object> deleteFuncionario (@PathVariable Integer id) {
        return funcionarioService.deleteFuncionario(id);
    }


    @PutMapping("/{id}")
    public Optional<Funcionario> updateFuncionario (@PathVariable @NotNull @Positive Integer id,
                                        @RequestBody @Valid @NotNull Funcionario funcionario) {
        return funcionarioService.updateFuncionario(id, funcionario);
    }

}
