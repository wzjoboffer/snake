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
        for (int i = 1; i < snakeBodyList.size(); i++) {
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
        move();
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
