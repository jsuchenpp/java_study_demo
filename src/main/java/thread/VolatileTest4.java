package thread;

import java.util.concurrent.atomic.AtomicInteger;

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
public class VolatileTest4 {
    
    public AtomicInteger inc = new AtomicInteger();
    
    public void increase() {
        inc.getAndIncrement();
    }
    
    public static void main(String[] args) {
        final VolatileTest4 test = new VolatileTest4();
        
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
