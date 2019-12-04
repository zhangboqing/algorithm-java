/**
 * @author zhangboqing
 * @date 2019/12/4
 */
public class HeapSort2 {

    // 对整个arr数组使用HeapSort1排序
    // HeapSort1, 将所有的元素依次添加到堆中, 在将所有元素从堆中依次取出来, 即完成了排序
    // 无论是创建堆的过程, 还是从堆中依次取出元素的过程, 时间复杂度均为O(nlogn)
    // 整个堆排序的整体时间复杂度为O(nlogn)
    public static void sort2(int[] arr) {
        MaxHeap maxHeap = new MaxHeap(arr.length);
        for (int i = 0; i < arr.length; i++) {
            maxHeap.insert(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[arr.length-1-i] = maxHeap.extractMax();
        }
    }
    public static void sort(int[] arr) {
        IndexMaxHeap maxHeap = new IndexMaxHeap(arr.length);
        for (int i = 0; i < arr.length; i++) {
            maxHeap.insert(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[arr.length-1-i] = maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 7, 1, 2, 8, 3};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
