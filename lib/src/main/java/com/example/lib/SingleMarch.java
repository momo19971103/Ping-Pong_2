package com.example.lib;

import java.awt.event.ActionEvent;

public class SingleMarch extends GameModule {

    SingleMarch(int Mode, FrameSet frameset) {
        super(Mode, frameset);
    }
    @Override
    public  void setWindows(){
        super.setFrameTitle("³æ¤H");
        super.setWindows();
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        super.actionPerformed(actionEvent);
        if (super.getMODE() == Mode_simpleAI)
            JudgeGameOver(super.getScore());
    }

}
