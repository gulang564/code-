package com.test.jwtapplication;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SpringBootTest
class JwtApplicationTests {

    @Test
    void contextLoads() {
        Gson gson=new Gson();
        Map map=new HashMap();
        map.put("key1","string1");
        map.put("key2","string2");
        String s = gson.toJson(map);
        System.out.println(s);

        Map map1 = gson.fromJson(s, Map.class);

        map1.forEach((k,v)->{
            System.out.println(k+"-----------"+v);
        });
    }

}
