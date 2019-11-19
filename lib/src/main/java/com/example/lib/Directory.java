package com.example.lib;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JPanel;

public class Directory {

    public JPanel jPanel = new JPanel();
    public FrameSet frameSet = new FrameSet();

    public Directory() {
        frameSet.add(jPanel);
        jPanel.setLayout(null);

        JButton btn1 = new JButton("單人");
        btn1.setBounds(90, 30, 200, 50);
        jPanel.add(btn1);

        final JButton btn2 = new JButton("雙人對打");
        btn2.setBounds(90, 100, 200, 50);
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DoubleMode(frameSet);
                jPanel.setVisible(false);
            }
        });
        jPanel.add(btn2);

        JButton btn3 = new JButton("離開");
        btn3.setBounds(90, 170, 200, 50);
        jPanel.add(btn3);
    }
}
