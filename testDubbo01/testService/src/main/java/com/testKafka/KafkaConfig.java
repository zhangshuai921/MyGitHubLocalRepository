package com.testKafka;

/**
 * @program: testDubbo01
 * @description:  kafka  基本属性配置接口
 * @author: zhangshuai
 * @create: 2018-11-21 14:15
 **/
public interface KafkaConfig {

    //zookeeper 连接地址
    final static String zkConnect = "192.168.116.128:2181";
    //consumer 分组
    final static String groupId = "group1";
    //主题1
    final static String topic = "my-replicated-topic";
    //主题2
    final static String topic2 = "topic2";
    //主题3
    final static String topic3 = "topic3";
    //kafka 连接地址
    final static String kafkaServerUrl = "192.168.116.128:9093";
    //producer 缓存区size
    final static int kafkaProducerBufferSize = 64*1024;
    //连接超时时间
    final static int connectionTimeOut = 20000;

    final static int reconnectInterval = 10000;

    final static String clientId = "SimpleConsumerDemoClient";
}
