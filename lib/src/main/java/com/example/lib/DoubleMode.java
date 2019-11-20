package com.example.lib;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DoubleMode extends JPanel {
    private FrameSet frameSet = null;

    public DoubleMode(FrameSet frameset) {
        initComponents();
        this.frameSet = frameset;
        frameSet.setTitle("���H�若");
        frameSet.add(this);//�b�������s�W���Op1
        frameSet.setVisible(true);//��ܭ��O
    }

    private void initComponents() {
        this.setLayout(null);
        JButton btn1 = new JButton("���H�若-�@��Ҧ�");
        btn1.setBounds(90, 30, 200, 50);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PPG p1 = new PPG(PPG.Mode_general,frameSet);
                setVisible(false);//���÷�e���O
                frameSet.add(p1);//�b�������s�W���Op1
                frameSet.setVisible(true);//��ܭ��O
            }
        });
        this.add(btn1);

        JButton btn2 = new JButton("���H�若-�L���Ҧ�");
        btn2.setBounds(90, 100, 200, 50);
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PPG p1=new PPG(PPG.Mode_unlimited,frameSet);//�s�ح��ONewJPanel2�A�ñN����n2�ǤJ
                setVisible(false);//���÷�e���O
                frameSet.add(p1);//�b�������s�W���Op1
                frameSet.setVisible(true);//��ܭ��O
            }
        });
        this.add(btn2);

        JButton btn3 = new JButton("��^�ؿ�");
        btn3.setBounds(90, 310, 200, 50);
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Directory p1=new Directory(frameSet);//�s�ح��ONewJPanel2�A�ñN����n2�ǤJ
                setVisible(false);//���÷�e���O
                frameSet.add(p1);//�b�������s�W���Op1
                frameSet.setVisible(true);//��ܭ��O
            }
        });
        this.add(btn3);
    }
}
