package org.example.structure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：循环单向链表
 *
 * @author menxipeng by 2021/1/7
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
class Duck {
    //private Duck pre;

    private int no;

    private String color;

    private Duck next;

    public Duck(int no, String color) {
        this.no = no;
        this.color = color;
    }
}

public class LoopLinkList {

    public static void main(String[] args) {

        LoopLinkList loopLinkList = new LoopLinkList();

        Duck duck1 = new Duck(1,"red");
        Duck duck2 = new Duck(2,"yellow");
        Duck duck3 = new Duck(3,"blue");

        loopLinkList.add(duck1);
        loopLinkList.add(duck2);
        loopLinkList.add(duck3);

        loopLinkList.list();


    }

    private final Duck head = new Duck();

    public void add(Duck duck){
        // 定义指针
        Duck p = head;

        if (p.getNext() == null){
            p.setNext(head);
        }
        while (true){
            if (p.getNext() == head){
                duck.setNext(head);
                p.setNext(duck);
                break;
            }
            p = p.getNext(); // 移动指针
        }
    }



    public void list(){

        // 定义指针
        Duck p = head;

        while (true){
            if (p.getNext() == head){
                break;
            }
            System.out.println( p + "p" + p.getNext() + "-->" + p.getNext().getNext() );

            p = p.getNext();
        }

    }

}
