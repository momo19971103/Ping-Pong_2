package com.example.lib;

import javax.swing.JFrame;

public class FrameSet extends JFrame {
    public FrameSet(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBounds(0,0,400,400);
        this.setVisible(true);
    }
}
