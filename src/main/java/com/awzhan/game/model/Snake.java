package com.awzhan.game.model;

import com.awzhan.game.GameWin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.Graphics;
import java.awt.Image;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Snake {
    private final int width = 30;
    private final int height = 30;

    private Image image;
    private int x;
    private int y;
    private GameWin gameWin;

    public void draw(Graphics graphics) {
        graphics.drawImage(image, x, y, null);
    }
}
