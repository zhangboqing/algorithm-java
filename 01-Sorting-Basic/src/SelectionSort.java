/**
 * @author zhangboqing
 * @date 2019/12/2
 */
public class SelectionSort {

    private SelectionSort(){
    }

    public static void sort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
             int temp  =arr[i];
             arr[i] = arr[minIndex];
             arr[minIndex] = temp;
        }
    }

    // 支持泛型
    public static <T extends Comparable<T>> void sort(T[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(Object[] arr, int i, int minIndex) {
        Object temp =arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5,4,7,1,2,8,3};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
