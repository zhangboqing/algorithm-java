/**
 * @author zhangboqing
 * @date 2019/12/4
 */
public class HeapSort3 {

    // 不使用一个额外的最大堆, 直接在原数组上进行原地的堆排序
    public static void sort(int[] arr) {
        MaxHeap.sort(arr);
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 7, 1, 2, 8, 3};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
