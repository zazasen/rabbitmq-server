package com.cyrus.rabbitmqserver.receiver;

import com.alibaba.fastjson.JSONObject;
import com.cyrus.final_job.entity.system.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@Component
public class MailReceiver {

    private static Logger logger = LoggerFactory.getLogger(MailReceiver.class);


    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private MailProperties mailProperties;

    @Autowired
    private TemplateEngine templateEngine;

    @RabbitListener(queues = "cyrus.mail.welcome")//监听对象
    public void handler(User user) {
        // 收到消息，发送邮件
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg);
        try {
            helper.setSubject("欢迎加入某不知名公司");
            Context context = new Context();
            context.setVariable("realName", user.getRealName());
            String process = templateEngine.process("welcome.html", context);
            helper.setText(process, true);
            // 谁发送的
            helper.setFrom(mailProperties.getUsername());
            helper.setSentDate(new Date());
            // 发送给谁
            helper.setTo(user.getEmail());
            javaMailSender.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
            logger.error("邮件发送失败");
        }
    }

}
