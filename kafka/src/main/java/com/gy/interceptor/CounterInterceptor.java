package com.gy.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

public class CounterInterceptor implements ProducerInterceptor<String,String> {

    private int success = 0;
    private int error = 0;

    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> record) {
        //1.取出数据
       return record;
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
        if (metadata != null) success ++;
        else error++;
    }

    @Override
    public void close() {
        System.out.println("成功次数:" + success);
        System.out.println("失败次数:" + error);
    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
