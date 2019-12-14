package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        // 获取字符串长度为3的数量
        count = getCountLength3UsingJava7(strings);
        log.info("字符串长度为3的数量为（Java7）：{}", count);
        count = getCountLength3UsingJava8(strings);
        log.info("字符串长度为3的数量为（Java8）：{}", count);

        // 删除空字符串
        List<String> filtered = deleteEmptyStringsUsingJava7(strings);
        log.info("删除空字符串后的列表（Java7）：{}", filtered);
        filtered = deleteEmptyStringsUsingJava8(strings);
        log.info("删除空字符串后的列表（Java8）：{}", filtered);

        // 删除空字符串，并使用逗号把它们合并起来
        String mergedString = getDeleteEmptyStringAndMergedStringUsingJava7(strings, ", ");
        log.info("删除空字符串，并使用逗号把它们合并起来（Java7）：{}", mergedString);
        mergedString = getDeleteEmptyStringAndMergedStringUsingJava8(strings, ", ");
        log.info("删除空字符串，并使用逗号把它们合并起来（Java8）：{}", mergedString);
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
        return list.stream().filter(str -> str.isEmpty()).count();
    }

    private static long getCountLength3UsingJava7(List<String> list) {
        long count = 0L;
        for (String string : list) {
            if (string.length() == 3) {
                count++;
            }
        }
        return count;
    }

    private static long getCountLength3UsingJava8(List<String> list) {
        return list.stream().filter(str -> str.length() == 3).count();
    }

    private static List<String> deleteEmptyStringsUsingJava7(List<String> list) {
        List<String> filterList = new ArrayList<>();
        for (String string : list) {
            if (!string.isEmpty()) {
                filterList.add(string);
            }
        }
        return filterList;
    }

    private static List<String> deleteEmptyStringsUsingJava8(List<String> list) {
        return list.stream().filter(str -> !str.isEmpty()).collect(Collectors.toList());
    }

    private static String getDeleteEmptyStringAndMergedStringUsingJava7(List<String> list, String separator) {
        // 过滤空字符串
        List<String> filterList = new ArrayList<>();
        for (String string : list) {
            if (!string.isEmpty()) {
                filterList.add(string);
            }
        }

        // 使用symbol拼接
        StringBuilder builder = new StringBuilder();
        for (String string : filterList) {
            builder.append(string).append(separator);
        }
        String mergedString = builder.toString();
        return mergedString.substring(0, mergedString.length() - separator.length());
    }

    private static String getDeleteEmptyStringAndMergedStringUsingJava8(List<String> list, String separator) {
        return list.stream().filter(str -> !str.isEmpty()).collect(Collectors.joining(separator));
    }
}
