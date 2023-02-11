package com.jokerdig.avl;


/**
 * @author Joker大雄
 * @data 2022/11/18 - 9:26
 **/
public class AVLTreeDemo {
    public static void main(String[] args) {
        // int[] arr = {4,3,6,5,7,8}; // 测试左旋转数组
        // int[] arr = {10,12,8,9,7,6}; // 测试右旋转数组
        // int[] arr = {10,11,7,6,8,9}; // 测试双旋转数组
        int[] arr = {2,1,6,5,7,3}; // 测试双旋转数组2
        // 创建一个AVLTree
        AVLTree avl = new AVLTree();
        // 添加节点
        for (int i = 0; i < arr.length; i++) {
            avl.add(new Node(arr[i]));
        }
        // 中序遍历
        System.out.println("中序遍历");
        avl.infixOrder();
        // 测试树高度统计
        System.out.println("双旋转后,树的高度为：");
        System.out.println(avl.getRoot().height());
        System.out.println("左子树高度为：");
        System.out.println(avl.getRoot().leftHeight());
        System.out.println("右子树高度为：");
        System.out.println(avl.getRoot().rightHeight());
    }
}
// 创建AVLTree
class AVLTree{
    private Node root;

    public Node getRoot() {
        return root;
    }

    // 添加节点方法
    public void add(Node node){
        if(root==null){
            root = node; // 根节点
        }else{
            root.add(node); // 添加节点
        }
    }
    // 中序遍历
    public void infixOrder(){
        if(root!=null){
            root.infixOrder();
        }else{
            System.out.println("没有数据");
        }
    }
}

// 创建节点
class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    // 返回左子树的高度
    public int leftHeight(){
        if(left==null){
            return 0;
        }else{
            return left.height();
        }
    }

    // 返回右子树的高度
    public int rightHeight(){
        if(right==null){
            return 0;
        }else{
            return right.height();
        }
    }

    // 返回当前节点为根节点的树的高度
    public int height(){
        // 统计出来左子树和右子树的高度，在+1;(即加上本身这个节点)
        return Math.max(left==null? 0:left.height(), right==null?0:right.height())+1;
    }

    // 左旋转方法
    private void leftRotate(){
        // 创建新的节点，以当前根节点的值
        Node newNode = new Node(value);
        // 把新节点的左子树设置成当前节点的左子树
        newNode.left = left;
        // 把新的节点的右子树设置成当前节点的右子树的左子树
        newNode.right = right.left;
        // 把当前节点的值替换成右子节点啊的值
        value = right.value;
        // 把当前节点的右子树设置成右子树的右子树
        right = right.right;
        // 把当前节点的左子树设置成新的节点
        left = newNode;
    }

    // 右旋转方法，注释省略
    private void rightRotate(){
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }

    // 添加节点
    public void add(Node node){
        if(node==null) {
            return;
        }
        // 判断传入节点的值和当前子树的根节点值的关系
        if(node.value<this.value){
            if(this.left==null){// 如果当前节点做字节点为空
                this.left = node; // 直接添加
            }else{
                // 否则递归的向左子树添加
                this.left.add(node);
            }
        }else{// 添加的节点的值大于当前节点的值
            if(this.right==null){
                this.right = node;// 直接添加
            }else{
                // 递归向右子树添加
                this.right.add(node);
            }
        }
        // 当添加完一个节点后，如果(右子树高度-左子树高度)>1
        if(rightHeight()-leftHeight()>1){
            // 如果当前节点的右子节点的左子树高度，
            // 大于当前节点的右子节点的右子树高度，
            if(right!=null && right.leftHeight()>right.rightHeight()){
                right.rightRotate(); // 先将当前节点的右子节点的树进行右旋转
                leftRotate(); // 进行左旋转
            }else{
                leftRotate(); // 直接进行左旋转
            }
        }else if(leftHeight()-rightHeight()>1){// 右旋转
            // 如果当前节点的左子节点的右子树高度，
            // 大于当前节点的左子节点的左子树高度，
            if(left!=null && left.rightHeight()>left.leftHeight()){
                left.leftRotate();// 先将当前节点的左子节点的树进行左旋转
                rightRotate(); // 进行右旋转
            }else{
                rightRotate(); // 直接进行右旋转
            }
        }
    }
    // 中序遍历
    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.infixOrder();
        }
    }
}
