package com.awzhan.game.model;

import com.awzhan.game.GameWin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.Graphics;
import java.awt.Image;

@Getter
@Setter
@AllArgsConstructor
public class Snake {
    protected final int width = 30;
    protected final int height = 30;

    protected Image image;
    protected int x;
    protected int y;
    protected GameWin gameWin;

    public void draw(Graphics graphics) {
        graphics.drawImage(image, x, y, null);
    }
}
