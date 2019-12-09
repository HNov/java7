package com.nov.console;

import java.util.Arrays;
import java.util.Comparator;

public class Algorithm {

    public static void main(String[] args) {

        int[] numbers = new int[]{7, 3, 8, 23, 54, 2, 4, 9, 5};
        //Integer[] arr = {9, 8, 7, 6, 54, 53, 51, 50, 11,33,44};
        Integer[] arr = {9, 8, 7, 6, 51, 54, 63, 22, 11,33,44,55,61,62,63,64,78,87,91,92,87,89,90,92,96,91,96,109,108,105,302,308,804,902,989,988,777,888,666,555,9876,7654,654,54433,6546,8865,7778,111,222,543,7777};
        int minRun=minRunLength(499);
        TimSort.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

    }

    /**
     * 冒泡排序
     * <p>
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     *
     * @param numbers 需要排序的整型数组
     */
    public static void bubbleSort(int[] numbers) {
        int temp = 0;
        int size = numbers.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1])  //交换两数位置
                {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }


    /**
     * 快速排序
     *
     * @param numbers 带排序数组
     */
    public static void quick(int[] numbers) {
        if (numbers.length > 0)   //查看数组是否为空
        {
            quickSort(numbers, 0, numbers.length - 1);
        }
    }

    /**
     * 递归快速排序
     *
     * @param numbers 带排序数组
     * @param low     开始位置
     * @param high    结束位置
     */
    public static void quickSort(int[] numbers, int low, int high) {
        if (low < high) {
            int middle = getMiddle(numbers, low, high); //将numbers数组进行一分为二
            quickSort(numbers, low, middle - 1);   //对低字段表进行递归排序
            quickSort(numbers, middle + 1, high); //对高字段表进行递归排序
        }
    }

    /**
     * 快速排序
     * 查找出中轴（默认是最低位low）的在numbers数组排序后所在位置
     *
     * @param numbers 带查找数组
     * @param low     开始位置
     * @param high    结束位置
     * @return 中轴所在位置
     */
    public static int getMiddle(int[] numbers, int low, int high) {
        int temp = numbers[low]; //数组的第一个作为中轴
        while (low < high) {
            while (low < high && numbers[high] > temp) {
                high--;
            }
            numbers[low] = numbers[high];//比中轴小的记录移到低端
            while (low < high && numbers[low] < temp) {
                low++;
            }
            numbers[high] = numbers[low]; //比中轴大的记录移到高端
        }
        numbers[low] = temp; //中轴记录到尾
        return low; // 返回中轴的位置
    }


    /**
     * 归并排序
     *
     */
    public static void mergeSort(int[] arr) {

        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int[] temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr, 0, arr.length - 1, temp);
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);//左边归并排序，使得左子序列有序
            sort(arr, mid + 1, right, temp);//右边归并排序，使得右子序列有序
            merge(arr, left, mid, right, temp);//将两个有序子数组合并操作
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        int t = 0;//临时数组指针
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while (j <= right) {//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

    /**
     * 返回参与合并的最小长度，如果自然排序的长度，小于此长度，那么就通过二分查找排序扩展到
     * 此长度。{@link #binarySort}.
     * <p>
     * 粗略的讲，计算结果是这样的：
     * <p>
     * 如果 n < MIN_MERGE, 直接返回 n。（太小了，不值得做复杂的操作）；
     * 如果 n 正好是2的幂，返回 n / 2；
     * 其它情况下 返回一个数 k，满足 MIN_MERGE/2 <= k <= MIN_MERGE,
     * 这样结果就能保证 n/k 非常接近但小于一个2的幂。
     * 这个数字实际上是一种空间与时间的优化。
     *
     * @param n 参与排序的数组的长度
     * @return 参与归并的最短长度
     * 这段代码写得也很赞
     */
    private static int minRunLength(int n) {
        assert n >= 0;
        int r = 0;      // 只要不是 2的幂就会置 1
        while (n >= 32) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }
}
