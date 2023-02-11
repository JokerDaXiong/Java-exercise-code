package com.jokerdig.huffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/11/5 - 10:44
 **/
// 赫夫曼树
public class HuffmanTreeDemo {
    public static void main(String[] args) {
        int arr[] = {13,7,8,3,29,6,1};
        Node huffmanTree = createHuffmanTree(arr);
        System.out.println("========前序遍历赫夫曼树=======");
        preOrder(huffmanTree);
    }
    // 创建赫夫曼树方法
    /**
     *
     * @param arr 创建赫夫曼树的数组
     * @return 创建完毕的赫夫曼树的根节点
     */
    public static Node createHuffmanTree(int [] arr){
        /*
        1. 为了操作方便，我们遍历arr数组
        2. 将arr的每个元素构成一个Node
        3. 将Node放入到ArrayList中
         */
        List<Node> nodes = new ArrayList<Node>();
        for (int value:arr){
            nodes.add(new Node(value));
        }
        // 我们处理的过程是循环进行的
        // 当集合中只剩最后一个节点，循环退出，赫夫曼殊构建完成
        while(nodes.size()>1){

            // 排序,从小到大
            Collections.sort(nodes);
            // System.out.println("nodes"+nodes);

            // 取出根节点权值最小的两个二叉树
            // 1. 取出权值最小的节点
            Node leftNode = nodes.get(0);
            // 2. 取出权值第二小的节点
            Node rightNode  = nodes.get(1);
            // 3. 构建一棵新的二叉树
            Node parent = new Node(leftNode .value+rightNode .value);
            parent.left = leftNode;
            parent.right = rightNode;
            // ArrayList中删除处理过的节点
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            // 将新的二叉树加入到nodes中
            nodes.add(parent);
        }
        // 返回root节点
        return nodes.get(0);
    }
    // 前序遍历
    public static void preOrder(Node root){
        if(root!=null){
            root.preOrder();
        }else{
            System.out.println("该赫夫曼树为空");
        }
    }
}
// 创建节点
// 为了让Node对象持续排序，需要使用Collections集合斤西瓜内排序
// 让Node实现Comparable接口
class Node implements Comparable<Node>{
    int value; // 节点权值
    Node left; // 指向左子节点
    Node right;// 指向右子节点

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
    // Comparable接口方法
    @Override
    public int compareTo(Node o) {
        // 表示从小到大进行排序
        // 返回值大于0，this.value>o.value
        // 返回值小于0，this.value<o.value
        return this.value-o.value;
    }
    // 前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }
}
