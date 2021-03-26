package avaliacao3bimestre;

public class Eleitores {
    private String nome;
    private String dataNascimento;
    private  String titulo;
    private int zona ;
    private int  secao ;

    public Eleitores() {
    }

    public Eleitores(String nome, String dataNascimento, String titulo, int zona, int secao) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.titulo = titulo;
        this.zona = zona;
        this.secao = secao;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    public int getSecao() {
        return secao;
    }

    public void setSecao(int secao) {
        this.secao = secao;
    }
}
