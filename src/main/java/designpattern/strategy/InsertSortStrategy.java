package designpattern.strategy;

/**
 * 
 * @Description: 插入排序
 * @author chenpingping 【chenpingping1@xiao100.com】
 * @date 2019年11月23日
 */
public class InsertSortStrategy implements SortStrategy {

    /**
     * 
     * @Description: 插入排序
     * 时间复杂度：
     * 插入排序要进行n-1轮，每轮在最坏的比较复制次数分别是1次、2次、3次...一直到n-1次，
     * 所以最坏时间复杂度是O(n^2)。
     * 空间复杂度：
     * 由于插入排序是在原地进行排序，并没有引入额外的数据结构，
     * 所以空间复杂度是O(1)。
     * @Author chenpingping【chenpingping1@xiao100.com】
     * @Date  2019年11月23日
     * @param array 待排序的数组
     */
    public int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int insertValue = array[i];
            int j = i - 1;
            // 从右向左比较元素的同时，进行元素复制
            for (; j >= 0 && insertValue < array[j]; j--) {
                array[j + 1] = array[j];
            }
            // insertValue的值插入适当位置
            array[j + 1] = insertValue;
        }
        
        return array;
    }

}
