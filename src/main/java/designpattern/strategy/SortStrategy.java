package designpattern.strategy;

/**
 * 排序策略
 * @Author chenpp【chenpingping1@xiao100.com】
 * @Date  2021年9月24日
 */
public interface SortStrategy {
    
    /**
     *  排序
     *  
     * @Author chenpp【chenpingping1@xiao100.com】
     * @Date  2021年9月24日
     * @param arr 排序前数据
     * @return 排序后数据
     */
    int[] sort(int[] arr);
    
}
