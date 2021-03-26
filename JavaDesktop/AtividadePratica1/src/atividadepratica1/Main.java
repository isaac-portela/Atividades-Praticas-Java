package atividadepratica1;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Object[] itens = { "DATA", "HORA"};
        Object selectedValue = JOptionPane.showInputDialog(null,
                "Escolha um item", "Opçao",
                JOptionPane.INFORMATION_MESSAGE, null,
                itens, itens [0]);
        if (selectedValue.equals(itens[0])){
            int dia = Integer.parseInt(JOptionPane.showInputDialog("Digite o dia: "));
            int mes = Integer.parseInt(JOptionPane.showInputDialog("Digite o número mês: "));
            int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano: "));
            Data data = new Data(dia,mes,ano);
                if (data.getDia()==dia && data.getMes()== mes && data.getAno()==ano){
                    JOptionPane.showMessageDialog(null, data.getDia()+"/" + data.getMes()+"/"+data.getAno(), "Data", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,"Data Invalida","alerta",JOptionPane.ERROR_MESSAGE);
            }
        }else if(selectedValue.equals(itens[1])){
            int hora = Integer.parseInt(JOptionPane.showInputDialog("Hora: "));
            int minuto = Integer.parseInt(JOptionPane.showInputDialog("Minuto: "));
            int segundo = Integer.parseInt(JOptionPane.showInputDialog("Segundo: "));
            Hora horacompleta = new Hora(hora,minuto,segundo);
            if (horacompleta.getHora()==hora && horacompleta.getMinuto()== minuto &&  horacompleta.getSegundo()==segundo){
                JOptionPane.showMessageDialog(null, horacompleta.getHora()+":" + horacompleta.getMinuto()+":"+horacompleta.getSegundo(), "Hora", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Hora Invalida","alerta",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
