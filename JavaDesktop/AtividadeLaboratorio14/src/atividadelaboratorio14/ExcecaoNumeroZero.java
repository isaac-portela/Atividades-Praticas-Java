package atividadelaboratorio14;

public class ExcecaoNumeroZero extends Exception {
    public ExcecaoNumeroZero() {
    }

    public  ExcecaoNumeroZero(int numero){
        super("Nao é permitido o numero " + numero+" na matriz\nRecriando a matriz aleatoriamente");

    }
}
