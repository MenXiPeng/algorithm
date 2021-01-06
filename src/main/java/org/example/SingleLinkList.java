package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 描述：
 *
 * @author menxipeng by 2021/1/6
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student {
    private int no;
    private String name;
    private String num;
    private Student next;

    public Student(int no, String name, String num) {
        this.no = no;
        this.name = name;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", num='" + num + '\'' +
                '}';
    }
}

public class SingleLinkList {

    public static void main(String[] args) {
        SingleLinkList singleLinkList = new SingleLinkList();
        Student student = new Student(1, "tom", "1001");
        Student student1 = new Student(2, "jon", "1002");
        Student student2 = new Student(3, "jimi", "1003");
        singleLinkList.add(student);
        //singleLinkList.add(student1);
        singleLinkList.add(student2);
        // singleLinkList.list();
        singleLinkList.addForNo(student1);

        // Student student11 = new Student(-1, "jon1", "1002");
        //
        // singleLinkList.modify(student11);

        //singleLinkList.list();

        singleLinkList.list();

        // System.out.println("链表长度为："+singleLinkList.getLength(singleLinkList.head));
        //
        // singleLinkList.getReciprocal(1,singleLinkList.getLength(singleLinkList.head),singleLinkList.head);

        System.out.println("------开始反转----");

        singleLinkList.reversal(singleLinkList.head);

        singleLinkList.list();

    }

    // 创建一个头节点
    private final Student head = new Student(0, "head", "0000");

    // 添加
    public void add(Student student) {
        // 定义指针指向头部
        Student p = head;
        // 需要遍历链表
        while (true) {
            // 如果下一个节点不为 null，需要移动指针
            if (p.getNext() == null) {
                p.setNext(student);
                break;
            }
            p = p.getNext();
        }
    }

    // 按照编号查找链表
    public void addForNo(Student student) {
        // 定义指针指向头部
        Student p = head;
        // 首先要遍历节点
        while (true) {
            // 判断是否可以找到这个位置,如果最后都找不到 就应该在链表尾部
            if (p.getNext() == null) {
                p.setNext(student);
                break;
            }
            // 判断节点编号是否为大于no
            if (p.getNext().getNo() == student.getNo()) {
                System.out.println("节点以存在");
                break;
            }
            if (p.getNext().getNo() > student.getNo()) {
                // 先移动插入节点指向下一个节点
                student.setNext(p.getNext());
                // 在将当前节点指向插入节点 注意：不可以反过来，会导致链断掉，此处会导致死循环
                p.setNext(student);
                break;
            }
            p = p.getNext();
        }
    }

    // 单链表修改 替换节点
    public void modify(Student student) {
        // 定义指针
        Student p = head;
        while (true) {
            // 链表中查找不到停止
            if (p.getNext() == null) {
                System.out.println("修改的数据不存在");
                break;
            }
            // 找到对应数据进行修改
            if (p.getNext().getNo() == student.getNo()) {
                student.setNext(p.getNext().getNext());
                p.setNext(student);
                break;
            }
            p = p.getNext(); // 移动指针
        }
    }

    // 删除节点
    public void del(int no) {
        // 定义指针
        Student p = head;
        while (true) {
            // 链表为空 则找不到节点
            if (p.getNext() == null) {
                System.out.println("没有找到删除节点");
                break;
            }
            // 查找到节点
            if (p.getNext().getNo() == no) {
                p.setNext(p.getNext().getNext());
                break;
            }
            p = p.getNext(); // 移动指针
        }
    }

    // 获取链表长度
    public int getLength(Student head) {
        // 定义指针
        Student p = head;
        int i = 0;
        while (true) {
            if (p.getNext() == null) {
                break;
            }
            i++;
            p = p.getNext(); // 移动指针
        }
        return i;
    }

    // 遍历链表
    public void list() {
        // 定义指针头节点
        Student p = head;
        while (true) {
            System.out.println(p);
            if (p.getNext() == null) {
                break;
            }
            // 移动指针
            p = p.getNext();
        }
    }

    // 获取倒数 i 个节点
    public void getReciprocal(int i, int length, Student head) {
        // 指定指针,不算头节点
        Student p = head.getNext();
        if (length < i) {
            System.out.println("获取节点大于总长度");
        }
        int k = length - i;
        for (int j = 0; j <= k; j++) {
            if (j == k) {
                System.out.println("倒数第 " + i + " 个节点为：" + p);
            }
            p = p.getNext(); // 移动指针
        }
    }

    // 反转链表
    public void reversal(Student head) {
        // 定义新的头节点
        Student newHead = new Student(0,"new","1111");
        Student p = head.getNext();
        Student next;

        while (p != null) {
            // 移动
            next = p.getNext();  // 暂存原链表的后续链表
            p.setNext(newHead.getNext()); // 第一次 p 节点指向一个 null 节点，第二次以后 p 节点则指向头节点的下一个节点
            newHead.setNext(p); // 将头节点指向新节点
            p = next; // 将指针指向原节点的后续链表上
        }
        head.setNext(newHead.getNext()); // 移动

    }

}
