package com.jokerdig.tree;

/**
 * @author Joker大雄
 * @data 2022/10/28 - 9:24
 **/
public class BinaryTreeDemo {
    public static void main(String[] args) {
        // 现需要创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        // 创建需要的节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "武松");
        HeroNode node5 = new HeroNode(5, "关胜");
        // 二叉树应该使用创建为递归创建，这里我们先手动创建
        root.setLeft(node2); // root左侧添加
        root.setRight(node3);// root右侧添加
        node3.setLeft(node5);
        node3.setRight(node4);
        binaryTree.setRoot(root);
        // 测试
        /*
        System.out.println("前序遍历");
        binaryTree.preOrder();
        System.out.println("中序遍历");
        binaryTree.infixOrder();
        System.out.println("后序遍历");
        binaryTree.postOrder();
         */
        // 测试查找5号节点
        // 前序遍历查找4次
        /*
        System.out.println("=======前序遍历查找=======");
        HeroNode heroNode = binaryTree.preOrderSearch(5);
        if(heroNode!=null){
            System.out.printf("找到：no=%d name=%s\n",heroNode.getNo(),heroNode.getName());
        }else{
            System.out.printf("没有 no=%d 的节点\n",5);
        }
        // 中序遍历查找3次
        System.out.println("=======中序遍历查找=======");
        HeroNode heroNode2 = binaryTree.infixOrderSearch(5);
        if(heroNode2!=null){
            System.out.printf("找到：no=%d name=%s\n",heroNode2.getNo(),heroNode2.getName());
        }else{
            System.out.printf("没有 no=%d 的节点\n",5);
        }
        // 后序遍历查找2次
        System.out.println("=======后序遍历查找=======");
        HeroNode heroNode3 = binaryTree.postOrderSearch(5);
        if(heroNode3!=null){
            System.out.printf("找到：no=%d name=%s\n",heroNode3.getNo(),heroNode3.getName());
        }else{
            System.out.printf("没有 no=%d 的节点\n",5);
        }
         */
        // 测试删除5号叶子节点和3号树
        System.out.println("==========删除5号叶子节点==========");
        System.out.println("删除前，前序遍历");
        binaryTree.preOrder();
        // 删除
        binaryTree.delNode(5);
        System.out.println("删除后，前序遍历");
        binaryTree.preOrder();

        System.out.println("==========删除3号树==========");
        System.out.println("删除前，前序遍历");
        binaryTree.preOrder();
        // 删除
        binaryTree.delNode(3);
        System.out.println("删除后，前序遍历");
        binaryTree.preOrder();
    }
}
// 定义BinaryTree二叉树
class BinaryTree{
    private HeroNode root; // 根节点

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    // 前序遍历
    public void preOrder(){
        if(this.root!=null){
            this.root.preOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }

    // 中序遍历
    public void infixOrder(){
        if(this.root!=null){
            this.root.infixOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }
    // 后序遍历
    public void postOrder(){
        if(this.root!=null){
            this.root.postOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }
    // 前序遍历查找
    public HeroNode preOrderSearch(int no){
        if(root!=null){
            return root.preOrderSearch(no);
        }else{
            return null;
        }
    }
    // 中序遍历查找
    public HeroNode infixOrderSearch(int no){
        if(root!=null){
            return root.infixOrderSearch(no);
        }else{
            return null;
        }
    }
    // 后序遍历查找
    public HeroNode postOrderSearch(int no){
        if(root!=null){
            return root.postOrderSearch(no);
        }else{
            return null;
        }
    }
    // 删除节点
    public void delNode(int no){
        if(root!=null){
           // 这里需要判断root是否为空
            if(root.getNo()==no){
                root = null;
            }else{
                // 递归删除
                root.delNode(no);
            }
        }else{
            System.out.println("二叉树为空");
        }
    }
}
// 先创建节点 HeroNode
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;  // 默认为null
    private HeroNode right; // 默认为null

    public HeroNode(int no, String name) {
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

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
    // 前序遍历
    public void preOrder(){
        System.out.println(this); // 先输出父节点
        // 递归向左子树前序遍历
        if(this.left!=null){
            this.left.preOrder();
        }
        // 递归向右子树前序遍历
        if(this.right !=null){
            this.right.preOrder();
        }
    }
    // 中序遍历
    public void infixOrder(){
        // 递归向左子树中序遍历
        if(this.left!=null){
            this.left.infixOrder();
        }
        // 输出当前节点
        System.out.println(this);
        // 递归向右子树中序遍历
        if(this.right!=null){
            this.right.infixOrder();
        }
    }
    // 后序遍历
    public void postOrder(){
        // 递归向左子树后序遍历
        if(this.left!=null){
            this.left.postOrder();
        }

        // 递归向右子树后序遍历
        if(this.right!=null){
            this.right.postOrder();
        }
        // 输出当前节点
        System.out.println(this);
    }

    // 定义一个节点
    private HeroNode node = null;
    // 前序遍历查找
    /**
     *
     * @param no 编号
     * @return 返回查找到的节点，没找到返回null
     */
    public HeroNode preOrderSearch(int no){
        System.out.println("进入前序遍历查找");
        // 比较当前节点是否要找到
        if(this.no == no){
            return this;
        }
        // 判断当前节点的左子节点是否为空，若不为空，则左递归前序查找
        // 找到节点就返回
        if(this.left!=null){
            node = this.left.preOrderSearch(no);
        }
        if(node!=null){
            // 在左子节点找到了要查找的节点
            return node;
        }
        // 继续判断当前节点的右子节点是否为空，
        // 若不为空，则继续右递归前序查找
        if(this.right!=null){
            node = this.right.preOrderSearch(no);
        }
        return node;
    }
    // 中序遍历查找
    public HeroNode infixOrderSearch(int no){
        // 先判断当前节点的左子节点是否为空，
        // 若不为空，则左递归中序查找；找到节点就返回
        if(this.left!=null){
            node = this.left.infixOrderSearch(no);
        }
        if(node!=null){
            return node;
        }
        // 判断是否和当前节点相等
        System.out.println("进入中序遍历查找");
        if(this.no == no){
            return this;
        }
        // 判断右子节点是否为空，不为空就右递归中序查找，找到节点就返回
        if(this.right!=null){
            node = this.right.infixOrderSearch(no);
        }
        return node;
    }
    // 后序遍历查找
    public HeroNode postOrderSearch(int no){
        // 判断当前节点的左子节点是否为空，
        // 若不为空，则左递归后序查找，找到节点就返回
        if(this.left!=null){
            node = this.left.postOrderSearch(no);
        }
        if(node!=null){
            return node;
        }
        // 判断当前节点的右子节点是否为空，
        // 若不为空，则继续右递归后序查找，找到节点就返回
        if(this.right!=null){
            node = this.right.postOrderSearch(no);
        }
        if(node!=null){
            return node;
        }
        // 判断当前节点是否等于要查找的节点，如果相等就返回当前节点
        System.out.println("进入后序遍历查找");
        if(this.no == no){
            return this;
        }
        return null;
    }
    // 递归删除节点
    public void delNode(int no){
        // 左子节点不为空且为待删除节点
        if(this.left!=null && this.left.no == no){
            this.left = null; //置空左节点
            return;
        }
        // 右子节点不为空且为待删除节点
        if(this.right!=null && this.right.no == no){
            this.right = null; //置空右节点
            return;
        }
        // 向左子树递归删除
        if(this.left!=null){
            this.left.delNode(no);
        }
        // 向右子树递归删除
        if(this.right!=null){
            this.right.delNode(no);
        }
    }
}
