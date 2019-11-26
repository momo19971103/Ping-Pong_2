package com.example.lib;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.JPanel;


public class DoublesMatch extends JPanel implements  ActionListener {
    private FrameSet frameSet = null;
    private int SCREEN_WIDTH;
    private int SCREEN_HEIGHT;
    private boolean isContinue = true;
    private Ball ball = new Ball();
    private PlayPad playPad = new PlayPad();
    private Operating operating = new Operating();
    final static int Mode_general = 0, Mode_unlimited = 1;
    private int MODE = -1;

    DoublesMatch(int Mode, FrameSet frameset) {
        frameSet = frameset;
        MODE = Mode;
        SCREEN_WIDTH = 400;
        SCREEN_HEIGHT = 400;
        ball.setMode(MODE, SCREEN_WIDTH, SCREEN_HEIGHT);
        setWindows();
    }

    public DoublesMatch(int Mode, int width, int height) {
        MODE = Mode;
        SCREEN_WIDTH = width;
        SCREEN_HEIGHT = height;
        ball.setMode(MODE, SCREEN_WIDTH, SCREEN_HEIGHT);
        setWindows();
    }

    public void setWindows() {
        this.setFocusable(true);            //http://hk.uwenku.com/question/p-scplcwbw-bgh.html
        this.addKeyListener(operating);
        operating.setOperating(playPad,SCREEN_HEIGHT,this);
        if (MODE == Mode_general)
            frameSet.setTitle("�@��Ҧ�");
        if (MODE == Mode_unlimited)
            frameSet.setTitle("�L���Ҧ�");
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
        super.paint(g);         //�����OWindow��paint
        playPad.drawPlayerPad(g);
        playPad.drawScore(g);
        ball.drawBall(g);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (isContinue) {
            ball.BallMove();
            int[] Score = ball.checkBallPosRange(SCREEN_WIDTH, SCREEN_HEIGHT, playPad.getPlayerScore());
            if (MODE == Mode_general)
                JudgeGameOver(Score);
            playPad.setPlayerScore(Score);
            ball.Ball_Pad_interactive(playPad.getPlayerPosX(), playPad.getPlayerPosY(), playPad.getPad_Width_Height());
            repaint();
        }
    }



    private void JudgeGameOver(int[] Score) {
        for (int i = 0; i < 2; i++) {
            if (Score[i] > 0) {
                terminate();
                operating.JudgeContinue(isContinue);
                GameOver p1 = new GameOver(frameSet);//�s�ح��ONewJPanel2�A�ñN����n2�ǤJ
                setVisible(false);//���÷�e���O
                frameSet.add(p1);//�b�������s�W���Op1
                frameSet.setVisible(true);//��ܭ��O

            }
        }
    }

    private void terminate() {
        isContinue = false;//https://openhome.cc/Gossip/JavaEssence/StopThread.html
    }
}