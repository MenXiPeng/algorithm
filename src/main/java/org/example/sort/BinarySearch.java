package org.example.sort;

/**
 * 描述：二分查找
 *
 * @author menxipeng by 2021/2/3
 */
public class BinarySearch {

    private static final int[] arrays = {1,2,3,4,5,6,7,8,9};

    public static void main(String[] args) {
       // binarySearch(arrays, 0, arrays.length - 1 , 0);
        System.out.println(9 >> 1);
    }


    // O(logn)
    public static void binarySearch(int[] arr,int low,int height,int arg){

        if (low <= height){

            //low+((high-low)>>1) 防止溢出
            //low+(high-low)/2
            int mid = (low + height) / 2;

            if (arr[mid] > arg){
                binarySearch(arr, low, mid - 1, arg);
            }else if (arr[mid] < arg){
                binarySearch(arr, mid + 1, height, arg);
            }else if (arr[mid] == arg){
                System.out.println("查找到相同值==》"+arg);
            }

        }

    }



    //查找第一个值等于给定值的元素
    public static int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (a[mid - 1] != value))
                    return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }


    // 查找最后一个值等于给定值的元素
    // public int bsearch(int[] a, int n, int value) {
    //     int low = 0;
    //     int high = n - 1;
    //     while (low <= high) {
    //         int mid =  low + ((high - low) >> 1);
    //         if (a[mid] > value) {
    //             high = mid - 1;
    //         } else if (a[mid] < value) {
    //             low = mid + 1;
    //         } else {
    //             if ((mid == n - 1) || (a[mid + 1] != value)) return mid;
    //             else low = mid + 1;
    //         }
    //     }
    //     return -1;
    // }



    // 查找第一个值大于给定值的元素
    // public static int bsearch(int[] a, int n, int value) {
    //     int low = 0;
    //     int high = n - 1;
    //     while (low <= high) {
    //         int mid =  low + ((high - low) >> 1);
    //         if (a[mid] > value) {
    //             high = mid - 1;
    //         } else if (a[mid] < value) {
    //             low = mid + 1;
    //         } else {
    //             if ((mid == 0) || (a[mid - 1] < value))
    //                 return mid;
    //             else high = mid - 1;
    //         }
    //     }
    //     return -1;
    // }

    //查找最后一个值小于给定值的元素
    // public int bsearch7(int[] a, int n, int value) {
    //     int low = 0;
    //     int high = n - 1;
    //     while (low <= high) {
    //         int mid =  low + ((high - low) >> 1);
    //         if (a[mid] > value) {
    //             high = mid - 1;
    //         } else {
    //             if ((mid == n - 1) || (a[mid + 1] > value)) return mid;
    //             else low = mid + 1;
    //         }
    //     }
    //     return -1;
    // }

}
