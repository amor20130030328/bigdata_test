package com.gy.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CustomProducer_Test {

    public static void main(String[] args) {

        Properties properties = new Properties();
        //kafka集群，broker-list
        properties.put("bootstrap.servers","hadoop102:9092,hadoop103:9092,hadoop104:9092");
        //ACK应答级别
        properties.put("acks ","all");
        //重试次数
        properties.put("retries",1);
        //批次大小
        properties.put("batch.size",16384);
        //等待时间
        properties.put("linger.ms",1);
        //RecordAccumulator 缓冲区大小
        properties.put("buffer.memory",33554432);
        properties.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        for (int i = 0; i <10 ; i++) {
            Future<RecordMetadata> future = producer.send(new ProducerRecord<>("first", Integer.toString(i), Integer.toString(i)));

            try {
                RecordMetadata recordMetadata = future.get();
                System.out.println(recordMetadata.partition() + "---" + recordMetadata.offset());
            }  catch (Exception e) {
                e.printStackTrace();
            }
        }

        //关闭资源
        producer.close();

    }
}
