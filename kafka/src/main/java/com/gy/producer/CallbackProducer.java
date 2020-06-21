package com.gy.producer;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class CallbackProducer {

    public static void main(String[] args) {

        //1.创建配置信息
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"hadoop102:9092,hadoop103:9092,hadoop104:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");

        //重试次数
        properties.put("retries",1);
        //批次大小
        properties.put("batch.size",16384);
        //等待时间
        properties.put("linger.ms",1);
        properties.put("enable.auto.commit", "true");

        KafkaProducer<String,String> producer = new KafkaProducer<>(properties);

        for (int i = 0; i < 10; i++) {
            //String topic, Integer partition, K key, V value    , 若指定  partition  或 key  都会只到一个分区
            producer.send(new ProducerRecord<>("first", 0,"amor","atguigu" + i), (recordMetadata, e) -> {
                if(e == null){
                    System.out.println(recordMetadata.partition() + "---" + recordMetadata.offset());
                }else{
                    System.out.println("发送失败" + e.getMessage());
                }
            });

        }

       producer.close();



    }
}
