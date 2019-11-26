package com.example.lib;


import java.awt.event.ActionEvent;


public class DoublesMatch extends GameModule {
    final static int Mode_general = 0, Mode_unlimited = 1;

    DoublesMatch(int Mode, FrameSet frameset) {
        super(Mode, frameset);
    }

    @Override
    public void setWindows() {
        super.setWindows();
        if (super.getMODE() == Mode_general)
            super.setFrameTitle("一般模式");
        if (super.getMODE() == Mode_unlimited)
            super.setFrameTitle("無限模式");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        super.actionPerformed(actionEvent);
        if (super.getMODE() == Mode_general)
            JudgeGameOver(super.getScore());
    }

}