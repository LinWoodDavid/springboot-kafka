package com.david;

import com.david.kafka.KafkaSender;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashMap;

public class Demo extends KafkaApplicationTests {

    @Resource
    private KafkaSender<String> kafkaSender;

    @Test
    public void kafkaSend() throws InterruptedException {
        //模拟发消息
        for (int i = 0; i < 5; i++) {
            HashMap<String, String> map = new HashMap<>();
            map.put(String.valueOf(i), "message" + i);
            kafkaSender.send("message" + i);
            map.clear();
            Thread.sleep(3000);

        }
    }


}
