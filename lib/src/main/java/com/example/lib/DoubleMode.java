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
        frameSet.setTitle("雙人對打");
        frameSet.add(this);//在視窗中新增面板p1
        frameSet.setVisible(true);//顯示面板
    }

    private void initComponents() {
        this.setLayout(null);
        JButton btn1 = new JButton("雙人對打-一般模式");
        btn1.setBounds(90, 30, 200, 50);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PPG p1 = new PPG(PPG.Mode_general,frameSet);
                setVisible(false);//隱藏當前面板
                frameSet.add(p1);//在視窗中新增面板p1
                frameSet.setVisible(true);//顯示面板
            }
        });
        this.add(btn1);

        JButton btn2 = new JButton("雙人對打-無限模式");
        btn2.setBounds(90, 100, 200, 50);
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PPG p1=new PPG(PPG.Mode_unlimited,frameSet);//新建面板NewJPanel2，並將視窗n2傳入
                setVisible(false);//隱藏當前面板
                frameSet.add(p1);//在視窗中新增面板p1
                frameSet.setVisible(true);//顯示面板
            }
        });
        this.add(btn2);

        JButton btn3 = new JButton("返回目錄");
        btn3.setBounds(90, 310, 200, 50);
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Directory p1=new Directory(frameSet);//新建面板NewJPanel2，並將視窗n2傳入
                setVisible(false);//隱藏當前面板
                frameSet.add(p1);//在視窗中新增面板p1
                frameSet.setVisible(true);//顯示面板
            }
        });
        this.add(btn3);
    }
}
