package com.demo.pdsys.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author MrLi2019
 * 验证码工具类
 */
public class CaptchaUtils {


    public static String drawCaptcha(int width, int height, BufferedImage bufferedImage,int lines) {
        Graphics2D graphics2D = (Graphics2D) bufferedImage.getGraphics();
        //画笔颜色
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, width, height);
        graphics2D.setFont(new Font("微软雅黑", Font.BOLD, 40));
        String baseEums = "123456789abcdefghijklmnopqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ";
        StringBuilder stringBuilder = new StringBuilder();
        int x = 10;
        String ch = "";
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            graphics2D.setColor(getRandomColor());
            //设置字体旋转角度

            int degree = random.nextInt() % 30;  //角度小于30度

            int dot = random.nextInt(baseEums.length());

            ch = baseEums.charAt(dot) + "";

            stringBuilder.append(ch);

            //正向旋转

            graphics2D.rotate(degree * Math.PI / 180, x, 45);

            graphics2D.drawString(ch, x, 45);

            //反向旋转

            graphics2D.rotate(-degree * Math.PI / 180, x, 45);

            x += 48;

        }
        //画干扰线

        for (int i = 0; i < 6+lines; i++) {

            // 设置随机颜色

            graphics2D.setColor(getRandomColor());

            // 随机画线

            graphics2D.drawLine(random.nextInt(width), random.nextInt(height),

                    random.nextInt(width), random.nextInt(height));

        }

        //添加噪点

        for (int i = 0; i < 30; i++) {

            int x1 = random.nextInt(width);

            int y1 = random.nextInt(height);

            graphics2D.setColor(getRandomColor());

            graphics2D.fillRect(x1, y1, 2, 2);

        }

        return stringBuilder.toString();

    }

    /**
     * 随机取色
     */

    private static Color getRandomColor() {

        Random ran = new Random();

        return new Color(ran.nextInt(256),

                ran.nextInt(256), ran.nextInt(256));

    }
}
