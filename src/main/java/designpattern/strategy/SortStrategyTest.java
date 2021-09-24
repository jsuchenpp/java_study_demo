package designpattern.strategy;

import designpattern.strategy.SortStrategyFactory.SortStrategyEnum;

/**
 *
 * @Author chenpp【chenpingping1@xiao100.com】
 * @Date  2021年9月24日
 */
public class SortStrategyTest {
    
    public static void main(String[] args) {
        int arr[] = {12, 1, 3, 46, 5, 0, -3, 12, 35, 16};
//        SortStrategyFacade.sort(SortStrategyEnum.BUBBLE_SORT.getSortName(), arr);
//        SortStrategyFacade.sort(SortStrategyEnum.COUNT_SORT.getSortName(), arr);
        SortStrategyFacade.sort(SortStrategyEnum.INSERT_SORT.getSortName(), arr);
    }
}
