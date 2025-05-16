package com.awzhan.game;

import com.awzhan.game.model.Food;
import com.awzhan.game.model.SnakeBody;
import com.awzhan.game.model.SnakeHead;
import com.awzhan.game.util.GameUtils;
import lombok.Getter;
import lombok.Setter;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class GameWin extends JFrame {
    private static final String TITLE = "Snake Game";
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int INTERVAL = 30;

    public static int score = 0;
    public static int state = 0;

    private final SnakeHead snakeHead;
    @Getter
    private final List<SnakeBody> snakeBodyList;
    @Getter @Setter
    private Food food;

    public GameWin() {
        this.snakeHead = new SnakeHead(GameUtils.snakeHeadRight, 30, 570, this);
        this.snakeBodyList = new ArrayList<>();
        this.snakeBodyList.add(new SnakeBody(GameUtils.snakeBody, 30, 570, this));
        this.snakeBodyList.add(new SnakeBody(GameUtils.snakeBody, 0, 570, this));
        this.food = Food.getFood(this);
    }

    public void launch() {
        this.setSize(WIDTH, HEIGHT);
        // set frame in the center of the screen
        this.setLocationRelativeTo(null);
        this.setTitle(TITLE);
        this.setVisible(true);

        while (true) {
            if (state == 1) {
                repaint();
            }
            try {
                Thread.sleep(200L);
            } catch (InterruptedException e) {
                // ignore
            }
        }
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(Color.GRAY);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);

        graphics.setColor(Color.black);
        for (int i = 0; i <= 20; i++) {
            // horizontal lines
            graphics.drawLine(0, i * INTERVAL, 600, i * 30);
            // vertical lines
            graphics.drawLine(i * INTERVAL, 0, i * INTERVAL, HEIGHT);
        }

        for (int i = snakeBodyList.size() - 1; i >= 0; i--) {
            snakeBodyList.get(i).draw(graphics);
        }
        snakeHead.draw(graphics);
        food.draw(graphics);

        GameUtils.drawString(graphics, score + "", Color.blue, 50, 650, 300);

        graphics.setColor(Color.gray);
        prompt(graphics);
    }

    private void prompt(final Graphics graphics) {
        if (state == 0) {
            graphics.fillRect(120, 240, 400, 70);
            GameUtils.drawString(graphics, "Press space to start", Color.yellow, 30, 150, 290);
        }
    }

    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }
}
