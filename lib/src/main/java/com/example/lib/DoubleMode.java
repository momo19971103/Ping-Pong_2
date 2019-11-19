package com.example.lib;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DoubleMode extends JPanel {
    FrameSet frameSet = null;
    public DoubleMode(FrameSet frameset){
        initComponents();
        this.frameSet = frameset;
        frameSet.setTitle("���H�若");
        frameSet.add(this);//�b�������s�W���Op1
        frameSet.setVisible(true);//��ܭ��O
    }
    private void initComponents(){
        this.setLayout(null);
        JButton btn1 = new JButton("���H�若-�@��Ҧ�");
        btn1.setBounds(90, 30, 200, 50);
        this.add(btn1);

        final JButton btn2 = new JButton("���H�若-�L���Ҧ�");
        btn2.setBounds(90, 100, 200, 50);
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameSet.setVisible(false);
                new PPG();
            }
        });
        this.add(btn2);
    }
}
