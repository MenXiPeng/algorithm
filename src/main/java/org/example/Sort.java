package org.example;

import java.util.Arrays;

/**
 * 描述：
 *
 * @author menxipeng by 2021/1/15
 */
public class Sort {

    static int[] ints = {4,5,3};

    public static void main(String[] args) {
        //bubble(ints);
        insertionSort(ints);
    }

    // 冒泡
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

    // 插入排序
    public static void insertionSort(int[] ints){
        // 排序的第一节点跳过 ， 第一个节点始终定义为为有序集合
        for (int i = 1; i < ints.length; i++) {
            // 定义比较值 一个一个查找
            int value  = ints[i];
            // 查找位置 , 遍历有序集合的位置
            int j = i - 1;
            // 此处进行了 -- ，遍历有序之后 所有无序集合
            for (; j >= 0; j--) {
                // 跟有序集合的值进行比较
                if (ints[j] > value){
                    // 移动位置 将当前位的值 赋予到下一位 ，此时当前位的值是不变
                    ints[j + 1] = ints[j];
                 }else {
                    break;
                }
            }
            // 因此 j 的值执行完始终都是前一位的下标
            ints[j + 1] =  value; // 插入数据
        }
        System.out.println(Arrays.toString(ints));
    }

}
