package com.awzhan.game.model;

import com.awzhan.game.GameWin;
import lombok.Getter;
import lombok.Setter;

import java.awt.Graphics;
import java.awt.Image;

@Getter
@Setter
public class SnakeHead extends Snake {
    private String direction = "right";

    public SnakeHead(Image image, int x, int y, GameWin gameWin) {
        super(image, x, y, gameWin);
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
    }
}
