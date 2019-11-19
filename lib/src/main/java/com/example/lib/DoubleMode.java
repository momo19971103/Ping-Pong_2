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
        frameSet.setTitle("雙人對打");
        frameSet.add(this);//在視窗中新增面板p1
        frameSet.setVisible(true);//顯示面板
    }
    private void initComponents(){
        this.setLayout(null);
        JButton btn1 = new JButton("雙人對打-一般模式");
        btn1.setBounds(90, 30, 200, 50);
        this.add(btn1);

        final JButton btn2 = new JButton("雙人對打-無限模式");
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
