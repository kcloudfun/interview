package com.lk.interview.multiThreading.threadPool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executor;

/**
 * 线程池参数探究。
 * 这里给RestController指定了value，是给类起个别名，定义为A仅仅是为了文件排在前面，但不想直接向spring注册为A。
 * 线程池工作流程：
 * 第1步.初始线程数为0；
 * 第2步.来一个线程任务，创建一条线程；
 * 第3步.又来了一个新的线程任务，若核心线程数为1，则会看前面线程是否已执行完，若执行完则复用已创建好线程，若核心线程数为2，则不论前面线程是否已执行完，都会重新创建线程，以达到快速建满核心线程数；
 * 第4步，若来的线程过多，核心线程无法够用，则继续创建线程，直到达到最大线程数；
 * 第5步，若来的线程实在太多，最大线程数也不够用了，则多出最大线程数的部分进入队列；
 * 第6步，若来的线程队列都放不下了，则超出队列部分执行失败策略。
 * 第7步，若线程池空闲下来了，即任务都执行完了，则判断是否有线程达到配置的空闲时间，有的话就销毁一部分线程，直到数量降为核心线程数，核心线程数也是线程池维护的最低线程数，会一直保持。
 */
@RestController(value = "threadPoolConfigTest")
public class A {

    private static Logger logger = LoggerFactory.getLogger(A.class);

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private IThreadPoolService threadPoolService;

    /**
     * 这里采用主动获取线程池对象，然后执行线程的方式，实际还有更简单，和框架结合更紧密的方式（也就是使用@Async注解）
     * @return
     */
    @GetMapping("/threadPool/start")
    public String startThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("线程执行了");
            }
        });

        Executor taskExecutor = applicationContext.getBean("taskExecutor", Executor.class);
        taskExecutor.execute(thread);
        return "success";
    }

    /**
     * 使用@Async方式开启异步：只需在目标方法或目标类上标上@Async，同时在主类上标上@EnableAsync，即可实现异步。
     * 默认就会使用已配置好的线程池，若有多个，可通过给@Async指定value来指定线程池。
     * 这种写法相对上面更简洁更贴合实际。
     * @return
     */
    @GetMapping("/threadPool/start2")
    public String startThread2() {
        threadPoolService.doSomeThing();
        threadPoolService.doSomeThing2();
        threadPoolService.doSomeThing();
        threadPoolService.doSomeThing2();

        //当前配置最大线程4，队列6.也就是最多10.此方法一次产生4线程，则调用3次时会进入拒绝策略。
        return "success2";
    }

}
