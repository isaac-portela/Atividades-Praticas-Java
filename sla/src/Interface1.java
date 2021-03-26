import javax.swing.*;
import java.awt.*;

public class Interface1 extends JFrame {
    JCheckBox Snap, Show;
    JLabel xLb, yLb;
    JTextField x, y;
    JButton ok, cancelar, help;
    Container ctn;

    public Interface1() {
        super("Align");
        setSize(380, 200);
        ctn = getContentPane();
        ctn.setLayout(null);
        Snap = new JCheckBox("Snap to Grid");
        Show = new JCheckBox("Show Grid");
        Snap.setBounds(10,50,100,20);
        Show.setBounds(10,70,100,20);


        xLb = new JLabel("X:");
        yLb = new JLabel("Y:");
        x = new JTextField();
        y = new JTextField();
        x.setText("8");
        y.setText("8");

        xLb.setBounds(120,30,20,20);
        x.setBounds(150,30,40,20);
        y.setBounds(150,90,40,20);
        yLb.setBounds(120,90,20,20);

        ok = new JButton("Ok");
        cancelar = new JButton("Cancel");
        help = new JButton("Help");

        ok.setBounds(230,10,100,30);
        cancelar.setBounds(230,70,100,30);
        help.setBounds(230,120,100,30);

        ctn.add(Snap);
        ctn.add(Show);
        ctn.add(xLb);
        ctn.add(x);
        ctn.add(yLb);
        ctn.add(y);
        ctn.add(ok);
        ctn.add(cancelar);
        ctn.add(help);
    }
}
