package com.cyrus.rabbitmqserver;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitmqServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqServerApplication.class, args);
    }

    // 消息队列
    @Bean
    Queue queue() {
        return new Queue("cyrus.mail.welcome");
    }
}
