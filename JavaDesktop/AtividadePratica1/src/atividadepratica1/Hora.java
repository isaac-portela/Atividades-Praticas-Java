package atividadepratica1;

public class Hora {
    private int hora;
    private int minuto;
    private int segundo;

    public Hora() {
    }

    public Hora(int hora, int minuto, int segundo) {
        this.setHora(hora);
        this.setMinuto(minuto);
        this.setSegundo(segundo);

    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        if (hora >= 0 && hora <= 24)
            this.hora = hora;

    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        if (minuto >= 0 && minuto <60)
            this.minuto = minuto;

    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        if (segundo >= 0 && segundo <60)
            this.segundo = segundo;

    }
}
