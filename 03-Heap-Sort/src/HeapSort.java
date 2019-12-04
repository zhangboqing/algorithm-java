/**
 * @author zhangboqing
 * @date 2019/12/4
 */
public class HeapSort {

    // 对整个arr数组使用HeapSort2排序
    // HeapSort2, 借助我们的heapify过程创建堆
    // 此时, 创建堆的过程时间复杂度为O(n), 将所有元素依次从堆中取出来, 实践复杂度为O(nlogn)
    // 堆排序的总体时间复杂度依然是O(nlogn), 但是比HeapSort1性能更优, 因为创建堆的性能更优
    public static void sort(int[] arr) {
        MaxHeap maxHeap = new MaxHeap(arr);
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
