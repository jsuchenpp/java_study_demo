package designpattern.strategy;

/**
 * 冒泡排序
 * 
 * @Author chenpp【chenpingping1@xiao100.com】
 * @Date 2021年9月23日
 */
public class BubbleSortStrategy implements SortStrategy {

    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
