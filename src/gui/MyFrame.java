package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    private int num = 3;
    private JLabel lb;
    public MyFrame() throws HeadlessException {
        setTitle("GhostLeg");
        setSize(700,500);
        setVisible(true);

        MyPanel myPanel = new MyPanel();
        add(myPanel, BorderLayout.CENTER);

        JButton btnAdd = new JButton("+");
        JButton btnSub = new JButton("-");
        JButton btnGo = new JButton("GOGO");

        btnGo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myPanel.doSadari();
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num++;
                lb.setText("Now Player: " + num);
                myPanel.addMember();
            }
        });
        btnSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (num>2){
                    num--;
                    lb.setText("Now Player: " + num);
                    myPanel.subMember();
                }
            }
        });

        JPanel pl = new JPanel();

        lb = new JLabel("Now Player: 3");
        pl.add(lb);
        pl.add(btnAdd);
        pl.add(btnSub);
        pl.add(btnGo);
        add(pl,BorderLayout.NORTH);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
