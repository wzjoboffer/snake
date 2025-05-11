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
    public static final Image snakeHeadUp = getImage(getResourceUrl("images/snake_head_up.png"));
    public static final Image snakeHeadDown = getImage(getResourceUrl("images/snake_head_down.png"));
    public static final Image snakeHeadLeft = getImage(getResourceUrl("images/snake_head_left.png"));
    public static final Image snakeHeadRight = getImage(getResourceUrl("images/snake_head_right.png"));

    public static final Image snakeBody = getImage(getResourceUrl("images/snake_body.png"));

    public static final Image food = getImage(getResourceUrl("images/food.png"));

    private static Image getImage(final URL imageUrl) {
        return Toolkit.getDefaultToolkit().getImage(imageUrl);
    }

    private static URL getResourceUrl(final String resourcePath) {
        return GameUtils.class.getClassLoader().getResource(resourcePath);
    }

    public static void drawString(Graphics graphics, String str, Color color, int size, int x, int y) {
        graphics.setColor(color);
        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, size));
        graphics.drawString(str, x, y);
    }
}
