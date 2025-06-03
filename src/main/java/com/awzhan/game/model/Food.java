package com.awzhan.game.model;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import com.awzhan.game.GameWin;
import com.awzhan.game.util.GameUtils;

public class Food extends GameObject {
    private static final Random RANDOM = new Random();

    public Food(Image image, int x, int y, GameWin gameWin) {
        super(image, x, y, gameWin);
    }

    public static Food getFood(GameWin gameWin) {
        int x = RANDOM.nextInt(20) * 30;
        int y = (RANDOM.nextInt(19) + 1) * 30;
        return new Food(GameUtils.food, x, y, gameWin);
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
    }
}
