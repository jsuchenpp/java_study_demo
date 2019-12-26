package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * jdk1.8性特性：stream
 * @author chenpp 【chenpingping1@xiao100.com】
 * @date 2019年12月25日
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

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取列表元素平方数
        List<Integer> squaresList = getSquaresUsingJava7(numbers);
        log.info("获取列表元素平方数（Java7）：{}", squaresList);
        squaresList = getSquaresUsingJava8(numbers);
        log.info("获取列表元素平方数（Java8）：{}", squaresList);

        // 获取列表中最大的数
        List<Integer> integers = Arrays.asList(1, 2, 13, 4, 15, 6, 17, 8, 19);
        Integer maxElement = getMaxUsingJava7(integers);
        log.info("列表中最大的数（Java7）：{}", maxElement);
        maxElement = getMaxUsingJava8(integers);
        log.info("列表中最大的数（Java8）：{}", maxElement);

        // 获取列表中最小的数
        Integer minElement = getMinUsingJava7(integers);
        log.info("列表中最小的数（Java7）：{}", minElement);
        minElement = getMinUsingJava8(integers);
        log.info("列表中最小的数（Java8）：{}", minElement);

        // 计算列表中所有数的和
        Long sum = getSumUsingJava7(integers);
        log.info("列表中所有数的和（Java7）：{}", sum);
        sum = getSumUsingJava8(integers);
        log.info("列表中所有数的和（Java8）：{}", sum);

        // 计算列表中所有数的平均值
        Double avg = getAvgUsingJava7(integers);
        log.info("列表中所有数的平均值（Java7）：{}", avg);
        avg = getAvgUsingJava8(integers);
        log.info("列表中所有数的平均值（Java8）：{}", avg);
        
    }
    
    private static Double getAvgUsingJava7(List<Integer> list) {
        return (double)getSumUsingJava7(list) / list.size();
    }

    private static Double getAvgUsingJava8(List<Integer> list) {
        return list.stream().mapToInt(x -> x).summaryStatistics().getAverage();
    }

    private static Long getSumUsingJava7(List<Integer> list) {
        Long sum = 0L;
        for (Integer i : list) {
            sum += i;
        }
        return sum;
    }

    private static Long getSumUsingJava8(List<Integer> list) {
        return list.stream().mapToInt(x -> x).summaryStatistics().getSum();
    }

    private static Integer getMinUsingJava7(List<Integer> list) {
        Integer min = list.get(0);
        for (Integer i : list) {
            if (i.intValue() < min.intValue()) {
                min = i;
            }
        }
        return min;
    }

    private static Integer getMinUsingJava8(List<Integer> list) {
        return list.stream().mapToInt(x -> x).summaryStatistics().getMin();
    }

    private static Integer getMaxUsingJava7(List<Integer> list) {
        Integer max = list.get(0);
        for (Integer i : list) {
            if (i.intValue() > max.intValue()) {
                max = i;
            }
        }
        return max;
    }

    private static Integer getMaxUsingJava8(List<Integer> list) {
        return list.stream().mapToInt(x -> x).summaryStatistics().getMax();
    }

    private static List<Integer> getSquaresUsingJava7(List<Integer> list) {
        List<Integer> squaresList = new ArrayList<>();
        for (Integer number : list) {
            Integer square = number.intValue() * number.intValue();
            if (!squaresList.contains(square)) {
                squaresList.add(square);
            }
        }
        return squaresList;
    }

    private static List<Integer> getSquaresUsingJava8(List<Integer> list) {
        return list.stream().map(i -> i * i).distinct().collect(Collectors.toList());
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
        return list.stream().filter(String::isEmpty).count();
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
