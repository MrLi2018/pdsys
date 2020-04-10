package com.demo.pdsys.controller;

import com.demo.pdsys.component.RedisClient;
import com.demo.pdsys.utils.CaptchaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 验证码请求处理类
 */
@Controller
public class CaptchaController {

    @Autowired
    private RedisClient redisUtils;

    @GetMapping("/captcha")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) {
        int width = 200;
        int height = 69;
        String count = request.getParameter("count");
        int lines = 0;
        if (count != null && !"".equals(count)) {
            try {
                lines = Integer.parseInt(count);
            } catch (Exception m) {
                lines = 1;
            }
        }
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        String text = CaptchaUtils.drawCaptcha(width, height, bufferedImage, lines);
        redisUtils.set(("ip_"+request.getRemoteHost()+"_captcha").replaceAll(":","."),text.trim().toLowerCase(),5L);
        response.setContentType("image/png");
        try {
            OutputStream outputStream = response.getOutputStream();
            ImageIO.write(bufferedImage, "png", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
