package com.awzhan.game;

import javax.swing.JFrame;

public class GameWin extends JFrame {

    public void launch() {
        this.setSize(600, 600);
        // set frame in the center of the screen
        this.setLocationRelativeTo(null);
        this.setTitle("Snake");
        this.setVisible(true);
    }


    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }
}
