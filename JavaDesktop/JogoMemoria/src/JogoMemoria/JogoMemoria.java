package JogoMemoria;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class JogoMemoria extends JFrame {

    private int cont = 0, aux = 0, primeiro_Click, vencedor = 0;
    boolean verifica;

    private JTextField campoTexto;
    private JPanel painel;
    private JButton[] botao = new JButton[20];
    private Icon img1RockLee, img2Naruto, img3Kakashi, img4Obito, img5Konohamaru, img6Guy,
            img7Hinata, img8Sakura, img9Sasuke, img10Neji;
    private JButton botaoAux;

    public JogoMemoria() {
        super("Jogo da Memória");
        setLayout(new BorderLayout());

        campoTexto = new JTextField("Jogo da Memória Naruto");
        campoTexto.setHorizontalAlignment(JTextField.CENTER);
        campoTexto.setEditable(false);
        campoTexto.setFont(new Font("serif", Font.PLAIN, 40));
        add(campoTexto, BorderLayout.NORTH);

        painel = new JPanel();

        painel.setLayout(new GridLayout(4, 5));
        add(painel, BorderLayout.CENTER);

        // Criando os Botões
        for (int i = 0; i < botao.length; i++) {
            botao[i] = new JButton();
            botao[i].addActionListener(new ImagemaoClicar());
        }
        for (int i = 0; i < botao.length; i++) {
            botao[i].setIcon(new ImageIcon(getClass().getResource("interrogacao.jpg")));
        }

        for (int i = 0; i < botao.length; i++) {
            painel.add(botao[i]);
        }
        // Instanciando Imagens
        img1RockLee = new ImageIcon(getClass().getResource("rockLee.jpg"));//**
        img2Naruto = new ImageIcon(getClass().getResource("naruto.jpg"));//**
        img3Kakashi = new ImageIcon(getClass().getResource("kakashi.jpg"));//**
        img4Obito = new ImageIcon(getClass().getResource("obito.jpg"));//**
        img5Konohamaru = new ImageIcon(getClass().getResource("konohamaru.jpg"));//**
        img6Guy = new ImageIcon(getClass().getResource("guy.jpg"));//**
        img7Hinata = new ImageIcon(getClass().getResource("hinata.jpg"));//**
        img8Sakura = new ImageIcon(getClass().getResource("sakura.jpg"));//**
        img9Sasuke = new ImageIcon(getClass().getResource("sasuke.jpg"));//**
        img10Neji = new ImageIcon(getClass().getResource("neji.jpg"));//**

        // setando nome pra cada botao
        botao[0].setText("lee");
        botao[1].setText("kakashi");
        botao[2].setText("hinata");
        botao[3].setText("naruto");
        botao[4].setText("sakura");
        botao[5].setText("sasuke");
        botao[6].setText("neji");
        botao[7].setText("neji");
        botao[8].setText("konohamaru");
        botao[9].setText("mightGuy");
        botao[10].setText("obito");
        botao[11].setText("konohamaru");
        botao[12].setText("mightGuy");
        botao[13].setText("sasuke");
        botao[14].setText("sakura");
        botao[15].setText("obito");
        botao[16].setText("hinata");
        botao[17].setText("kakashi");
        botao[18].setText("naruto");
        botao[19].setText("lee");

        botaoAux = new JButton();
        botaoAux.setIcon(new ImageIcon(getClass().getResource("interrogacao.jpg")));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 865);
        setVisible(true);
    }

    public class ImagemaoClicar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            cont++;
            for (int i = 0; i < botao.length; i++) {
                if (e.getSource() == botao[i]) {
                    aux = i;
                }

            }

            switch (aux) {
                case 0:
                    botao[aux].setIcon(img1RockLee);

                    break;
                case 1:
                    botao[aux].setIcon(img3Kakashi);
                    break;
                case 2:
                    botao[aux].setIcon(img7Hinata);
                    break;
                case 3:
                    botao[aux].setIcon(img2Naruto);
                    break;
                case 4:
                    botao[aux].setIcon(img8Sakura);
                    break;
                case 5:
                    botao[aux].setIcon(img9Sasuke);
                    break;
                case 6:
                    botao[aux].setIcon(img10Neji);

                    break;
                case 7:
                    botao[aux].setIcon(img10Neji);

                    break;
                case 8:
                    botao[aux].setIcon(img5Konohamaru);
                    break;
                case 9:
                    botao[aux].setIcon(img6Guy);
                    break;
                case 10:
                    botao[aux].setIcon(img4Obito);
                    break;
                case 11:
                    botao[aux].setIcon(img5Konohamaru);
                    break;
                case 12:
                    botao[aux].setIcon(img6Guy);
                    break;
                case 13:
                    botao[aux].setIcon(img9Sasuke);
                    break;
                case 14:
                    botao[aux].setIcon(img8Sakura);
                    break;
                case 15:
                    botao[aux].setIcon(img4Obito);
                    break;
                case 16:
                    botao[aux].setIcon(img7Hinata);
                    break;
                case 17:
                    botao[aux].setIcon(img3Kakashi);
                    break;
                case 18:
                    botao[aux].setIcon(img2Naruto);
                    break;
                case 19:
                    botao[aux].setIcon(img1RockLee);
                    break;
                default:
                    System.out.println("'-'");

            }

            if (cont == 1) {
                primeiro_Click = aux;
            } else if (cont == 2) {
                if (!botao[primeiro_Click].getText().equals(botao[aux].getText())) {
                    JOptionPane.showMessageDialog(null, "Errado");
                    botao[primeiro_Click].setIcon(new ImageIcon(getClass().getResource("interrogacao.jpg")));
                    botao[aux].setIcon(new ImageIcon(getClass().getResource("interrogacao.jpg")));
                } else {
                    botao[primeiro_Click].setEnabled(false);
                    botao[aux].setEnabled(false);
                    vencedor++;
                }
                cont = 0;
            }
            if (vencedor >=  10) {
                JOptionPane.showMessageDialog(null, "Parabéns !!! Você encontrou todos os pares, clique no X para sair");
            }

        }

    }

}
