package stream;

import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * <p>
 * jdk1.8性特性：stream
 * </p>
 * All rights Reserved, Designed www.xiao100.com
 * 
 * @author chenpp 【chenpingping1@xiao100.com】
 * @date 2019年12月14日
 */
@Slf4j
public class StreamTester {

    public static void main(String[] args) {

        // 计算空字符串
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        log.info("列表：{}", strings);
        long count = getCountEmptyStringUsingJava7(strings);
        log.info("空字符数量为（Java7）：{}", count);
        count = getCountEmptyStringUsingJava8(strings);
        log.info("空字符数量为（Java8）：{}", count);

    }

    private static long getCountEmptyStringUsingJava7(List<String> list) {
        long count = 0L;
        for (String string : list) {
            if (string.isEmpty()) {
                count++;
            }
        }
        return count;
    }

    private static long getCountEmptyStringUsingJava8(List<String> list) {
        return list.stream().filter(string -> string.isEmpty()).count();
    }

}
