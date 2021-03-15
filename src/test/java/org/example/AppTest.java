package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    int[] anArray = {1,3,6,2,5,9};


    @Test
    public void demo(){
        // 插入排序

        for (int i = 1; i < anArray.length; i++) {
            // 定义比较值 无序集合
            int value = anArray[i];

            // 定义有序集合
            int j = i - 1;

            for (; j >= 0; j--) {
                // 有序集合大于无序集合
                if (anArray[j] > value){
                    // 将有序集合数据进行后移
                    anArray[j + 1] =  anArray[j];
                }else {
                    break;
                }
            }
            // 将无序集合数据插入原有序集合的位置
            anArray[j + 1] = value;
        }

        System.out.println(Arrays.toString(anArray));
    }


    @Test
    public void demo1(){
        // 对应的是下标
        demo2(anArray, 0,anArray.length - 1);
        //Sort.mergeSortC(anArray, 0,anArray.length - 1);
        System.out.println(Arrays.toString(anArray));
    }

    public void demo2(int[] an,int p,int r){
        // 当中间节点为自己 则停止
        if (p >= r){
            return;
        }
        // 取中间节点
        int  q = (p + r) / 2;
        // 递归节点
        demo2(an, p, q);
        demo2(an, q + 1,r);
        // merge
        merge(an,p,q + 1,r);
    }

    private void merge(int[] an, int p, int q,int r) {
        // 将数组进行区分 ，分为 左 右 两个数组
        int[] left = new int[q - p];

        int[] right = new int[r - q + 1];

        // 填充数据
        for (int i = p; i < q; i++) {
            left[i - p] = an[i];
        }

        for (int i = q; i <= r; i++) {
            right[i - q] = an[i];
        }

        // 定义下标
        int i = 0;
        int j = 0;
        int k = p;

        // 进行比较 谁小谁就往后放
        while (i < left.length && j < right.length){
            if (left[i] <= right[j]){
                an[k] = left[i];
                i++;
            }else{
                an[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length){
            an[k] = left[i];
            k++;
            i++;
        }

        while (j < right.length){
            an[k] = right[j];
            k++;
            j++;
        }

    }
}
