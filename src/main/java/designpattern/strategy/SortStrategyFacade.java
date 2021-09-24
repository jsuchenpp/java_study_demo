package designpattern.strategy;

import java.util.Objects;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @Author chenpp【chenpingping1@xiao100.com】
 * @Date  2021年9月24日
 */
@Slf4j
public class SortStrategyFacade {
    
    public static void sort(String sortName, int[] arr) {
        SortStrategy sortStrategy = SortStrategyFactory.getSortStrategy(sortName);
        if(Objects.isNull(sortStrategy)) {
            log.info("不存在的排序算法，sortName:{}", sortName);
        } else {
            log.info("排序前：{}", arr);
            int[] result = sortStrategy.sort(arr);
            log.info("排序后：{}", result);
        }
    }
    
}
