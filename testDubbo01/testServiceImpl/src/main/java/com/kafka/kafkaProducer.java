package com.kafka;

import com.testKafka.KafkaConfig;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;

/**
 * @program: testDubbo01
 * @description:  kafka 生成者
 * @author: zhangshuai
 * @create: 2018-11-21 14:28
 **/
public class kafkaProducer extends Thread{

    private final String topic;
    private final Properties prop = new Properties();
    private final Producer<Integer, String> producer;
    public kafkaProducer(String topic){
        //配置key的序列化类
        prop.put("key.serializer.class", "kafka.serializer.StringEncoder");
        //配置value的序列化类
        prop.put("serializer.class","kafka.serializer.StringEncoder");
        //配置kafka端口
        prop.put("metadata.broker.list", KafkaConfig.kafkaServerUrl);
        producer = new Producer<>(new ProducerConfig(prop));
        this.topic=topic;
    }

    @Override
    public void run() {

        int messageNo = 1;

        while (true){
            //创建消息
            String messageStr = new String("Message_"+messageNo);
            System.out.println("Send:"+messageStr);
            //发送消息
            producer.send(new KeyedMessage<Integer, String>(topic,messageStr));
            messageNo++;
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
