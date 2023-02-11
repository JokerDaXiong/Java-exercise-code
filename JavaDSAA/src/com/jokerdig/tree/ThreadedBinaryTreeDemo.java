package com.jokerdig.tree;

/**
 * @author Joker大雄
 * @data 2022/11/2 - 19:06
 **/
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        // 测试中序线索二叉树的功能
        HeroNode2 root = new HeroNode2(1, "tom");
        HeroNode2 node2 = new HeroNode2(3, "jack");
        HeroNode2 node3 = new HeroNode2(6, "join");
        HeroNode2 node4 = new HeroNode2(8, "black");
        HeroNode2 node5 = new HeroNode2(10, "tom1");
        HeroNode2 node6 = new HeroNode2(14, "tom2");

        // 二叉树创建，手动
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        // 测试线索化
        BinaryTree2 binaryTree2 = new BinaryTree2();
        binaryTree2.setRoot(root);
        binaryTree2.threadedNodes();
        // 测试10这个节点进行
        HeroNode2 leftNode = node5.getLeft();
        HeroNode2 rightNode = node5.getRight();
        System.out.println("10号节点的前驱节点为："+leftNode);
        System.out.println("10号节点的后继节点为："+rightNode);
        // 当线索化二叉树后，不能使用原来的遍历方式
        System.out.println("使用线索化的方式遍历线索化二叉树");
        binaryTree2.threadedList(); // 8,3,10,1,14,6
    }
}
// 线索化二叉树
class BinaryTree2{
    private HeroNode2 root; // 根节点
    // 前驱节点的辅助指针
    private HeroNode2 pre = null;

    public void setRoot(HeroNode2 root) {
        this.root = root;
    }

    // 方法重载
    public void threadedNodes(){
        this.threadedNodes(root);
    }

    // 遍历线索化二叉树的方法
    public void threadedList(){
        // 定义变量，存储当前遍历的节点
        HeroNode2 node = root;
        while(node!=null){
            // 循环的找到leftType=1的节点
            while(node.getLeftType()==0){
                node = node.getLeft();
            }
            // 打印当前节点
            System.out.println(node);
            // 如果当前节点的右指针指向后继系欸但，就一致输出
            while(node.getRightType()==1){
                // 拿到后继节点
                node = node.getRight();
                System.out.println(node);
            }
            // 替换遍历的节点
            node = node.getRight();
        }
    }

    // 编写中序线索化二叉树方法
    /**
     *
     * @param node  需要线索化的节点
     */
    public void threadedNodes(HeroNode2 node){
        // 判断是否为空
        if(node==null){
            return;
        }
        // 1. 先线索化左子树
        threadedNodes(node.getLeft());
        // 2. 线索化当前节点[有一定难度]
        // 先处理当前节点的前驱节点,这里是node
        if(node.getLeft()==null){
            // 当前节点的左指针指向前驱节点
            node.setLeft(pre);
            // 修改当前节点做指针的类型
            node.setLeftType(1);
        }
        // 处理后继节点，而这里是pre
        if(pre!=null && pre.getRight()==null){
            // 让当前节点的右指针指向当前节点
            pre.setRight(node);
            // 修改谦虚节点右指针类型
            pre.setRightType(1);
        }
        // 每处理一个节点后，让当前节点是下一个节点的前驱节点
        pre = node;
        // 3. 线索化右子树
        threadedNodes(node.getRight());
    }
}

// 创建HeroNode2
class HeroNode2 {
    private int no;
    private String name;
    private HeroNode2 left;  // 默认为null
    private HeroNode2 right; // 默认为null
    // 左属性 leftType=0表示指向左子树，如果是1表示指向前驱节点
    private int leftType;
    // 右属性 rightType=0表示指向右子树，如果是1表示指向后继节点
    private int rightType;

    public HeroNode2(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode2 getLeft() {
        return left;
    }

    public void setLeft(HeroNode2 left) {
        this.left = left;
    }

    public HeroNode2 getRight() {
        return right;
    }

    public void setRight(HeroNode2 right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + 
                '}';
    }
}