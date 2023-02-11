package com.jokerdig.linkedlist;

import java.util.Stack;

/**
 * @author Joker大雄
 * @no 2022/9/12 - 10:58
 **/
public class SingleLinkedListTest1 {
    public static void main(String[] args) {
        // 测试
        // 创建节点
        HeroNode1 hero1 = new HeroNode1(1,"宋江","及时雨");
        HeroNode1 hero2 = new HeroNode1(2,"卢俊义","玉麒麟");
        HeroNode1 hero3 = new HeroNode1(3,"吴用","智多星");
        HeroNode1 hero4 = new HeroNode1(4,"武松","行者");
        HeroNode1 hero5 = new HeroNode1(5,"林冲","豹子头");
        // 创建链表
        SingleLinkedhead1 singleLinkedList = new SingleLinkedhead1();
        SingleLinkedhead1 singleLinkedhead1 = new SingleLinkedhead1();
        // 加入链表，按照编号顺序
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero5);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        // 加入链表1，按照编号顺序
        singleLinkedhead1.addByOrder(hero1);
        singleLinkedhead1.addByOrder(hero5);
        singleLinkedhead1.addByOrder(hero2);
        singleLinkedhead1.addByOrder(hero4);
        singleLinkedhead1.addByOrder(hero3);
        // 显示链表
        System.out.println("==============链表1===============");
        singleLinkedList.list();
        System.out.println("==============链表2===============");
        singleLinkedhead1.list();

        // 测试第一题调用遍历方法
        // System.out.println("有"+getLength(singleLinkedList.getHead())+"个有效节点");
        // 测试第二题,找到倒数第一个
        // HeroNode1 res = findLastIndexNode(singleLinkedList.getHead(),1);
        // System.out.println("res="+res);
        // 测试第三题
        // reverseList(singleLinkedList.getHead());
        // System.out.println("===========反转后的链表信=========");
        // singleLinkedList.list();
        // 测试第四题
        // System.out.println("===========使用栈实现逆序打印单链表=========");
        // reversePrint(singleLinkedList.getHead());
    }
    // 求单链表中有效节点的个数(如果带头节点需要不统计)
    /**
     *
     * @param head 链表的头节点
     * @return 有效节点的个数
     */
    public static int getLength(HeroNode1 head){
        if(head.next == null){
            // 这是空列表
            return 0;
        }
        int length = 0;
        // 定义一个辅助的变量
        HeroNode1 cur = head.next;
        while(cur!=null){
            length++;
            cur = cur.next;
        }
        return length;
    }

    // 第二题：查找查找单链表中的倒数第k个节点
    public static HeroNode1 findLastIndexNode(HeroNode1 head,int index){
        // 判断链表是否为空
        if(head.next == null){
            return null;
        }
        // 第一个遍历得到链表的长度
        int size = getLength(head);
        // 第二次遍历 size-index位置，就是倒数第K个节点
        // 先做一个index校验
        if(index <= 0|| index>size){
            return null;
        }
        // 定义一个辅助变量
        HeroNode1 cur = head.next;
        // for循环定位到index
        for (int i = 0; i < size - index; i++) {
            cur = cur.next; // 向后移动
        }
        return cur;
    }

    // 第三题 将单链表反转
    public static void reverseList(HeroNode1 head){
        // 如果当前链表为空，或只有一个节点，不需要反转
        if(head.next == null || head.next.next == null){
            return ;
        }
        // 定义辅助指针，帮我们遍历原来的链表
        HeroNode1 cur = head.next;
        HeroNode1 next = null; // 指向当前节点cur的下一个节点
        HeroNode1 reverseHead = new HeroNode1(0,"","");
        // 遍历原来的链表,并从头到尾遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表的最前端；
        while(cur!=null){
            next = cur.next;// 暂时保存当前节点的下一个节点
            cur.next = reverseHead.next;// 将cur的下一个节点指向新链表最前端
            reverseHead.next = cur; // 将cur连接到新的链表上
            cur = next; // 让cur后移
        }
        // 将head.next指向reverseHead.next,实现了单链表的反转
        head.next = reverseHead.next;
    }

    // 第四题：从尾到头打印单链表，使用方式2
    public static void reversePrint(HeroNode1 head){
        if(head.next == null){
            return ; // 空链表
        }
        // 创建一个栈，将链表各个节点放入栈中
        Stack<HeroNode1> stack = new Stack<HeroNode1>();
        HeroNode1 cur = head.next;
        // 将链表所有节点压入栈
        while(cur!=null){
            stack.push(cur);//节点压入栈
            cur = cur.next; // 后移
        }
        // 将栈中节点打印 pop
        while(stack.size()>0){
            System.out.println(stack.pop());// 先进后出
        }
    }
}
// 定义单链表SingleLinkedList，来管理我们的英雄
class SingleLinkedhead1{
    // 初始化一个head节点，一般不要动,也不存放数据
    private HeroNode1 head = new HeroNode1(0,"","");
    // 返回头节点
    public HeroNode1 getHead() {
        return head;
    }

    /*
            第二种方法，按照顺序添加
         */
    public void addByOrder(HeroNode1 heroNode){
        // 辅助变量
        HeroNode1 temp = head;
        // 因为是单链表，所有我们找的时位于添加位置的前一个节点
        boolean flag = false; // 添加的编号是否存在，默认为false
        while(true){
            if(temp.next == null){
                // temp已经在链表的最后
                break;
            }
            if(temp.next.no>heroNode.no){
                // 说明添加位置就在temp的后面
                break;
            }else if(temp.next.no == heroNode.no){
                // 说明这个位置已经有hero存在了，不能再添加
                flag = true;
                break;
            }
            temp = temp.next; // 后移
        }
        // 判断flag的值
        if(flag){
            // 不能添加，编号已经存在
            System.out.println("该英雄编号"+heroNode.no+"已经存在");
        }else{
            // 可以添加到链表中，再temp后
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    // 显示链表(遍历)
    public void list(){
        // 判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        // 头节点不动，因此我们需要一个辅助变量来遍历
        HeroNode1 temp = head.next;
        while(true){
            // 判断是否到链表末尾
            if(temp == null){
                break;
            }
            // 输出节点的信息
            System.out.println(temp);
            // 输出信息后，需要将temp后移
            temp = temp.next;
        }
    }
}
// 创建HeroNode,每个HeroNode对象就是一个节点
class HeroNode1{
    public int no;
    public String name;
    public String nickname;
    public HeroNode1 next; // 指向下一个节点

    // 构造器
    public HeroNode1(int no,String name,String hickname){
        this.no = no;
        this.name = name;
        this.nickname = hickname;
    }

    // toString
    @Override
    public String toString() {
        return "HeroNode1{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname +
                '}';
    }
}
