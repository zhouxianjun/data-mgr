package com.alone.common.util;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-10 下午8:45
 */
@Slf4j
public class TimeOutThreadPoolExecutor extends ThreadPoolExecutor {
    @Setter
    private long timeOut;
    @Setter
    private TimeUnit timeOutUnit;
    public TimeOutThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public TimeOutThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public TimeOutThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public TimeOutThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    public TimeOutThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, long timeOut, TimeUnit timeOutUnit) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        this.timeOut = timeOut;
        this.timeOutUnit = timeOutUnit;
    }

    @Override
    public void execute(Runnable command) {
        if (timeOut <= 0) {
            super.execute(command);
            return;
        }
        RunnableFuture<Void> future = newTaskFor(command, null);
        super.execute(future);
        boolean out = false;
        try {
            // 等待计算结果，最长等待timeout秒，timeout秒后中止任务
            future.get(timeOut, timeOutUnit);
        } catch (InterruptedException e) {
            log.error("主线程在等待计算结果时被中断！", e);
            out = true;
        } catch (ExecutionException e) {
            log.error("主线程等待计算结果，但计算抛出异常！", e);
            out = true;
        } catch (TimeoutException e) {
            log.error("主线程等待计算结果超时，因此中断任务线程！", e);
            out = true;
        }

        if (out) {
            future.cancel(true);
            getRejectedExecutionHandler().rejectedExecution(command, this);
        }
    }
}
