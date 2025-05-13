package com.awzhan.game.model;

import com.awzhan.game.GameWin;

import java.awt.Graphics;
import java.awt.Image;

public class SnakeBody extends Snake {

    public SnakeBody(Image image, int x, int y, GameWin gameWin) {
        super(image, x, y, gameWin);
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
    }
}
