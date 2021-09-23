package designpattern.singleton;

/**
 * 饿汉模式（静态成员变量） 线程安全
 * 
 * 优点：类装载完成实例化，避免线程同步问题
 * 
 * 缺点：没有达到lazy loading的效果
 *
 * @Author chenpp【chenpingping1@xiao100.com】
 * @Date  2021年9月22日
 */
public class Singleton1 {
    
    private static final Singleton1 SINGLETON = new Singleton1();
    
    /**
     * 私有构造函数，不能使用new创建对象
     */
    private Singleton1() {
        
    }
    
    public static Singleton1 getSingleton() {
        return SINGLETON;
    }
}
