package api.ciss.apiCISS.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity(name = "funcionario")
@Table(name = "funcionario")
public class Funcionario implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    @Length(min = 2, max = 30, message = "O Nome precisa ter entre 2 e 30 caracteres")

    String nome;
    @Column(name = "sobrenome")
    @Length(min = 2, max = 50, message = "O Sobrenome precisa ter entre 2 e 50 caracteres")
    String sobrenome;
    @Column(name = "email")
    @Email
    String email;

    @Column(name = "nis")
    Integer nis;

    public Funcionario() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Funcionario(Integer id, String nome, String sobrenome, String email, Integer nis) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.nis = nis;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNis() {
        return nis;
    }

    public void setNis(Integer nis) {
        this.nis = nis;
    }
}
