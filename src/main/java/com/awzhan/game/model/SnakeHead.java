package com.awzhan.game.model;

import com.awzhan.game.GameWin;
import com.awzhan.game.util.GameUtils;
import lombok.Getter;
import lombok.Setter;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

@Getter
@Setter
public class SnakeHead extends Snake {
    private String direction = "right";

    public SnakeHead(Image image, int x, int y, GameWin gameWin) {
        super(image, x, y, gameWin);
        this.gameWin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                changeDirection(event);
            }
        });
    }

    private void changeDirection(KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (!"down".equalsIgnoreCase(direction)) {
                    direction = "up";
                    image = GameUtils.snakeHeadUp;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (!"up".equalsIgnoreCase(direction)) {
                    direction = "down";
                    image = GameUtils.snakeHeadDown;
                }
                break;
            case KeyEvent.VK_LEFT:
                if (!"right".equalsIgnoreCase(direction)) {
                    direction = "left";
                    image = GameUtils.snakeHeadLeft;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (!"left".equalsIgnoreCase(direction)) {
                    direction = "right";
                    image = GameUtils.snakeHeadRight;
                }
                break;
            default:
                break;
        }
    }

    public void move() {
        List<SnakeBody> snakeBodyList = this.gameWin.getSnakeBodyList();
        for (int i = snakeBodyList.size() - 1; i >= 1; i--) {
            snakeBodyList.get(i).x = snakeBodyList.get(i-1).x;
            snakeBodyList.get(i).y = snakeBodyList.get(i-1).y;
        }
        snakeBodyList.get(0).x = this.x;
        snakeBodyList.get(0).y = this.y;

        switch (direction) {
            case "up":
                y -= height;
                break;
            case "down":
                y += height;
                break;
            case "left":
                x -= width;
                break;
            case "right":
                x += width;
                break;
            default:
                break;
        }
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);

        Integer lastX = null;
        Integer lastY = null;
        final Food food = this.gameWin.getFood();
        if (this.x == food.x && this.y == food.y) {
            this.gameWin.setFood(Food.getFood(this.gameWin));

            final SnakeBody lastBody = this.gameWin.getSnakeBodyList().getLast();
            lastX = lastBody.getX();
            lastY = lastBody.getY();

            GameWin.score++;
        }

        if (GameWin.score >= 3) {
            GameWin.state = 4;
        }

        move();

        if (lastX != null && lastY != null) {
            this.gameWin.getSnakeBodyList().add(new SnakeBody(GameUtils.snakeBody, lastX, lastY, this.gameWin));
        }

        if (x < 0) {
            x = 570;
        } else if (x > 570) {
            x = 0;
        } else if (y < 30) {
            y = 570;
        } else if (y > 570) {
            y = 30;
        }
    }
}
