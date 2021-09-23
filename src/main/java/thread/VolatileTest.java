package thread;

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
public class VolatileTest {
    
    public volatile int inc = 0;
    
    /**
     * inc++不是原子性操作，由读取、加、赋值3步操作组成
     */
    public void increase() {
        inc++;
    }
    
    public static void main(String[] args) {
        final VolatileTest test = new VolatileTest();
        
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
        
        // 结果不一定是10000 为什么？
        log.info("result:{}", test.inc);
    }
}
