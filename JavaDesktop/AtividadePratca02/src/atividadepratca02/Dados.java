package atividadepratca02;

public class Dados {
    private  String nome;
    private  String endereco;
    private  String telefone1;
    private  String cpf;
    private  String tiposanguineo;
    private  String fatorrh;
    private  String curso;
    private  String contatoEmergencia;
    private  String telefone2;

    public Dados() {
    }

    public Dados(String nome, String endereco, String telefone1, String cpf, String tiposanguineo, String fatorrh, String curso, String contatoEmergencia, String telefone2) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone1 = telefone1;
        this.cpf = cpf;
        this.tiposanguineo = tiposanguineo;
        this.fatorrh = fatorrh;
        this.curso = curso;
        this.contatoEmergencia = contatoEmergencia;
        this.telefone2 = telefone2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTiposanguineo() {
        return tiposanguineo;
    }

    public void setTiposanguineo(String tiposanguineo) {
        this.tiposanguineo = tiposanguineo;
    }

    public String getFatorrh() {
        return fatorrh;
    }

    public void setFatorrh(String fatorrh) {
        this.fatorrh = fatorrh;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getContatoEmergencia() {
        return contatoEmergencia;
    }

    public void setContatoEmergencia(String contatoEmergencia) {
        this.contatoEmergencia = contatoEmergencia;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }
}
