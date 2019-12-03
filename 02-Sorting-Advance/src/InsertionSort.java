/**
 * @author zhangboqing
 * @date 2019/12/2
 */
public class InsertionSort {
    private InsertionSort() {
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void insertionSort(int[] arr, int l, int r) {

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

    public static void sort2(int[] arr) {
        for (int i = 1; i < arr.length ; i++) {
            int j = i;
            int value = arr[j];
//            for (; j > 0;) {
//                if (value < arr[j - 1]) {
//                    arr[j] = arr[j - 1];
//                    j--;
//                    continue;
//                } else {
//                    break;
//                }
//            }
            for(;j>0 && value < arr[j-1];j--) {
                arr[j] = arr[j-1];
            }
            if (j != i+1) {
                arr[j] = value;
            }
        }
    }

    private static void swap(int[] arr, int i, int minIndex) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 7, 1, 2, 8, 3};
        sort2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
