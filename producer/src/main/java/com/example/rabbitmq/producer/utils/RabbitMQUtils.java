package com.example.rabbitmq.producer.utils;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import java.io.IOException;

@Slf4j
public class RabbitMQUtils {
    public static void askMessage(Channel channel, long tag, final Logger logger) {
        askMessage(channel, tag, logger, false);
    }

    public static void askMessage(Channel channel, long tag, final Logger logger, boolean multiple) {
        try {
            channel.basicAck(tag, multiple);
        } catch (IOException e) {
            logger.error("RabbitMQ，IO异常，异常原因为：{}", e.getMessage());
        }
    }

    public static void rejectMessage(Channel channel, long tag, final Logger logger) {
        rejectMessage(channel, tag, logger, false, false);
    }

    public static void rejectAndBackMQ(Channel channel, long tag, final Logger logger) {
        rejectMessage(channel, tag, logger, false, true);
    }

    public static void rejectMessage(Channel channel, long tag, final Logger logger, boolean multiple, boolean request) {
        try {
            channel.basicNack(tag, multiple, request);
        } catch (IOException e) {
            logger.error("RabbitMQ，IO异常，异常原因为：{}", e.getMessage());
        }
    }
}
