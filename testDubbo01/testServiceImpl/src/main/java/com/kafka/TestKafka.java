package com.kafka;

import com.testKafka.KafkaConfig;

/**
 * @program: testDubbo01
 * @description:  简单测试kafka
 * @author: zhangshuai
 * @create: 2018-11-22 09:59
 **/
public class TestKafka {

    public static void main(String[] args) {

        kafkaProducer kafkaProducer = new kafkaProducer(KafkaConfig.topic);
        kafkaProducer.start();
        kafkaConsumer kafkaConsumer = new kafkaConsumer(KafkaConfig.topic);
        kafkaConsumer.start();

    }

}
