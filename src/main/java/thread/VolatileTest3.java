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
public class VolatileTest3 {
    
    public int inc = 0;
    
    public synchronized void increase() {
        inc++;
    }
    
    public static void main(String[] args) {
        final VolatileTest3 test = new VolatileTest3();
        
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
