package com.example.lib;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Directory extends JFrame {
    private JPanel jPanel = new JPanel();

    public Directory() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0,0,400,400);
        this.setTitle("遊戲目錄");
        this.setVisible(true);

        this.setContentPane(jPanel);
        jPanel.setLayout(null);

        JButton btn1 = new JButton("單人");
        btn1.setBounds(90, 30, 200, 50);
        jPanel.add(btn1);

        final JButton btn2 = new JButton("雙人對打");
        btn2.setBounds(90, 100, 200, 50);
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jPanel= new PPG();
            }
        });
        jPanel.add(btn2);

        JButton btn3 = new JButton("離開");
        btn3.setBounds(90,170 , 200, 50);
        jPanel.add(btn3);
    }
}
