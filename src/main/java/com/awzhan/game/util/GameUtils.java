package com.awzhan.game.util;

import lombok.experimental.UtilityClass;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

@UtilityClass
public class GameUtils {
    public static final Image snakeHeadUp = getImage("images/snake_head_up.png");
    public static final Image snakeHeadDown = getImage("images/snake_head_down.png");
    public static final Image snakeHeadLeft = getImage("images/snake_head_left.png");
    public static final Image snakeHeadRight = getImage("images/snake_head_right.png");

    public static final Image snakeBody = getImage("images/snake_body.png");

    public static final Image food = getImage("images/food.png");

    public static int level = 1;

    private static Image getImage(final String resourcePath) {
        final URL imageUrl = GameUtils.class.getClassLoader().getResource(resourcePath);
        return Toolkit.getDefaultToolkit().getImage(imageUrl);
    }

    public static void drawString(Graphics graphics, String str, Color color, int size, int x, int y) {
        graphics.setColor(color);
        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, size));
        graphics.drawString(str, x, y);
    }
}
