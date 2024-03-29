package com.example.lib;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import static com.example.lib.GameModule.Mode_general;
import static com.example.lib.GameModule.Mode_simpleAI;
import static com.example.lib.GameModule.Mode_unlimited;

public class Operating implements KeyListener {
    private boolean isContinue = true;
    private PlayPad playPad = null;
    private boolean individual = false;
    private JPanel jPanel = null;
    private int SCREEN_HEIGHT = 0;

    public void setMode(int Mode) {
        if (Mode == Mode_simpleAI) {
            individual = true;
        }
    }

    public void setOperating(PlayPad playpad, int SCREEN_hight, JPanel jpanel) {
        playPad = playpad;
        SCREEN_HEIGHT = SCREEN_hight;
        jPanel = jpanel;
    }

    public void JudgeContinue(boolean is_continue) {
        isContinue = is_continue;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (isContinue) {
            int key = keyEvent.getKeyCode();

            // Move the player on the left
            if (key == KeyEvent.VK_UP)
                playPad.UP(1);

            if (key == KeyEvent.VK_DOWN)
                playPad.Down(1);
            if (!individual) {
                // Move the player on the right
                if (key == KeyEvent.VK_W)
                    playPad.UP(0);

                if (key == KeyEvent.VK_S)
                    playPad.Down(0);
            }
            playPad.checkPadPosRange(SCREEN_HEIGHT);
            jPanel.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
