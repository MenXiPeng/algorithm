package org.example.structure;

/**
 * 描述：基于数组实现栈
 *
 * @author menxipeng by 2021/1/7
 */
public class StackForArray {

    public static void main(String[] args) {

    }

    // 定义数组
    private final String[] item;
    // 栈中元素
    private int count;
    // 栈大小
    private final int n;

    // 申请栈空间
    public StackForArray(int n){
        this.item = new String[n];
        this.n = n;
        this.count = 0;
    }

    // 入栈
    public boolean push(String val){
        if (count == n){
            System.out.println("栈空间以满！！！");
            return false;
        }
        item[count] = val;
        count++;
        return true;
    }

    // 出栈
    public String pop(){
        if (item.length == 0){
            System.out.println("栈为空！！！");
            return null;
        }
        // 例：栈中有一个元素 位置为 item[0] 此时 count = 1，取值为 count - 1 的下标
        String val = item[count - 1];
        count--;
        return val;
    }

}
