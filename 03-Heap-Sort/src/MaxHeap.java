/**
 * @author zhangboqing
 * @date 2019/12/4
 */
public class MaxHeap {
    private int[] data;
    private int count;

    public MaxHeap(int capacity) {
        this.data = new int[capacity];
        this.count = 0;
    }

    public MaxHeap(int[] arr) {
        this.data = new int[arr.length];
        this.count = arr.length;
        for (int i = 0; i < data.length; i++) {
            data[i] = arr[i];
        }
        int parent = parent(data.length - 1);
        for (int i = parent; i >= 0; i--) {
            siftDown(i);
        }
    }

    public static void sort(int[] arr) {
        int length = arr.length ;
        for (int i = parent(length-1); i >= 0; i--) {
            siftDown(arr, arr.length, i);
        }
        for (int i = 0; i < length; i++) {
            swap(arr, 0, length -1 - i);
            siftDown(arr, arr.length - 1 - i , 0);
        }
    }

    public void insert(int e) {
        if (count == data.length) {
            throw new IllegalArgumentException("heap is full");
        }

        data[count] = e;
        shiftUp(count);
        count++;
    }

    public int extractMax() {
        int max = getMax();
        swap(data, 0, count - 1);
        count--;
        siftDown(0);
        return max;
    }

    private static void siftDown(int[] data, int count, int index) {
        while (leftIndex(index) < count) {
            int nextIndex = leftIndex(index);
            if (rightIndex(index) < count) {
                nextIndex = data[leftIndex(index)] > data[rightIndex(index)] ? leftIndex(index) : rightIndex(index);
            }

            if (data[nextIndex] > data[index]) {
                swap(data, nextIndex, index);
                index = nextIndex;
            } else {
                break;
            }
        }
    }

    private void siftDown(int index) {
        while (leftIndex(index) < count) {
            int nextIndex = leftIndex(index);
            if (rightIndex(index) < count) {
                nextIndex = data[leftIndex(index)] > data[rightIndex(index)] ? leftIndex(index) : rightIndex(index);
            }

            if (data[nextIndex] > data[index]) {
                swap(data, nextIndex, index);
                index = nextIndex;
            } else {
                break;
            }
        }
    }

    private int getMax() {
        if (count == 0) {
            throw new IllegalArgumentException("heap is empty");
        }
        return data[0];
    }

    private void shiftUp(int index) {
        while (data[parent(index)] < data[index]) {
            swap(data, parent(index), index);
            index = parent(index);
        }
    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static int parent(int index) {
        return (index - 1) / 2;
    }

    public static int leftIndex(int index) {
        return index * 2 + 1;
    }

    public static int rightIndex(int index) {
        return index * 2 + 2;
    }

    public int getSize() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }
}
