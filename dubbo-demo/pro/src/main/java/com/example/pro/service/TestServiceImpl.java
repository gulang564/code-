package com.example.pro.service;



import com.study.service.TestService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;


@Component
@Service(version = "1.0.0",interfaceClass = TestService.class)

//@Service(version = "1.0.0")
public class TestServiceImpl implements TestService {
    @Override
    public void ins() {
        System.out.println("insert");
    }

    @Override
    public void del() {
        System.out.println("delete");
    }

    @Override
    public void upd() {
        System.out.println("update");
    }

    @Override
    public void sel() {
        System.out.println("select");
    }
}
