public class Dados {
 private String nome;
 private String tipoLogradouro;
 private String logradouro;
 private String numeroLogradouro;
 private String telefoneResi;
 private String telefoneComer;
 private String telefoneCell;
 private String cpf;
 private String rg;
 private String profisao;

    public Dados() {
    }

    public Dados(String nome, String tipoLogradouro, String logradouro, String numeroLogradouro, String telefoneResi, String telefoneComer, String telefoneCell, String cpf, String rg, String profisao) {
        this.nome = nome;
        this.tipoLogradouro = tipoLogradouro;
        this.logradouro = logradouro;
        this.numeroLogradouro = numeroLogradouro;
        this.telefoneResi = telefoneResi;
        this.telefoneComer = telefoneComer;
        this.telefoneCell = telefoneCell;
        this.cpf = cpf;
        this.rg = rg;
        this.profisao = profisao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumeroLogradouro() {
        return numeroLogradouro;
    }

    public void setNumeroLogradouro(String numeroLogradouro) {
        this.numeroLogradouro = numeroLogradouro;
    }

    public String getTelefoneResi() {
        return telefoneResi;
    }

    public void setTelefoneResi(String telefoneResi) {
        this.telefoneResi = telefoneResi;
    }

    public String getTelefoneComer() {
        return telefoneComer;
    }

    public void setTelefoneComer(String telefoneComer) {
        this.telefoneComer = telefoneComer;
    }

    public String getTelefoneCell() {
        return telefoneCell;
    }

    public void setTelefoneCell(String telefoneCell) {
        this.telefoneCell = telefoneCell;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getProfisao() {
        return profisao;
    }

    public void setProfisao(String profisao) {
        this.profisao = profisao;
    }
}
