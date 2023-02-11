package com.jokerdig.linkedlist;

/**
 * @author Joker大雄
 * @data 2022/9/29 - 9:51
 **/
public class Josephus {
    public static void main(String[] args) {
        // 测试构建和遍历
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);// 加入5个boy
        // circleSingleLinkedList.listBoy();// 遍历
        // 测试小孩出圈是否正确，例如：从1开始，每次数2，共有5个boy；
        circleSingleLinkedList.countBoy(1,2,5);

    }
}

// 创建环形单向链表
class CircleSingleLinkedList {
    // 创建一个first节点，当前没有编号
    private Boy first = null;

    // 添加boy节点，构建成一个环形链表
    public void addBoy(int nums){
        // nums数据校验
        if(nums < 1){
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null; // 定义辅助指针
        // 使用for循环创建环形链表
        for (int i = 1; i <= nums; i++) {
            // 根据编号创建boy节点
            Boy boy = new Boy(i);
            // 第一个boy比较特殊
            if(i==1){
                first = boy;
                first.setNext(first);// 构成环状
                curBoy = first; // 辅助指针指向first
            }else{
                curBoy.setNext(boy);// 当前的节点指向新添加的节点
                boy.setNext(first); // 新添加的boy指向first
                curBoy = boy; // curBoy移动到新添加的节点
                // 由上三个步骤形成环形
            }
        }
    }

    // 遍历环形链表
    public void listBoy(){
        // 判断链表是否为空
        if(first==null){
            System.out.println("链表为空");
            return;
        }
        // 定义辅助指针,指向first
        Boy curBoy = first;
        while(true){
            System.out.printf("boy的编号%d \n",curBoy.getNo());
            if(curBoy.getNext()==first){
                // 遍历完毕
                break;
            }
            curBoy = curBoy.getNext();// curBoy后移
        }
    }
    // 约瑟夫问题实现

    /**
     *
     * @param startNo 从第几个boy开始
     * @param countNum 报数几次
     * @param nums boy的总个数
     */
    public void countBoy(int startNo,int countNum,int nums){
        // 先对数据进行校验
        if(first==null || startNo<1 || startNo>nums){
            System.out.println("输入参数有误");
            return;
        }
        // 定义辅助指针
        Boy helper = first;
        // 辅助指针指向环形列表最后一个节点
        while(true){
            if(helper.getNext()==first){
                // 说明helper指向最后节点
                break;
            }
            // helper向后一位
            helper = helper.getNext();
        }
        // 先让first和helper移动k-1次
        for(int j = 0;j<startNo-1;j++){
            first = first.getNext();
            helper = helper.getNext();
        }
        // 当boy开始报数，让first和helper指针同时移动m-1次，然后出圈
        while(true) {
            if (helper == first) {
                // 说明圈中只有一个节点了
                break;
            }
            // 让first和helper指针同时移动countNum-1次，然后出圈
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            // first这时指向的节点就是要出圈的boy
            System.out.printf("boy%d出圈\n", first.getNo());
            // 将boy移出环形链表
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的boy为%d \n",first.getNo());
    }
}

// 创建一个Boy类，表示一个节点
class Boy{
    private int no; // 编号
    private Boy next; // 指向下个节点，默认null

    // 构造方法
    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}