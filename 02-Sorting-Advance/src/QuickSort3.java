/**
 * @author zhangboqing
 * @date 2019/12/3
 */
public class QuickSort3 {

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


        int mid = partition(arr, l, r);
        sort(arr, l, mid - 1);
        sort(arr, mid + 1, r);
    }

    private static int partition(int[] arr, int l, int r) {
        // 优化点1：随机获取第一个值
        int randomIndex = (int) Math.random() * (r - l + 1) + l;
        swap(arr, l, randomIndex);
        // 优化点2：实现双路快排
        int k = l;
        int g = r + 1;
        while (true) {
            while (k + 1 < g) {
                if (arr[k + 1] <= arr[l]) {
                    k++;
                } else {
                    break;
                }
            }
            while (g - 1 > k) {
                if (arr[g - 1] >= arr[l]) {
                    g--;
                } else {
                    break;
                }
            }

            if (g - k >= 2) {
                swap(arr, k + 1, g - 1);
            } else if (g - k == 1) {
                g--;
            }else {
                swap(arr,l,k);
                break;
            }
        }
        return k;
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
