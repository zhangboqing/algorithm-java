/**
 * @author zhangboqing
 * @date 2019/12/3
 */
public class QuickSort4 {

    public static void sort(int[] arr) {

        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        // 优化: 对于小规模数组, 使用插入排序
        if (r - l <= 15) {
            InsertionSort.insertionSort(arr, l, r);
            return;
        }


        // 优化点1：随机获取第一个值
        int randomIndex = (int) Math.random() * (r - l + 1) + l;
        swap(arr, l, randomIndex);
        // 优化点3：实现三路快排
        int k = l;
        int g = r + 1;
        for (int i = l + 1; i < g; i++) {
            if (arr[i] < arr[l]) {
                swap(arr,i,++k);
            } else if (arr[i] > arr[l]) {
                swap(arr,i,--g);
                i--;
            }
        }
        swap(arr,k,l);

        sort(arr, l, k-1);
        sort(arr, g, r);
    }

    private static void swap(int[] arr, int i, int minIndex) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 7, 1, 2, 8, 3};
//        int[] arr = new int[]{5, 4};
        sort(arr);

        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
    }
}
