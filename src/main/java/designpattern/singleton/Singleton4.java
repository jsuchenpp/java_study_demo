package designpattern.singleton;

/**
 * 懒汉模式(同步方法) 线程安全
 * 
 * 缺点：效率太低了，每个线程在想获得类的实例时候，执行getInstance()方法都要进行同步。
 * 而其实这个方法只执行一次实例化代码就够了，后面的想获得该类实例，直接return就行了
 *
 * @Author chenpp【chenpingping1@xiao100.com】
 * @Date  2021年9月22日
 */
public class Singleton4 {
    
    private static Singleton4 singleton;
    
    /**
     * 私有构造函数，不能使用new创建对象
     */
    private Singleton4() {
        
    }
    
    public static synchronized Singleton4 getSingleton() {
        if(singleton == null) {
            singleton = new Singleton4();
        }
        return singleton;
    }
}
