package atividadepratica1;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data() {
    }

    public Data(int dia, int mes, int ano) {
        this.setMes(mes);
        this.setAno(ano);
        this.setDia(dia);
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        if (dia <= 0 || dia > 31) {
            this.dia = 200;
        } else if (this.getMes() == 1 || this.getMes() == 3 || this.getMes() == 5 || this.getMes() == 7 ||
                this.getMes() == 8 || this.getMes() == 10 || this.getMes() == 12) {
            if (dia >= 1 && dia <= 31)
                this.dia = dia;

        } else if (this.getMes() == 4 || this.getMes() == 6 || this.getMes() == 9 || this.getMes() == 11) {
            if (dia >= 1 && dia <= 30)
                this.dia = dia;

        } else if (this.getMes() == 2) {
            if (this.getAno() % 400 == 0) {
                if (dia >= 1 && dia <= 29)
                    this.dia = dia;

            } else if ((this.getAno() % 4 == 0) && (this.getAno() % 100 != 0)) {
                if (dia >= 1 && dia <= 29)
                    this.dia = dia;
            } else {
                if (dia >= 1 && dia <= 28)
                    this.dia = dia;
            }
        }
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        if (mes >= 1 && mes <= 12) {
            this.mes = mes;
        }
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if (ano >= 1)
            this.ano = ano;
        else
            this.ano=200;
    }
}
