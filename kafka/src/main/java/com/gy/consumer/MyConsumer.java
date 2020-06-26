package com.gy.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Arrays;
import java.util.Properties;

public class MyConsumer {

    public static void main(String[] args) {

        //1.创建消费者配置信息
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"hadoop102:9092,hadoop103:9092,hadoop104:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        //消费者组
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"atguigu0408");

        //重置消费者的offset
        //properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");   //重新消费的前提是，消费者组之前没有消费过，  或者之前保留的offset过期了

        //开启自动提交
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,true);
        //自动提交的延迟
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,"1000");
        KafkaConsumer<String,String> consumer = new KafkaConsumer<>(properties);

        //订阅主题
        consumer.subscribe(Arrays.asList("first","second"));
        //获取数据
        while (true){
            ConsumerRecords<String, String> consumerRecords = consumer.poll(100);
            //解析并打印consumerRecords
            for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                System.out.println(consumerRecord.key() +" ---hahahha-- " + consumerRecord.value() + "=====" );
            }
        }



        //关闭连接
        //consumer.close();

    }

}
