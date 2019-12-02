/**
 * @author zhangboqing
 * @date 2019/12/2
 * 希尔排序
 */
public class ShellSort {

    public static void sort(int[] arr) {

        int span = arr.length / 2;
        while (span > 0) {
            for (int j = 0; j < span; j++) {
                for (int k = j + span; k < arr.length; k += span) {
                    int l = k;
                    int value = arr[l];
                    for (; l - span >= 0; l -= span) {
                        if (value < arr[l - span]) {
                            arr[l] = arr[l - span];
                        } else {
                            break;
                        }
                    }
                    if (l != k) {
                        arr[l] = value;
                    }
                }
            }
            span /= 2;
        }


    }

    private static void swap(int[] arr, int i, int minIndex) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 7, 1, 2, 8, 3};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
