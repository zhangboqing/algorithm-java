import java.util.Arrays;

/**
 * @author zhangboqing
 * @date 2019/12/3
 */
public class MergeSort3 {

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        // 优化2: 对于小规模数组, 使用插入排序
        if (r - l <= 15) {
            insertionSort(arr, l, r);
        }

        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        if (arr[mid] > arr[mid + 1]) {
            merge(arr, l, mid, r);
        }
    }

    private static void insertionSort(int[] arr, int l, int r) {

        for (int i = l + 1; i <= r; i++) {
            int value = arr[i ];
            int j = i ;
            for (; j > l && value < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            if (j != i ) {
                arr[j] = value;
            }
        }
    }

    private static void merge(int[] arr, int l, int mid, int r) {

//        int[] newArr = new int[r - l + 1];
//        for (int i = 0; i < newArr.length; i++) {
//            newArr[i] = arr[l + i];
//        }
        int[] newArr = Arrays.copyOfRange(arr, l, r + 1);

        int i = 0;
        int j = mid - l + 1;
        int k = l;
        while (true) {
            if (k > r) {
                break;
            }
            if (i > mid - l) {
                arr[k++] = newArr[j++];
            } else if (j > r - l) {
                arr[k++] = newArr[i++];
            } else if (newArr[i] < newArr[j]) {
                arr[k++] = newArr[i++];
            } else {
                arr[k++] = newArr[j++];
            }
        }
    }


    private static void swap(int[] arr, int i, int minIndex) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 7, 1, 2, 8, 3};
        sort(arr);

        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }

    }
}
