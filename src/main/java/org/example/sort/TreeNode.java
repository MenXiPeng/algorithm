package org.example.sort;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：
 *
 * @author menxipeng by 2021/2/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode {

    int data;

    TreeNode leftNode;

    TreeNode rightNode;

    public TreeNode(int data) {
        this.data = data;
    }
}

class BinaryTree {

    public static TreeNode rootNode;

    public static void addRecursive(TreeNode current,int value){
        if (rootNode == null){
            rootNode = new TreeNode(value);
            return;
        }
        if (value < current.data){
            if (current.leftNode == null){
                current.leftNode = new TreeNode(value);
                return;
            }
            current = current.leftNode;
        }else {
            if (current.rightNode == null){
                current.rightNode = new TreeNode(value);
                return;
            }
            current = current.rightNode;
        }
        addRecursive(current, value);
    }


    TreeNode tree;

    public void insert(int data) {
        if (tree == null) {
            tree = new TreeNode(data);
            return;
        }
        TreeNode p = tree;
        while (true) {
            if (data > p.data) {
                if (p.rightNode== null) {
                    p.rightNode = new TreeNode(data);
                    return;
                }
                p = p.rightNode;
            } else { // data < p.data
                if (p.leftNode == null) {
                    p.leftNode = new TreeNode(data);
                    return;
                }
                p = p.leftNode;
            }
        }
    }

    public static void add(int v){
        addRecursive(rootNode, v);
    }

    //  正序遍历
    public static void positiveSequence(TreeNode node){
        // 先遍历自己
        // 在遍历左节点
        // 在遍历右节点
        if (node != null){
            System.out.println(node.data);
            positiveSequence(node.leftNode);
            positiveSequence(node.rightNode);

        }
    }
    // 中序遍历
    public static void inSequence(TreeNode node){
        // 先遍历左子树
        // 在遍历自己
        // 在遍历右子树
        if (node != null){
            inSequence(node.leftNode);
            System.out.println(node.data);
            inSequence(node.rightNode);
        }
    }

    // 后序遍历
    public static void afterSequence(TreeNode node){
        // 先遍历左子树
        // 在遍历右子树
        // 在遍历自己
        if (node != null){
            afterSequence(node.leftNode);
            afterSequence(node.rightNode);
            System.out.println(node.data);
        }
    }

    // 查找
    public static TreeNode find(TreeNode node,int value){
        // 定义节点
        TreeNode p = node;
        while (p != null){
            if (value < p.data){
                p = p.leftNode;
            }else if (value > p.data){
                p = p.rightNode;
            }else {
                return p;
            }
        }
        return null;
    }

    /*
     删除节点
     1、删除无子节点数据 直接将父节点指向 null
     2、删除只有左节点或者右节点数据，直接将子节点指向父节点的父节点
     3、删除既有左子节点，又有右子节点数据，需要查找右子树的最小叶子节点（左子树节点），将该节点数据替换掉删除数据
     */
    public void delete(int data) {
        TreeNode p = tree; // p指向要删除的节点，初始化指向根节点
        TreeNode pp = null; // pp记录的是p的父节点
        // 查找删除节点
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data)
                p = p.rightNode;
            else p = p.leftNode;
        }
        if (p == null) return; // 没有找到

        // 要删除的节点有两个子节点 删除节点 左 右 都不 为null
        if (p.leftNode != null && p.rightNode != null) {
            // 查找右子树中最小节点
            TreeNode minP = p.rightNode;
            TreeNode minPP = p;  // minPP表示minP的父节点
            while (minP.leftNode != null) {
                minPP = minP;
                minP = minP.leftNode;
            }
            p.data = minP.data; // 将minP的数据替换到p中
            p = minP; // 下面就变成了删除minP了
            pp = minPP;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        TreeNode child; // p的子节点
        if (p.leftNode != null)
            child = p.leftNode;
        else if (p.rightNode != null)
            child = p.rightNode;
        else child = null;

        if (pp == null) tree = child; // 删除的是根节点
        else if (pp.leftNode == p) pp.leftNode = child;
        else pp.rightNode = child;
    }


    /*
        树高度，深度遍历
     */
    public static int treeHeight(TreeNode node){
        // int l = 0;
        // int r = 0;
        // TreeNode p = node;
        // TreeNode rp = node;
        // while (p != null && rp != null){
        //     if (p.leftNode != null){
        //         l++;
        //        p = p.leftNode;
        //     }else {
        //         r++;
        //         rp = rp.rightNode;
        //     }
        // }
        // System.out.println(Math.max(l, r) + 1);
        if (node == null) {
            return 0;
        }
        int ldep = treeHeight(node.leftNode);
        int rdep = treeHeight(node.rightNode);
        if (ldep > rdep) {
            return ldep + 1;
        } else {
            return rdep + 1;
        }
    }

    // 最大节点 -> 右子树遍历到底
    // 最小节点 -> 左子树遍历到底
    // 前驱节点 -> 当前节点的左子树
    // 后继节点 -> 当前节点的右子树
    public static void main(String[] args) {
        add(1);
        add(0);
        add(2);
        add(1);
        add(2);
        // add(1);
        // add(3);
        // add(0);
        System.out.println(rootNode);
        //inSequence(rootNode);
        System.out.println(treeHeight(rootNode));
        //System.out.println(find(rootNode, 1));
    }
}
