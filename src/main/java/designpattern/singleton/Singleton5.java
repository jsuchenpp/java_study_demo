package designpattern.singleton;

/**
 * 懒汉模式(同步代码块) 线程不安全
 * 
 * 缺点：假如一个线程进入了if (singleton == null)判断语句块，还未来得及往下执行，
 * 另一个线程也通过了这个判断语句，这时便会产生多个实例
 *
 * @Author chenpp【chenpingping1@xiao100.com】
 * @Date  2021年9月22日
 */
public class Singleton5 {
    
    private static Singleton5 singleton;
    
    /**
     * 私有构造函数，不能使用new创建对象
     */
    private Singleton5() {
        
    }
    
    public static Singleton5 getSingleton() {
        if(singleton == null) {
            synchronized (Singleton5.class) {
                singleton = new Singleton5();
            }
        }
        return singleton;
    }
}
