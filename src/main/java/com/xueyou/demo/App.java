package com.xueyou.demo;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import dto.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */

public class App {
    private static Logger logger = LoggerFactory.getLogger(App.class);

    private static RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        IntervalDemo.intervalTimer();
    }

    public void doLog() {
        logger.debug("this is a test debug");

        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);

    }

    public void testRestHttpRequest() {
        //get方式
//        Student student = restTemplate.getForObject("http://localhost:8080/test/greeting2?id=10&name=xueyou", Student.class);
//        logger.info(student.toString());
        //post方式
        MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("id", "10");
        requestParams.add("name", "xueyou");
        Student student2 = restTemplate.postForObject("http://localhost:8080/test/greeting2", requestParams, Student.class);
        logger.info(student2.toString());
    }
}
