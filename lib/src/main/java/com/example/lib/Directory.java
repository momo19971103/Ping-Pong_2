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
        frameSet.setTitle("目錄");
        frameSet.add(this);//在視窗中新增面板p1
        this.setVisible(true);
    }
    public Directory(FrameSet frameset){
        frameSet = frameset;
        initComponents();
        this.setVisible(true);
        frameSet.setTitle("目錄");
        frameSet.add(this);//在視窗中新增面板p1
        frameSet.setVisible(true);//顯示面板
    }
    private void initComponents(){
        frameSet.add(this);
        this.setLayout(null);

        JButton btn1 = new JButton("單人");
        btn1.setBounds(90, 30, 200, 50);
        this.add(btn1);

        JButton btn2 = new JButton("雙人對打");
        btn2.setBounds(90, 100, 200, 50);
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DoubleMode(frameSet);
                setVisible(false);
            }
        });
        this.add(btn2);

        JButton btn3 = new JButton("離開");
        btn3.setBounds(90, 170, 200, 50);
        this.add(btn3);

    }
}
