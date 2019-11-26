package com.example.lib;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class Match extends JPanel implements ActionListener {
    private FrameSet frameSet = null;
    private int SCREEN_WIDTH;
    private int SCREEN_HEIGHT;
    private int[] Score;
    private boolean isContinue = true;
    private Ball ball = new Ball();
    private PlayPad playPad = new PlayPad();
    private Operating operating = new Operating();
    private int MODE = -1;

    Match(int Mode, FrameSet frameset) {
        frameSet = frameset;
        MODE = Mode;
        SCREEN_WIDTH = 400;
        SCREEN_HEIGHT = 400;
        ball.setMode(MODE, SCREEN_WIDTH, SCREEN_HEIGHT);
        setWindows();
    }

    public void setWindows() {
        this.setFocusable(true);            //http://hk.uwenku.com/question/p-scplcwbw-bgh.html
        this.addKeyListener(operating);
        operating.setOperating(playPad, SCREEN_HEIGHT, this);

        frameSet.setVisible(true);
        frameSet.add(this);

        playPad.initPlayerPos(SCREEN_WIDTH, SCREEN_HEIGHT);
        playPad.initPlayerScore();
        ball.initBallTimer(this);
    }

    public void setFrameTitle(String Title) {
        frameSet.setTitle(Title);
    }

    public int getMODE() {
        return MODE;
    }

    public int[] getScore() {
        return Score;
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
        if (isContinue) {
            ball.BallMove();
            Score = ball.checkBallPosRange(SCREEN_WIDTH, SCREEN_HEIGHT, playPad.getPlayerScore());
            playPad.setPlayerScore(Score);
            ball.Ball_Pad_interactive(playPad.getPlayerPosX(), playPad.getPlayerPosY(), playPad.getPad_Width_Height());
            repaint();
        }
    }


    public void JudgeGameOver(int[] Score) {
        if (isContinue) {
            for (int i = 0; i < 2; i++) {
                if (Score[i] > 0) {
                    terminate();
                    operating.JudgeContinue(isContinue);
                    GameOver p1 = new GameOver(frameSet);//新建面板NewJPanel2，並將視窗n2傳入
                    setVisible(false);//隱藏當前面板
                    frameSet.add(p1);//在視窗中新增面板p1
                    frameSet.setVisible(true);//顯示面板

                }
            }
        }
    }

    private void terminate() {
        isContinue = false;//https://openhome.cc/Gossip/JavaEssence/StopThread.html
    }
}
