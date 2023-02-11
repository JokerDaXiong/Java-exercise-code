package com.jokerdig.tree;

/**
 * @author Joker大雄
 * @data 2022/11/1 - 9:53
 **/
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        // 创建ArrBinaryTree
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        System.out.println("前序遍历：");
        arrBinaryTree.preOrder(); // 1 2 4 5 3 6 7
        System.out.println("\n中序遍历：");
        arrBinaryTree.infixOrder(); // 4 2 5 1 6 3 7
        System.out.println("\n后序遍历：");
        arrBinaryTree.postOrder(); // 4 5 2 6 7 3 1
    }
}
// 编写一个ArrBinaryTree，实现顺序存储二叉数遍历
class ArrBinaryTree{
    private int [] arr;// 存储数据节点
    // 构造器
    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    // 重载preOrder方法
    public void preOrder(){
        this.preOrder(0);
    }
    // 重载infixOrder方法
    public void infixOrder(){
        this.infixOrder(0);
    }
    // 重载postOrder方法
    public void postOrder(){
        this.postOrder(0);
    }

    // 编写一个方法，完成顺序存储二叉树的遍历
    // 前序遍历
    /**
     *
     * @param index 数组的下标，也就是题目里的n
     */
    public void preOrder(int index){
        // 数组为空
        if(arr == null || arr.length==0){
            System.out.println("数组为空");
            return;
        }
        // 输出当前元素
        System.out.print(arr[index]+" ");
        //  向左递归遍历
        if((index*2+1)<arr.length){
            preOrder(index*2+1);
        }
        // 向右递归遍历
        if((index*2+2)<arr.length){
            preOrder(index*2+2);
        }
    }

    // 中序遍历
    public void infixOrder(int index){
        // 数组为空
        if(arr == null || arr.length == 0){
            System.out.println("数组为空");
            return;
        }
        // 左递归遍历
        if((index*2+1)<arr.length){
            infixOrder(index*2+1);
        }
        // 数组当前元素
        System.out.print(arr[index]+" ");
        // 右递归遍历
        if((index*2+2)<arr.length){
            infixOrder(index*2+2);
        }
    }

    // 后序遍历
    public void postOrder(int index){
        // 数组为空
        if(arr == null || arr.length == 0){
            System.out.println("数组为空");
            return;
        }
        // 左递归遍历
        if((index*2+1)<arr.length){
            postOrder(index*2+1);
        }
        // 右递归遍历
        if((index*2+2)<arr.length){
            postOrder(index*2+2);
        }
        // 输出元素
        System.out.print(arr[index]+" ");
    }
}