package com.awzhan.game.model;

import java.awt.Graphics;
import java.awt.Image;

import com.awzhan.game.GameWin;

public class SnakeBody extends GameObject {

    public SnakeBody(Image image, int x, int y, GameWin gameWin) {
        super(image, x, y, gameWin);
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
    }
}
