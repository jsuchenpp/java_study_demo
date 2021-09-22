package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @Author chenpp【chenpingping1@xiao100.com】
 * @Date  2020年12月24日
 */
public class ListTester {
    
    public static void main(String[] args) {
//        rightUse();
        wrongUse();
    }
    
    private static void wrongUse() {
        List<String> list = Arrays.asList("Java8", "Java9", "Java10");
        // 会报错，为啥？ Arrays.asList返回的ArrayList是Arrays的静态内部类，没有add方法
        // 参考资料：https://www.jianshu.com/p/2b113f487e5e
        list.add("Java 11");
        System.out.println(list);
    }
    
    private static void rightUse() {
        List<String> list = new ArrayList<>(Arrays.asList("Java8", "Java9", "Java10"));
        list.add("Java 11");
        System.out.println(list);
    }
}
