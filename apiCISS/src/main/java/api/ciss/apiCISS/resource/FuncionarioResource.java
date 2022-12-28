package api.ciss.apiCISS.resource;

import javax.persistence.criteria.CriteriaBuilder;

public class FuncionarioResource {

    private Integer id;
    private String nome;
    private String sobrenome;
    private String email;
    private String nis;
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

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FuncionarioResource(Integer id, String nome, String sobrenome, String email, String nis) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.nis = nis;
    }

}
