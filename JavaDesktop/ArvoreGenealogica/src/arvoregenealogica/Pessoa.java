package arvoregenealogica;

public class Pessoa {
    private String nome;
    private Pessoa pai;
    private Pessoa mae;

    public Pessoa() {
    }

    public Pessoa(String nome) {
        this.nome = nome;
        this.pai = null;
        this.mae = null;
    }

    public Pessoa(String nome, Pessoa pai, Pessoa mae) {
        this.nome = nome;
        this.pai = pai;
        this.mae = mae;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa getPai() {
        return pai;
    }

    public void setPai(Pessoa pai) {
        this.pai = pai;
    }

    public Pessoa getMae() {
        return mae;
    }

    public void setMae(Pessoa mae) {
        this.mae = mae;
    }

    public boolean ehSemanticamenteIgual(Pessoa pessoa) {
        boolean verifica;
        if (this.nome.equals(pessoa.getNome()) && this.mae == pessoa.getMae())
            verifica = true;
        else
            verifica = false;

        return verifica;
    }

    public boolean ehIrma(Pessoa pessoa) {
        boolean verifica;
        if (this.pai.equals(pessoa.getPai()) || this.mae.equals(pessoa.getMae()))
            verifica = true;
        else
            verifica = false;

        return verifica;
    }

}
