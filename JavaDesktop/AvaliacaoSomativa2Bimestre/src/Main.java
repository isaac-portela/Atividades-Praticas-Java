
import java.util.Random;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        FiguraGeometrica[] vetor = new FiguraGeometrica[6];
        Random gerador = new Random();
        String maior = "";
        boolean testa = false;
        while (!testa) {
            try {
                vetor[0] = new Circulo(gerador.nextDouble() * 2 + 1);
                vetor[1] = new Circulo(gerador.nextDouble() * 4 + 1);
                vetor[2] = new Circulo(gerador.nextDouble() * 7 + 1);
                vetor[3] = new Retangulo(gerador.nextDouble() * 14 + 1, gerador.nextDouble() * 8 + 1);
                vetor[4] = new Retangulo(gerador.nextDouble() * 18 + 1, gerador.nextDouble() * 12 + 1);
                vetor[5] = new Retangulo(gerador.nextDouble() * 20 + 1, gerador.nextDouble() * 15 + 1);

                maior = vetor[0].Max(vetor);
                JOptionPane.showMessageDialog(null, maior, "Saida", 1);
                testa = true;
            } catch (AreaMaxima e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", 0);
            }
        }

    }
}
