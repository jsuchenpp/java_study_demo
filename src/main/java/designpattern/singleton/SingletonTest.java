package designpattern.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 单例模式使用场景：
 * 
 * 需要频繁的进行创建和销毁的对象；
 * 创建对象时耗时过多或耗费资源过多，但又经常用到的对象；
 * 工具类对象；
 * 频繁访问数据库或文件的对象。
 * 
 * 
 * 参考文档：
 * https://blog.csdn.net/qq_41458550/article/details/109243456
 * http://www.blogjava.net/kenzhh/archive/2013/03/15/357824.html
 * 
 * @Author chenpp【chenpingping1@xiao100.com】
 * @Date  2021年9月22日
 */
@Slf4j
public class SingletonTest {
    public static void main(String[] args) {
        testSingleton1();
        testSingleton2();
        testSingleton3();
        testSingleton4();
        testSingleton5();
        testSingleton6();
        testSingleton7();
        testSingleton8();
    }
    
    /**
     * 饿汉模式（静态成员变量)
     */
    private static void testSingleton1() {
        Singleton1 singleton1 = Singleton1.getSingleton();
        Singleton1 singleton2 = Singleton1.getSingleton();
       log.info("testSingleton1 result:{}", singleton1 == singleton2);
    }
    
    /**
     * 饿汉模式（静态代码块）
     */
    private static void testSingleton2() {
        Singleton2 singleton1 = Singleton2.getSingleton();
        Singleton2 singleton2 = Singleton2.getSingleton();
       log.info("testSingleton2 result:{}", singleton1 == singleton2);
    }
    
    /**
     * 懒汉模式 线程不安全
     */
    private static void testSingleton3() {
        Singleton3 singleton1 = Singleton3.getSingleton();
        Singleton3 singleton2 = Singleton3.getSingleton();
       log.info("testSingleton3 result:{}", singleton1 == singleton2);
    }
    
    /**
     * 懒汉模式(同步方法)
     */
    private static void testSingleton4() {
        Singleton4 singleton1 = Singleton4.getSingleton();
        Singleton4 singleton2 = Singleton4.getSingleton();
       log.info("testSingleton4 result:{}", singleton1 == singleton2);
    }
    
    /**
     * 懒汉模式(同步代码块)  线程不安全
     */
    private static void testSingleton5() {
        Singleton5 singleton1 = Singleton5.getSingleton();
        Singleton5 singleton2 = Singleton5.getSingleton();
       log.info("testSingleton5 result:{}", singleton1 == singleton2);
    }
    
    /**
     * 懒汉模式(双重检查)，推荐使用
     */
    private static void testSingleton6() {
        Singleton6 singleton1 = Singleton6.getSingleton();
        Singleton6 singleton2 = Singleton6.getSingleton();
       log.info("testSingleton6 result:{}", singleton1 == singleton2);
    } 
    
    /**
     * 懒汉模式(静态内部类)，推荐使用
     */
    private static void testSingleton7() {
        Singleton7 singleton1 = Singleton7.getSingleton();
        Singleton7 singleton2 = Singleton7.getSingleton();
       log.info("testSingleton7 result:{}", singleton1 == singleton2);
    }
    
    /**
     * 枚举，推荐使用
     */
    private static void testSingleton8() {
        Singleton8 singleton1 = Singleton8.INSTANCE;
        Singleton8 singleton2 = Singleton8.INSTANCE;
       log.info("testSingleton8 result:{}", singleton1 == singleton2);
    }
}
