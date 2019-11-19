package com.example.lib;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JPanel;


public class PPG extends JPanel implements KeyListener, ActionListener {
    private int SCREEN_WIDTH;
    private int SCREEN_HEIGHT;
    private Ball ball = new Ball();
    private PlayPad playPad = new PlayPad();

    PPG() {
        SCREEN_WIDTH = 400;
        SCREEN_HEIGHT = 400;
        ball.setBallPos(SCREEN_WIDTH, SCREEN_HEIGHT);
        setWindows();
    }

    public PPG(int width, int height) {
        SCREEN_WIDTH = width;
        SCREEN_HEIGHT = height;
        ball.setBallPos(SCREEN_WIDTH, SCREEN_HEIGHT);
        setWindows();
    }

    public void setWindows() {
        FrameSet frameSet = new FrameSet();
        frameSet.addKeyListener(this);
        frameSet.setTitle("無限地獄");
        frameSet.setVisible(true);
        frameSet.add(this);

        playPad.initPlayerPos(SCREEN_WIDTH, SCREEN_HEIGHT);
        playPad.initPlayerScore();
        ball.initBallTimer(this);
    }


    public void update(Graphics g) {
        this.paint(g);
    }

    public void paint(Graphics g) {

        super.paint(g);         //父類別Window的paint

        playPad.drawPlayerPad(g);
        playPad.drawScore(g);
        ball.drawBall(g);

    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        ball.BallMove();
        int[] Score = ball.checkBallPosRange(SCREEN_WIDTH, SCREEN_HEIGHT, playPad.getPlayerScore());
        playPad.setPlayerScore(Score);
        ball.Ball_Pad_interactive(playPad.getPlayerPosX(), playPad.getPlayerPosY(), playPad.getPad_Width_Height());
        repaint();

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();

        // Move the player on the left
        if (key == KeyEvent.VK_UP)
            playPad.UP(1);

        if (key == KeyEvent.VK_DOWN)
            playPad.Down(1);

        // Move the player on the right
        if (key == KeyEvent.VK_W)
            playPad.UP(0);

        if (key == KeyEvent.VK_S)
            playPad.Down(0);

        playPad.checkPadPosRange(SCREEN_HEIGHT);
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}