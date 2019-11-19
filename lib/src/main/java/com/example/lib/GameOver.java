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
        frameSet.setTitle("遊戲結束");
        frameSet.setContentPane(this);//在視窗中新增面板p1
        frameSet.setVisible(true);//顯示面板
        this.setLayout(null);
        JLabel jLabel = new JLabel("遊戲結束");
        jLabel.setFont(new Font("細明體", Font.BOLD, 48));
        jLabel.setBounds(90, 30, 200, 50);
        this.add(jLabel);
        JButton btn1 = new JButton("返回目錄");
        btn1.setBounds(90, 100, 200, 50);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.add(btn1);
    }
}
