package com.example.lib;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Ball {
    private Timer ballTimer;
    private int Ball_PosX;
    private int Ball_PosY;
    private int ballSpeedX = 1, ballSpeedY = 1;
    final int DELAY_MS = 10;
    private int BALL_RADIUS = 20;
    private int[] BallCenterPos;
    private int[] BallAroundPos;
    private final int AroundLeft=0,AroundRight=1,AroundUp=2,AroundDown=3;
    private final int CenterX=0,CenterY=1;

    public void setBallPos(int screen_Width, int screen_Height) {
        Ball_PosX = screen_Width / 2;
        Ball_PosY = screen_Height / 2;
    }

    public void initBallTimer(ActionListener ball) {
        ballTimer = new Timer(DELAY_MS, ball);
        ballTimer.setInitialDelay(1);
        ballTimer.start();
    }

    public void drawBall(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillOval(Ball_PosX, Ball_PosY, BALL_RADIUS, BALL_RADIUS);
    }

    public void BallMove() {
        Ball_PosX += ballSpeedX;
        Ball_PosY += ballSpeedY;
        BallCenterPos = new int[]{Ball_PosX+10, Ball_PosY+10};
        BallAroundPos = new int[]{Ball_PosX,Ball_PosX+20,Ball_PosY,Ball_PosY+20};
    }

    public int[] checkBallPosRange(int screen_Width, int screen_Height, int playerScore[]) {
        int WidthCorrectionLength = 5;//(400,400)
        if (Ball_PosX > screen_Width - BALL_RADIUS - WidthCorrectionLength || Ball_PosX < 0) {
            ballSpeedX = -ballSpeedX;

            if (Ball_PosX <= 0) {
                playerScore[1]++;
            } else {
                playerScore[0]++;
            }
        }
        int HeightCorrectionLength = 35;//(400,400)
        if (Ball_PosY > screen_Height - BALL_RADIUS - HeightCorrectionLength || Ball_PosY < 0)
            ballSpeedY = -ballSpeedY;

        return playerScore;
    }

    public void Ball_Pad_interactive(int[] playerPosX, int[] playerPosY, int[] Pad_Width_Height) {
        // 球是否碰到左邊板子
        int Width = 0, Height = 1,radius=10;
        final int X=0,Y=1;
        int[] Play1_PadTopLeftPos={playerPosX[0],playerPosY[0]};
        int[] Play2_PadTopLeftPos={playerPosX[1],playerPosY[1]};
        if(BallCenterPos[CenterY]>Play1_PadTopLeftPos[Y]&&BallCenterPos[CenterY]<Play1_PadTopLeftPos[Y]+ Pad_Width_Height[Height]
        &&BallAroundPos[AroundLeft]<Play1_PadTopLeftPos[X]+Pad_Width_Height[Width])
            ballSpeedX = 1;




        // 球是否碰到右邊板子
        if(BallCenterPos[CenterY]>Play2_PadTopLeftPos[Y]&&BallCenterPos[CenterY]<Play2_PadTopLeftPos[Y]+ Pad_Width_Height[Height]
                &&BallAroundPos[AroundRight]>Play2_PadTopLeftPos[X])
            ballSpeedX = -1;



    }
}
