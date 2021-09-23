package designpattern.singleton;

/**
 * 懒汉模式(静态内部类) 线程安全
 * 
 * 优点：线程安全，延迟加载
 *
 * @Author chenpp【chenpingping1@xiao100.com】
 * @Date  2021年9月22日
 */
public class Singleton7 {
    
    /**
     * 私有构造函数，不能使用new创建对象
     */
    private Singleton7() {
        
    }
    
    private static class SingletonInstance {
        private static final Singleton7 INSTANCE = new Singleton7();
    }
    
    public static Singleton7 getSingleton() {
        return SingletonInstance.INSTANCE;
    }
}
