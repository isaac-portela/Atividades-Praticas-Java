package Calculadora;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculadora extends JFrame {

    private JButton botao1, botao2, botao3, botao4, botao5, botao6, botao7, botao8, botao9, botaoZero, botaoSoma, botaoSub, botaoMult, botaoDiv, botaoPonto, botaoIgual, botaoApagar;
    private JTextField campodeTexto;

    public Calculadora() {
        super("Calculadora");

        // Inicializações dos botoes da calculadora 
        botao1 = new JButton("1");
        botao2 = new JButton("2");
        botao3 = new JButton("3");
        botao4 = new JButton("4");
        botao5 = new JButton("5");
        botao6 = new JButton("6");
        botao7 = new JButton("7");
        botao8 = new JButton("8");
        botao9 = new JButton("9");
        botaoZero = new JButton("0");

        botaoSoma = new JButton("+");
        botaoSub = new JButton("-");
        botaoMult = new JButton("x");
        botaoDiv = new JButton("/");
        botaoPonto = new JButton(".");
        botaoIgual = new JButton("=");
        botaoApagar = new JButton("AC");

        // Ouvinte dos botões
        botao1.addActionListener(new Botao1Listener());
        botao2.addActionListener(new Botao2Listener());
        botao3.addActionListener(new Botao3Listener());
        botao4.addActionListener(new Botao4Listener());
        botao5.addActionListener(new Botao5Listener());
        botao6.addActionListener(new Botao6Listener());
        botao7.addActionListener(new Botao7Listener());
        botao8.addActionListener(new Botao8Listener());
        botao9.addActionListener(new Botao9Listener());
        botaoZero.addActionListener(new BotaoZeroListener());
        botaoSoma.addActionListener(new BotaoSomaListener());
        botaoSub.addActionListener(new BotaoSubListener());
        botaoMult.addActionListener(new BotaoMultListener());
        botaoDiv.addActionListener(new BotaoDivListener());
        botaoPonto.addActionListener(new BotaoPontoListener());
        botaoIgual.addActionListener(new BotaoIgualListener());
        botaoApagar.addActionListener(new BotaoApagarListener());

        // Inicializando e adicionando ao grid  layout os botoes da calculadora
     JPanel n = new JPanel();
        n.setLayout(new GridLayout(5, 5, 5, 5));
        n.add(botao7);
        n.add(botao8);
        n.add(botao9);
        n.add(botaoDiv);
        n.add(botao4);
        n.add(botao5);
        n.add(botao6);
        n.add(botaoMult);
        n.add(botao1);
        n.add(botao2);
        n.add(botao3);
        n.add(botaoSub);
        n.add(botaoZero);
        n.add(botaoPonto);
        n.add(botaoIgual);
        n.add(botaoSoma);
        n.add(botaoApagar);

        campodeTexto = new JTextField();
        campodeTexto.setEditable(false);
        campodeTexto.setFont(new Font("serif", Font.PLAIN, 26));
        Container c = getContentPane();
        c.add(BorderLayout.NORTH, campodeTexto);
        c.add(BorderLayout.CENTER, n);

        // definiçoes do tamanho da janela 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);

    }

    // classes para ouvintes dos botoes
    public class Botao1Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            campodeTexto.setText(campodeTexto.getText() + "1");
        }

    }

    public class Botao2Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            campodeTexto.setText(campodeTexto.getText() + "2");
        }
    }

    public class Botao3Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            campodeTexto.setText(campodeTexto.getText() + "3");
        }
    }

    public class Botao4Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            campodeTexto.setText(campodeTexto.getText() + "4");
        }
    }

    public class Botao5Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            campodeTexto.setText(campodeTexto.getText() + "5");
        }
    }

    public class Botao6Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            campodeTexto.setText(campodeTexto.getText() + "6");
        }
    }

    public class Botao7Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            campodeTexto.setText(campodeTexto.getText() + "7");
        }
    }

    public class Botao8Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            campodeTexto.setText(campodeTexto.getText() + "8");
        }
    }

    public class Botao9Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            campodeTexto.setText(campodeTexto.getText() + "9");
        }
    }

    public class BotaoZeroListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            campodeTexto.setText(campodeTexto.getText() + "0");
        }
    }

    public class BotaoSomaListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (campodeTexto.getText().isEmpty()) {
                campodeTexto.setText(campodeTexto.getText() + "");
            } else if (campodeTexto.getText().lastIndexOf(" ") == (campodeTexto.getText().length() - 1)) {
                campodeTexto.setText(campodeTexto.getText() + "");
            } else {
                campodeTexto.setText(campodeTexto.getText() + " + ");
            }

        }

    }

    public class BotaoSubListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (campodeTexto.getText().isEmpty()) {
                campodeTexto.setText(campodeTexto.getText() + "");
            } else if (campodeTexto.getText().lastIndexOf(" ") == (campodeTexto.getText().length() - 1)) {
                campodeTexto.setText(campodeTexto.getText() + "");
            } else {
                campodeTexto.setText(campodeTexto.getText() + " - ");
            }

        }
    }

    public class BotaoMultListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (campodeTexto.getText().isEmpty()) {
                campodeTexto.setText(campodeTexto.getText() + "");
            } else if (campodeTexto.getText().lastIndexOf(" ") == (campodeTexto.getText().length() - 1)) {
                campodeTexto.setText(campodeTexto.getText() + "");
            } else {
                campodeTexto.setText(campodeTexto.getText() + " x ");
            }

        }
    }

    public class BotaoDivListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (campodeTexto.getText().isEmpty()) {
                campodeTexto.setText(campodeTexto.getText() + "");
            } else if (campodeTexto.getText().lastIndexOf(" ") == (campodeTexto.getText().length() - 1)) {
                campodeTexto.setText(campodeTexto.getText() + "");
            } else {
                campodeTexto.setText(campodeTexto.getText() + " / ");
            }

        }
    }

    public class BotaoPontoListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (campodeTexto.getText().isEmpty()) {
                campodeTexto.setText(campodeTexto.getText() + "");
            } else if (campodeTexto.getText().lastIndexOf(" ") == (campodeTexto.getText().length() - 1)) {
                campodeTexto.setText(campodeTexto.getText() + "");
            } else {
                campodeTexto.setText(campodeTexto.getText() + ".");
            }

        }

    }
    public class BotaoApagarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            campodeTexto.setText("");
        }
    }

    public class BotaoIgualListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String[] fichas = campodeTexto.getText().split(" ");
            double resultado = 0;
            String sinal = "";
            for (int i = 0; i < fichas.length; i++) {
                if (i == 0) {
                    resultado = Double.parseDouble(fichas[i]);
                } else if (i % 2 == 1) {
                    sinal = fichas[i];
                } else {
                    if (sinal.contentEquals("+")) {
                        resultado += Double.parseDouble(fichas[i]);
                    }
                    else if(sinal.contentEquals("-")){
                        resultado -= Double.parseDouble(fichas[i]);
                    }
                    else if(sinal.contentEquals("x")){
                        resultado *= Double.parseDouble(fichas[i]);
                    }
                     else{
                        resultado /= Double.parseDouble(fichas[i]);
                    }
                    
                }
            }
            campodeTexto.setText(""+resultado);
            
        }

    }
}
