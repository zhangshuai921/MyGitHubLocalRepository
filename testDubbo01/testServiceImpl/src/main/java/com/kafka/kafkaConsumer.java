package com.kafka;

import com.testKafka.KafkaConfig;
import kafka.Kafka;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @program: testDubbo01
 * @description:  kafka 消费者
 * @author: zhangshuai
 * @create: 2018-11-22 09:33
 **/
public class kafkaConsumer extends Thread{

    private final String topic;

    private final ConsumerConnector consumer;

    public kafkaConsumer (String topic){
         consumer = Consumer.createJavaConsumerConnector(createConsumerConfig());
         this.topic=topic;
    }

    public static ConsumerConfig createConsumerConfig(){
        Properties prop = new Properties();
        prop.put("zookeeper.connect", KafkaConfig.zkConnect);
        prop.put("group.id", KafkaConfig.groupId);
        prop.put("zookeeper.session.timeout.ms","40000");
        prop.put("zookeeper.sync.time.ms","200");
        prop.put("auto.commit.interval.ms","1000");
        return new ConsumerConfig(prop);
    }

    @Override
    public void run() {
        Map<String,Integer> topicCountMap = new HashMap<String,Integer>();
        topicCountMap.put(topic,new Integer(1));
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
        KafkaStream<byte[], byte[]> stream = consumerMap.get(topic).get(0);
        ConsumerIterator<byte[], byte[]> it = stream.iterator();
        while (it.hasNext()){
            System.out.println("receive:"+new String(it.next().message()));
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
