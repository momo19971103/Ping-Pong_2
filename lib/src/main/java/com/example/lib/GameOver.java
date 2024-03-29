package com.example.lib;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOver extends JPanel {
    private FrameSet frameSet = null;
    public GameOver(){
        initComponents();
        frameSet = new FrameSet();
        frameSet.setTitle("遊戲結束");
        frameSet.setContentPane(this);//在視窗中新增面板p1
        frameSet.setVisible(true);//顯示面板
    }
    public GameOver(final FrameSet frameset){
        initComponents();
        this.frameSet = frameset;
        frameSet.setTitle("遊戲結束");
        frameSet.add(this);//在視窗中新增面板p1
        frameSet.setVisible(true);//顯示面板
    }
    private void initComponents(){
        this.setLayout(null);
        JLabel jLabel = new JLabel("遊戲結束");
        jLabel.setFont(new Font("細明體", Font.BOLD, 48));
        jLabel.setBounds(90, 30, 200, 50);
        this.add(jLabel);

        JButton btn1 = new JButton("返回目錄");
        btn1.setBounds(90, 200, 200, 50);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Directory p1=new Directory(frameSet);//新建面板NewJPanel2，並將視窗n2傳入
                setVisible(false);//隱藏當前面板
                frameSet.add(p1);//在視窗中新增面板p1
                frameSet.setVisible(true);//顯示面板
            }
        });
        this.add(btn1);
    }
}
