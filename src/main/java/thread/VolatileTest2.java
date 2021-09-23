package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import lombok.extern.slf4j.Slf4j;

/**
 * volatile
 * 
 * 参考文档：
 * 
 * https://blog.csdn.net/u012723673/article/details/80682208
 *
 * @Author chenpp【chenpingping1@xiao100.com】
 * @Date  2021年9月23日
 */
@Slf4j
public class VolatileTest2 {
    
    public int inc = 0;
    
    Lock lock = new ReentrantLock();
    
    public void increase() {
        lock.lock();
        try {
            inc++;
        } finally {
            lock.unlock();
        }
    }
    
    public static void main(String[] args) {
        final VolatileTest2 test = new VolatileTest2();
        
        for(int i=0; i<10; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        test.increase();
                    }
                }
            }.start();
        }
        
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        
        // 结果是10000
        log.info("result:{}", test.inc);
    }
}
