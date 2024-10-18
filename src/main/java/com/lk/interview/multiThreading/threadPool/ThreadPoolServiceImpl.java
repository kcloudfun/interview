package com.lk.interview.multiThreading.threadPool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ThreadPoolServiceImpl implements IThreadPoolService {

    private static Logger logger = LoggerFactory.getLogger(ThreadPoolServiceImpl.class);

    @Override
    @Async
    public void doSomeThing() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        logger.info("Async 创建线程成功");
    }

    @Override
    @Async("taskExecutor")
    public void doSomeThing2() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        logger.info("Async 创建线程成功2");
    }
}
