package com.example.lib;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOver extends JPanel {
    FrameSet frameSet = null;
    public GameOver(FrameSet frameset){
        frameSet = frameset;
        frameSet.setTitle("�C������");
        frameSet.setContentPane(this);//�b�������s�W���Op1
        frameSet.setVisible(true);//��ܭ��O
        this.setLayout(null);
        JLabel jLabel = new JLabel("�C������");
        jLabel.setFont(new Font("�ө���", Font.BOLD, 48));
        jLabel.setBounds(90, 30, 200, 50);
        this.add(jLabel);
        JButton btn1 = new JButton("��^�ؿ�");
        btn1.setBounds(90, 100, 200, 50);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.add(btn1);
    }
}
