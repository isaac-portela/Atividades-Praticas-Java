import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        CadastroInterface interfaceCadastro = new CadastroInterface();
        interfaceCadastro.setDefaultCloseOperation(interfaceCadastro.EXIT_ON_CLOSE);
        interfaceCadastro.setVisible(true);
    }
}