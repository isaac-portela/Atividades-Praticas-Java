package avaliacao3bimestre;

import java.util.ArrayList;

public abstract class Candidato {
    protected String nome;
    protected String email;
    protected  String dataNascimento;
    protected  String codigo;

    public Candidato() {
    }

    public Candidato(String nome, String email, String dataNascimento, String codigo) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
