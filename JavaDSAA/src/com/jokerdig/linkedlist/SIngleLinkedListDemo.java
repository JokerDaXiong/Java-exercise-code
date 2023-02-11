package com.jokerdig.linkedlist;

/**
 * @author Joker大雄
 * @data 2022/9/10 - 20:16
 **/
public class SIngleLinkedListDemo {
    public static void main(String[] args) {
        // 测试
        // 创建节点
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"武松","行者");
        HeroNode hero5 = new HeroNode(5,"林冲","豹子头");
        // 创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        // 加入链表
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero5);
        // 加入链表，按照编号顺序
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero5);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero3);
        // 显示链表
        singleLinkedList.list();
        // 测试修改
        singleLinkedList.update(new HeroNode(1,"不是松江","不是及时雨"));
        singleLinkedList.update(new HeroNode(7,"巴拉巴拉","巴拉巴拉"));
        // 查看修改后的链表
        System.out.println("============修改后的链表=============");
        singleLinkedList.list();

        // 测试删除
        singleLinkedList.delete(5);
        // 测试删除不存在编号
        singleLinkedList.delete(6);
        // 查看删除后的链表
        System.out.println("============删除后的链表=============");
        singleLinkedList.list();
    }

}
// 定义单链表SingleLinkedList，来管理我们的英雄
class SingleLinkedList{
    // 初始化一个head节点，一般不要动,也不存放数据
    private HeroNode head = new HeroNode(0,"","");

    // 添加节点到单向链表
    /*
        思路，当不考虑编号顺序时
        1. 找到当前链表的最后节点
        2. 将最后这个几点的next 执行新的节点
     */
    public void add(HeroNode heroNode){
        // head不能东，因此我们呢需要复制变量temp
        HeroNode temp = head;
        // 遍历链表，找到最后
        while(true){
            // 当next为null，说明到最后了
            if(temp.next==null){
                break;
            }
            // 如果没有找到,就将temp后移
            temp = temp.next;
        }
        // 当结束while循环时，temp指向链表最后
        temp.next = heroNode;
    }

    /*
        第二种方法，按照顺序添加
     */
    public void addByOrder(HeroNode heroNode){
        // 辅助变量
        HeroNode temp = head;
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

    // 修改链表信息,根据编号来修改
    public void update(HeroNode newHeroNode){
        // 判断是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        // 找到需要修改的节点，根据no编号
        // 定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false; // 表示是否找到该节点
        while(true){
            if(temp == null){
                break; // 到链表遍历完毕
            }
            if(temp.no == newHeroNode.no){
                // 找到要修改的节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 根据flag判断是否找到了要修改的节点
        if(flag){
            // 进行修改
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else{
            // 没有找到该节点
            System.out.println("编号为："+newHeroNode.no+"的英雄未在链表中找到");
        }
    }

    // 删除链表信息
    // temp辅助知道到删除节点的前一个
    // 比较的时候，是temp.next.no 和删除节点的no进行比较
    public void delete(int deleteNo){
        HeroNode temp = head;
        boolean flag = false;//是否找到
        while(true){
            if(temp.next == null){
                // 到链表末尾
                break;
            }
            if(temp.next.no == deleteNo){
                // 找到了待删除的节点的temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            // 找到了
            temp.next = temp.next.next;
        }else{
            System.out.println("要删除的节点"+deleteNo+"不存在");
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
        HeroNode temp = head.next;
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
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; // 指向下一个节点

    // 构造器
    public HeroNode(int no,String name,String hickname){
        this.no = no;
        this.name = name;
        this.nickname = hickname;
    }

    // toString
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname +
                '}';
    }
}