package com.jokerdig.binarySortTree;

/**
 * @author Joker大雄
 * @data 2022/11/12 - 10:42
 **/
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int [] arr = {7,3,10,12,5,1,9,2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for(int value:arr){
            // 创建二叉树
            binarySortTree.add(new Node(value));
        }
        // 遍历
        binarySortTree.infixOrder();

        // 测试删除叶子节点
        // binarySortTree.delNode(2);
        // System.out.println("删除叶子节点2后的二叉排序树");
        // binarySortTree.infixOrder();

        // 删除有一棵子树的节点
        // binarySortTree.delNode(1);
        // System.out.println("删除有一棵子树的节点的二叉排序树");
        // binarySortTree.infixOrder();

        // 删除有两棵子树的节点
        // binarySortTree.delNode(3);
        // System.out.println("删除有两棵子树的节点的二叉排序树");
        // binarySortTree.infixOrder();

        // 测试删除根节点是否空指针
         binarySortTree.delNode(7);
         System.out.println("删除根节点后的二叉排序树");
         binarySortTree.infixOrder();
    }
}
// 创建二叉排序树
class BinarySortTree{
    private Node root;
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
    // 查找要删除的节点
    public Node search(int value){
        if(root == null){
            return null;
        }else{
            return root.search(value);
        }
    }

    // 查找父节点
    public Node searchParent(int value){
        if(root == null){
            return null;
        }else{
            return root.searchParent(value);
        }
    }
    // 删除节点
    public void delNode(int value){
        if(root==null){
            return;
        }else{
            // 先去找到要删除的节点 targetNode
            Node targetNode = search(value);
            // 如果没找到要删除的节点
            if(targetNode == null){
                return;
            }
            // 如果当前只剩一个节点
            if(root.left == null && root.right == null){
                root = null;
                return;
            }
            // 去找到targetNode的父节点
            Node parent = searchParent(value);
            // 如果要删除的节点是叶子节点
            if(targetNode.left == null && targetNode.right == null){
                // 判断targetNode是父节点的左子节点，还是右子节点
                if(parent.left != null && parent.left.value ==value){ // 是父节点的左子节点
                    parent.left = null; // 删除
                }else if(parent.right !=null && parent.right.value == value){// 是父节点的右子节点
                    parent.right = null; // 删除
                }
            }else if(targetNode.left!=null && targetNode.right!=null){ // 删除有两棵子树的节点
                int min = delRightTreeMin(targetNode.right);// 从右子树开始找最小值(或者左子树开始找最大值)
                targetNode.value = min;
            }else{ // 删除只有一棵子树的节点
                // 如果要删除的节点有左子节点
                if(targetNode.left!=null){
                   if(parent!=null){ // 防止删除根节点空指针
                       // 如果targetNode是parent的左子节点
                       if(parent.left.value == value){
                           parent.left = targetNode.left;
                       }else{// 如果targetNode是parent的右子节点
                           parent.right = targetNode.left;
                       }
                   }else{
                       root = targetNode.left; // 让根节点指向待删除节点的左子树
                   }
                } else{// 如果要删除的节点有右子节点
                    if(parent!=null) { // 防止删除根节点空指针
                        // 如果targetNode是parent的左子节点
                        if(parent.left.value == value){
                            parent.left = targetNode.right;
                        }else{// 如果targetNode是parent的右子节点
                            parent.right = targetNode.right;
                        }
                    }else{
                        root = targetNode.right; // 让根节点指向待删除节点的右子树
                    }

                }
            }
        }
    }
    // 返回以node为根节点的二叉排序树最小节点的值，并删除该节点
    /**
     *
     * @param node 传入的节点，当作二叉排序树的根节点
     * @return 返回以node为根节点的二叉排序树最小节点的值
     */
    public int delRightTreeMin(Node node){
        Node target = node;
        // 循环查找左节点，就会找到最小值
        while(target.left!=null){
            target = target.left;
        }
        // 这时，target就指向了最小节点
        // 删除最小节点
        delNode(target.value);
        return target.value;
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
    // 查找要删除的节点
    /**
     *
     * @param value 要删除的节点的值
     * @return  如果找到，返回该节点，否则返回null
     */
    public Node search(int value){
        if(value == this.value){// 找到就是该节点
            return this;
        }else if(value < this.value){// 如果查找的值小于当前节点，就向左子树递归查找
            // 如果左子节点为空
            if(this.left == null){
                return null;
            }
            return this.left.search(value);
        }else{
            // 如果查找的值不小于当前节点，就向右子树递归查找
            if(this.right == null){
                return null;
            }
            return this.right.search(value);
        }
    }

    // 查找要删除节点的父节点
    /**
     *
     * @param value  要查找的节点的值
     * @return  返回要删除节点的父节点，没有返回null
     */
    public Node searchParent(int value){
        // 如果当前节点就是要删除节点的父节点，就返回
        if((this.left != null && this.left.value == value) || (this.right!=null && this.right.value == value)){
            return this;
        }else{
            // 如果查找的值小于当前节点的值，并且当前节点的左子节点不为空
            if(value < this.value && this.left!=null){
                return this.left.searchParent(value); // 向左子树递归查找
            } else if(value >= this.value && this.right!=null){
                return this.right.searchParent(value); // 向右子树递归查找
            } else{
                return null; // 没有找到父节点
            }
        }
    }
    // 二叉排序树添加节点
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
