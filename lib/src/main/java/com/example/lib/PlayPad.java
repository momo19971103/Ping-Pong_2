package com.example.lib;

import java.awt.Color;
import java.awt.Graphics;

public class PlayPad {
    private int InitialPad_Width = 20;
    private int InitialPad_Height = 100;
    private int PAD_OFFSET = 10;
    private int playerSpeedY = 20;
    private int PLAYER_NUM = 2;
    private int[] playerPosX = new int[PLAYER_NUM];
    private int[] playerPosY = new int[PLAYER_NUM];
    private int[] playerScore = new int[PLAYER_NUM];

    public void initPlayerPos(int screen_Width, int screen_Height) {
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerPosY[i] = screen_Height / 2;
        }
        int WidthCorrectionLength = 10;
        playerPosX[0] =  PAD_OFFSET ;
        playerPosX[1] = screen_Width - InitialPad_Width - PAD_OFFSET-WidthCorrectionLength ;
    }

    public void initPlayerScore() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerScore[i] = 0;
        }
    }

    public void drawPlayerPad(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(playerPosX[0], playerPosY[0], InitialPad_Width, InitialPad_Height);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(playerPosX[1], playerPosY[1], InitialPad_Width, InitialPad_Height);
    }

    public void drawScore(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString("P1:" + playerScore[0], playerPosX[0] + 10, 50);
        g.drawString("P2:" + playerScore[1], playerPosX[1] - 20, 50);
    }

    public void Down(int player) {
        playerPosY[player] += playerSpeedY;
    }

    public void UP(int player) {
        playerPosY[player] -= playerSpeedY;
    }

    public void checkPadPosRange(int screen_Height) {
        for (int i = 0; i < PLAYER_NUM; i++) {
            if (playerPosY[i] < 0) playerPosY[i] = 0;
            if (playerPosY[i] > screen_Height - InitialPad_Height)
                playerPosY[i] = screen_Height - InitialPad_Height;
        }
    }

    public int[] getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int[] PlayerScore) {
        playerScore = PlayerScore;
    }

    public int[] getPlayerPosX() {
        return playerPosX;
    }

    public int[] getPlayerPosY() {
        return playerPosY;
    }

    public int[] getPad_Width_Height() {
        return new int[]{InitialPad_Width, InitialPad_Height};
    }

}
