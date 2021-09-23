package designpattern.singleton;

/**
 * 懒汉模式(双重检查) 线程安全
 * 
 * 优点：线程安全；延迟加载
 * 
 * @Author chenpp【chenpingping1@xiao100.com】
 * @Date  2021年9月22日
 */
public class Singleton6 {
    
    /**
     * 为什么要加volatile?
     * 
     * 参考文档：
     * https://blog.csdn.net/u012723673/article/details/80682208
     */
    private static volatile Singleton6 singleton;
    
    /**
     * 私有构造函数，不能使用new创建对象
     */
    private Singleton6() {
        
    }
    
    public static Singleton6 getSingleton() {
        if(singleton == null) {
            synchronized (Singleton6.class) {
                if(singleton == null) {
                    singleton = new Singleton6();
                }
            }
        }
        return singleton;
    }
}
