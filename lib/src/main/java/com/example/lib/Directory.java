package com.example.lib;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JPanel;

public class Directory extends JPanel{


    private FrameSet frameSet = null;

    public Directory() {
        frameSet = new FrameSet();
        initComponents();
        frameSet.setTitle("�ؿ�");
        frameSet.add(this);//�b�������s�W���Op1
        this.setVisible(true);
    }
    public Directory(FrameSet frameset){
        frameSet = frameset;
        initComponents();
        this.setVisible(true);
        frameSet.setTitle("�ؿ�");
        frameSet.add(this);//�b�������s�W���Op1
        frameSet.setVisible(true);//��ܭ��O
    }
    private void initComponents(){
        frameSet.add(this);
        this.setLayout(null);

        JButton btn1 = new JButton("��H");
        btn1.setBounds(90, 30, 200, 50);
        this.add(btn1);

        JButton btn2 = new JButton("���H�若");
        btn2.setBounds(90, 100, 200, 50);
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DoubleMode(frameSet);
                setVisible(false);
            }
        });
        this.add(btn2);

        JButton btn3 = new JButton("���}");
        btn3.setBounds(90, 170, 200, 50);
        this.add(btn3);

    }
}
