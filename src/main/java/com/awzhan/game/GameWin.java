package com.awzhan.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

import com.awzhan.game.model.Food;
import com.awzhan.game.model.SnakeBody;
import com.awzhan.game.model.SnakeHead;
import com.awzhan.game.util.GameUtils;

import lombok.Getter;
import lombok.Setter;

public class GameWin extends JFrame {
    private static final String TITLE = "Snake Game";
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int INTERVAL = 30;

    public static int state = 0;
    public int score = 0;

    private final SnakeHead snakeHead;
    @Getter
    private final List<SnakeBody> snakeBodyList;
    @Getter @Setter
    private Food food;

    private Image cacheImage = null;

    public GameWin() {
        this.snakeHead = new SnakeHead(GameUtils.snakeHeadRight, 60, 570, this);
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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.VK_SPACE) {
                    switch (state) {
                        case 0:
                            state = 1;
                            break;
                        case 1:
                            state = 2;
                            repaint();
                            break;
                        case 2:
                            state = 1;
                            break;
                        case 3:
                            state = 5;
                            break;
                        case 4:
                            state = 6;
                            break;
                        default:
                            break;
                    }
                }
            }
        });

        while (true) {
            if (state == 1) {
                repaint();
            }
            if (state == 5) {
                state = 0;
                reset();
            }
            if (state == 6 && GameUtils.level < 3) {
                state = 1;
                GameUtils.level++;
                reset();
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
        if (this.cacheImage == null) {
            this.cacheImage = createImage(WIDTH, HEIGHT);
        }
        Graphics cacheGraphics = cacheImage.getGraphics();

        cacheGraphics.setColor(Color.GRAY);
        cacheGraphics.fillRect(0, 0, WIDTH, HEIGHT);

        cacheGraphics.setColor(Color.black);
        for (int i = 0; i <= 20; i++) {
            // horizontal lines
            cacheGraphics.drawLine(0, i * INTERVAL, 600, i * 30);
            // vertical lines
            cacheGraphics.drawLine(i * INTERVAL, 0, i * INTERVAL, HEIGHT);
        }

        for (int i = snakeBodyList.size() - 1; i >= 0; i--) {
            snakeBodyList.get(i).draw(cacheGraphics);
        }
        snakeHead.draw(cacheGraphics);
        food.draw(cacheGraphics);

        GameUtils.drawString(cacheGraphics, "Level " + GameUtils.level, Color.ORANGE, 40, 650, 260);

        GameUtils.drawString(cacheGraphics, score + "", Color.blue, 50, 650, 330);

        cacheGraphics.setColor(Color.gray);
        prompt(cacheGraphics);

        graphics.drawImage(cacheImage, 0, 0, null);
    }

    private void prompt(final Graphics graphics) {
        if (state == 0) {
            graphics.fillRect(120, 240, 400, 70);
            GameUtils.drawString(graphics, "Press space to start", Color.yellow, 30, 150, 290);
        }
        else if (state == 2) {
            graphics.fillRect(120, 240, 400, 70);
            GameUtils.drawString(graphics, "Press space to resume", Color.yellow, 30, 150, 290);
        }
        else if (state == 3) {
            graphics.fillRect(120, 240, 400, 70);
            GameUtils.drawString(graphics, "Eat yourself", Color.red, 30, 150, 290);
        }
        else if (state == 4) {
            graphics.fillRect(120, 240, 400, 70);
            if (GameUtils.level == 3) {
                GameUtils.drawString(graphics, "All Completed", Color.green, 30, 150, 290);
            } else {
                GameUtils.drawString(graphics, "Completed", Color.green, 30, 150, 290);
            }
        }
    }

    private void reset() {
        this.dispose();
        start();
    }

    private void start() {
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }

    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }
}
