package com.awzhan.game;

import com.awzhan.game.model.SnakeHead;
import com.awzhan.game.util.GameUtils;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;

public class GameWin extends JFrame {
    private static final String TITLE = "Snake Game";
    private static final int HEIGHT = 600;
    private static final int WIDTH = 600;
    private static final int INTERVAL = 30;

    private final SnakeHead snakeHead = new SnakeHead(GameUtils.snakeHeadRight, 30, 570, this);

    public void launch() {
        this.setSize(WIDTH, HEIGHT);
        // set frame in the center of the screen
        this.setLocationRelativeTo(null);
        this.setTitle(TITLE);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(Color.GRAY);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);

        graphics.setColor(Color.black);
        for (int i = 0; i <= 20; i++) {
            // horizontal lines
            graphics.drawLine(0, i * INTERVAL, WIDTH, i * 30);
            // vertical lines
            graphics.drawLine(i * INTERVAL, 0, i * INTERVAL, HEIGHT);
        }

        snakeHead.draw(graphics);
    }

    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }
}
