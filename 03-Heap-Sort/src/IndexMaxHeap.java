/**
 * @author zhangboqing
 * @date 2019/12/4
 */
public class IndexMaxHeap {
    private int[] data;     // 最大索引堆中的数据
    private int[] indexes;  // 最大索引堆中的索引, indexes[x] = i 表示索引i在x的位置
    private int[] reverse;  // 最大索引堆中的反向索引, reverse[i] = x 表示索引i在x的位置
    private int count;

    public IndexMaxHeap(int capacity) {
        this.data = new int[capacity];
        this.indexes = new int[capacity];
        this.reverse = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            reverse[i] = 0;
        }
        this.count = 0;
    }

    public void insert(int e) {
        if (count == data.length) {
            throw new IllegalArgumentException("heap is full");
        }

        data[count] = e;
        indexes[count] = count;
        reverse[count] = count;
        shiftUp(count);
        count++;
    }

    public int extractMax() {
        int max = getMax();
        swap(indexes, 0, count - 1);
        count--;
        siftDown(0);
        return max;
    }

    public void change(int i, int e) {
        if (i < 0 || i > count - 1) {
            throw new IllegalArgumentException("param i value error.");
        }
        data[i] = e;
        shiftUp(reverse[i]);
        siftDown(reverse[i]);
    }

    public int getItem(int i) {
        if (i < 0 || i > count - 1) {
            throw new IllegalArgumentException("param i value error.");
        }
        return data[i];
    }

    private void siftDown(int index) {
        while (leftIndex(index) < count) {
            int nextIndex = leftIndex(index);
            if (rightIndex(index) < count) {
                nextIndex = data[indexes[leftIndex(index)]] > data[indexes[rightIndex(index)]] ? leftIndex(index) : rightIndex(index);
            }

            if (data[indexes[nextIndex]] > data[indexes[index]]) {
                swap(indexes, nextIndex, index);
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
        return data[indexes[0]];
    }

    private void shiftUp(int index) {
        while (data[indexes[parent(index)]] < data[indexes[index]]) {
            swap(indexes, parent(index), index);
            index = parent(index);
        }
    }

    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
        reverse[data[i]] = i;
        reverse[data[j]] = j;
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
