package org.example;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueForArrayList {

    public static void main(String[] args) {
        QueueForArrayList queueForArrayList = new QueueForArrayList(4);
        queueForArrayList.add("1");
        queueForArrayList.add("2");
        queueForArrayList.offer();
        queueForArrayList.add("3");
        queueForArrayList.add("4");
        queueForArrayList.offer();
        queueForArrayList.add("5");
        queueForArrayList.list();
    }

    // 定义数组
    private String[] item;
    // 队列元素个数
    private int n;
    // 队列头
    private int head;
    // 队列尾
    private int tail;

    // 初始化队列大小
    public QueueForArrayList(int n) {
        this.item = new String[n];
        this.head = 0;
        this.tail = 0;
        this.n = n;
    }

    // 添加队列
    public void add(String val) {
        if (tail - head == n) {
            System.out.println("队列已满，无法入队");
            return;
        }
        // 队列无空间 进行搬迁
        if (tail == n) {
            for (int i = head; i < tail; i++) {
                item[i - head] = item[i];
            }
            tail = tail - head;
            head = 0;
        }
        item[tail] = val;
        tail++;
    }

    // 出队
    public void offer() {
        if (tail - head == 0) {
            System.out.println("队列为 null，无法出队");
        }
        System.out.println("pop:" + item[head]);
        head++;
    }

    // 遍历
    public void list() {
        for (int i = head; i < tail; i++) {
            System.out.println(item[i]);
        }
    }


}
