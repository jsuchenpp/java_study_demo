package designpattern.strategy;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 静态工厂类
 * 
 * @Author chenpp【chenpingping1@xiao100.com】
 * @Date 2021年9月24日
 */
public class SortStrategyFactory {

    public static SortStrategy getSortStrategy(String sortName) {
        String sortClassName = SortStrategyEnum.getSortClassName(sortName);
        if (Objects.isNull(sortClassName)) {
            return null;
        }

        try {
            return (SortStrategy)Class.forName(sortClassName).newInstance();
        } catch (Exception e) {
            return null;
        }
    }

    @Getter
    @AllArgsConstructor
    enum SortStrategyEnum {
        /**
         * 冒泡排序
         */
        BUBBLE_SORT("bubble_sort", "designpattern.strategy.BubbleSortStrategy"),
        /**
         * 计数排序
         */
        COUNT_SORT("count_sort", "designpattern.strategy.CountSortStrategy"),
        /**
         * 插入排序
         */
        INSERT_SORT("insert_sort", "designpattern.strategy.InsertSortStrategy"),;

        private String sortName;
        private String sortClassName;

        public static String getSortClassName(String sortName) {
            if (Objects.isNull(sortName)) {
                return null;
            }

            for (SortStrategyEnum e : values()) {
                if (Objects.equals(e.sortName, sortName)) {
                    return e.sortClassName;
                }
            }

            return null;
        }
    }
}
