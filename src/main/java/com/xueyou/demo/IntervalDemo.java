package com.xueyou.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * Created by wuxueyou on 2017/6/2.
 */
public class IntervalDemo {
    private static Logger logger = LoggerFactory.getLogger(IntervalDemo.class);
    private static int count = 6;

    public static void intervalTimer() {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(checkValidate(), 0, 2, TimeUnit.SECONDS);
    }

    public static Runnable checkValidate() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                logger.info("this is log info");
                try {
                    double res = 10 / --count;
                    logger.info(String.valueOf(count));
                } catch (Exception e) {
                    e.printStackTrace();
                    count = 6;
                } finally {
                }
            }
        };
        return runnable;
    }
}
