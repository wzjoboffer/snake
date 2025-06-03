package com.awzhan.game.model;

import java.awt.Graphics;
import java.awt.Image;

import com.awzhan.game.GameWin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GameObject {
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
