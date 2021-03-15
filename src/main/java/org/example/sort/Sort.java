package org.example.sort;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 描述：
 *
 * @author menxipeng by 2021/1/15
 */
public class Sort {

    static int[] ints = {8,9,5,1,10,4};

    public static void main(String[] args) {
        //bubble(ints);
        //insertionSort(ints);
        //selectSort(ints);
       // mergeSortC(ints,0,ints.length - 1);
        quickSort(ints,0,ints.length);
    }

    // 冒泡 O(n2)
    public static void bubble(int[] ints) {

        for (int i = 0; i < ints.length; i++) {
            // 出现尾值为有序时，可以减少比较次数
            boolean isBig = false;
            for (int j = 0; j < ints.length - i - 1; j++) {
                if (ints[j] > ints[j + 1]) {
                    int tmp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = tmp;
                    isBig = true;
                }
            }
            if (!isBig) {
                break;
            }
        }
        System.out.println(Arrays.toString(ints));
    }


    // 选择排序 O(n2) 不稳定 不实用
    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 定义最小值下标
            int min = i;
            // 遍历查找最小值下标 ， 遍历集合为无序集合
            for (int j = i; j < arr.length; j++) {
                if (arr[min] > arr[j]) // 查找最小值
                    min = j; // 保存最小索引值
            }
            if (i == min) {
                break;              // 当最后节点不发生移动则停止 优化有序情况
            } else {
                int tmp = arr[i];   // 将当前位置值保存              ｜
                arr[i] = arr[min];  // 将当前位置替换为最小值         | --- 将最小值前移动到当前位置
                arr[min] = tmp;     // 将最小值替换为当前值           |
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // 插入排序 O(n2)
    public static void insertionSort(int[] ints) {
        // 排序的第一节点跳过 ， 第一个节点始终定义为为有序集合
        for (int i = 1; i < ints.length; i++) {
            // 定义比较值 一个一个查找
            int value = ints[i];
            // 查找位置 , 遍历有序集合的位置
            int j = i - 1;
            // 此处进行了 -- ，遍历有序之后 所有无序集合
            for (; j >= 0; j--) {
                // 跟有序集合的值进行比较
                if (ints[j] > value) {
                    // 移动位置 将当前位的值 赋予到下一位 ，此时当前位的值是不变
                    ints[j + 1] = ints[j];
                } else {
                    break;
                }
            }
            // 因此 j 的值执行完始终都是前一位的下标
            ints[j + 1] = value; // 插入数据
        }
        System.out.println(Arrays.toString(ints));
    }



    /**
     * 归并
     递推公式：O(nlogn) ，消耗内存
     merge_sort(p…r) = merge(merge_sort(p…q), merge_sort(q+1…r))
     终止条件：
     p >= r 不用再继续分解
     * @param ints1 数组
     * @param p 起始位置
     * @param r 终止位置
     */
    public static void mergeSortC(int[] ints1,int p,int   r){
        if (p >= r){
            return;
        }
        // 取中间位置 q 的下标
        int q = (p + r) / 2;
        // 分治递归 0 1
        mergeSortC(ints1, p,q );
        mergeSortC(ints1, q + 1,r);

        System.out.println(" ---" + p + "---" + q + "---" + r);

        // 合并数组
        merge(ints1, p, q + 1, r);

    }

    /**
     *
     * @param ints1 原数组
     * @param p 分治数组后的起始位置
     * @param q 此处的 q 为 q + 1 否则无法填充 left 数据
     * @param r 分治处理后的终止位置
     */
    public static void merge(int[] ints1,int p,int q,int r){
        // 左边数组大小
        int[] left = new int[q - p];
        // 右边数组大小
        int[] right = new int[r - q + 1];

        // 填充数据
        for (int i = p; i < q; i++) {
            left[i - p] = ints1[i];
        }

        for (int i = q ; i <= r; i++) {
            right[i - q] = ints1[i];
        }

        // 定义下标
        int i = 0;
        int j = 0;
        int k = p;

        //比较这两个数组的值，哪个小，就往数组上放
        while (i < left.length && j < right.length){
            if (left[i] <= right[j]){
                ints1[k] = left[i];
                k++;
                i++;
            }else {
                ints1[k] = right[j];
                j++;
                k++;
            }

        }

        //如果左边的数组还没比较完，右边的数都已经完了，那么将左边的数抄到大数组中(剩下的都是大数字)
        while (i < left.length){
            ints1[k] = left[i];
            i++;
            k++;
        }
        //如果右边的数组还没比较完，左边的数都已经完了，那么将右边的数抄到大数组中(剩下的都是大数字)
        while (j < right.length){
            ints1[k] = right[j];
            j++;
            k++;
        }

    }

    /**
     * O(nlogn)
     * 递推公式：quick_sort(p…r) = quick_sort(p…q-1) + quick_sort(q+1… r)
     * @param ints1 数组
     * @param p 数组起始位置
     * @param r 数组长度
     */
    public static void quickSort(int[] ints1,int p,int r){
        if (p >= r){
            return;
        }
        // 获取分区点
        int pi = points(ints1, p, r - 1);

        // 进行递归
        quickSort(ints1, p, pi - 1);
        quickSort(ints1, pi + 1, r);

        //System.out.println(Arrays.toString(ints1));
    }

    /**
     * 查找分区点
     */
    public static int points(int[] ints1,int p,int r){
        // 取最后一个节点 作为 分区点
        int po = ints1[r];

        int i = p;

        // 将分区点跟原数组比较 大于分区点的向右排 小于分区点的左排 ： 即比分区点小的的数进行左移
        for (int j = p; j < r; j++) {
            if (po > ints1[j]){
                int tmp = ints1[i];
                ints1[i] = ints1[j];
                ints1[j] = tmp;
                i++;
            }
        }


        // 将分区点数据与最后一位进行替换
        int tmp = ints1[i];
        ints1[i] = ints1[r];
        ints1[r] = tmp;

        //System.out.println(i);

       // System.out.println(Arrays.toString(ints1));

        return i;
    }

}
