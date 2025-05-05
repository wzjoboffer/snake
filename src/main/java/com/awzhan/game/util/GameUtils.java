package com.awzhan.game.util;

import lombok.experimental.UtilityClass;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

@UtilityClass
public class GameUtils {

    public static Image snakeHeadUp = Toolkit.getDefaultToolkit().getImage("resources/images/snake_head_up.png");
    public static Image snakeHeadDown = Toolkit.getDefaultToolkit().getImage("resources/images/snake_head_down.png");
    public static Image snakeHeadLeft = Toolkit.getDefaultToolkit().getImage("resources/images/snake_head_left.png");
    public static Image snakeHeadRight = Toolkit.getDefaultToolkit().getImage("resources/images/snake_head_right.png");

    public static Image snakeBody = Toolkit.getDefaultToolkit().getImage("resources/images/snake_body.png");

    public static Image food = Toolkit.getDefaultToolkit().getImage("resources/images/food.png");

    public static void drawString(Graphics graphics, String str, Color color, int size, int x, int y) {
        graphics.setColor(color);
        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, size));
        graphics.drawString(str, x, y);
    }
}
