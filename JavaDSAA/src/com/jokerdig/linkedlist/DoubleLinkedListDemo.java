package com.jokerdig.linkedlist;

/**
 * @author Joker大雄
 * @data 2022/9/28 - 11:03
 **/
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("========双向链表的测试========");
        // 创建节点
        HeroNodeDouble hero1 = new HeroNodeDouble(1,"宋江","及时雨");
        HeroNodeDouble hero2 = new HeroNodeDouble(2,"卢俊义","玉麒麟");
        HeroNodeDouble hero3 = new HeroNodeDouble(3,"吴用","智多星");
        HeroNodeDouble hero4 = new HeroNodeDouble(4,"武松","行者");
        HeroNodeDouble hero5 = new HeroNodeDouble(5,"林冲","豹子头");
        // 创建一个双向链表对象
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        // 添加测试节点对象
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.add(hero5);

        // 遍历测试
        doubleLinkedList.list();

        // 修改测试2号
        doubleLinkedList.update(new HeroNodeDouble(2,"公孙胜","入云龙"));
        System.out.println("========修改节点后的双向链表========");
        doubleLinkedList.list();

        // 测试删除3号
        doubleLinkedList.delete(3);
        System.out.println("========删除节点后的双向链表========");
        doubleLinkedList.list();



    }
}
// 双向链表增删改查功能
class DoubleLinkedList{
    // 初始化一个head节点，一般不要动,也不存放数据
    private HeroNodeDouble head = new HeroNodeDouble(0,"","");

    // 返回头节点
    public HeroNodeDouble getHead() {
        return head;
    }

    // 显示链表(遍历)
    public void list(){
        // 判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        // 头节点不动，因此我们需要一个辅助变量来遍历
        HeroNodeDouble temp = head.next;
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

    // 添加节点到双向链表
    public void add(HeroNodeDouble heroNode){
        // head不动，因此我们呢需要复制变量temp
        HeroNodeDouble temp = head;
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
        // temp.next指向要添加的新节点
        temp.next = heroNode;
        // 把添加的新节点heroNode.pre指向temp
        heroNode.pre = temp;
    }

    // 修改双向链表的节点
    public void update(HeroNodeDouble newHeroNode){
        // 判断是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        // 找到需要修改的节点，根据no编号
        // 定义一个辅助变量
        HeroNodeDouble temp = head.next;
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

    // 删除双向链表中一个节点
    // 对于双向链表，我们可以直接找到要删除的节点，找到后自我删除
    public void delete(int deleteNo){
        // 判断当前链表是否为空
        if(head.next == null){
            System.out.println("链表为空，无法删除");
            return;
        }
        // 辅助变量(指针)
        HeroNodeDouble temp = head.next;
        boolean flag = false;//是否找到
        while(true){
            if(temp == null){
                // 到链表末尾节点的next
                break;
            }
            if(temp.no == deleteNo){
                // 找到了待删除的节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            // 找到了,双向链表来删除
            // 待删除节点的前一个节点指向待删除节点后一个节点
            temp.pre.next = temp.next;
            // 如果删除的是最后一个节点，就不需要指向下方的步骤，否则会出现空指针异常
            // 待删除节点的后一个节点的pre指向待删除节点的前一个节点
            if(temp.next!=null){
                temp.next.pre = temp.pre;
            }
        }else{
            System.out.println("要删除的节点"+deleteNo+"不存在");
        }
    }
}

// 创建HeroNode,每个HeroNode对象就是一个节点
class HeroNodeDouble{
    public int no;
    public String name;
    public String nickname;
    public HeroNodeDouble next; // 指向下一个节点
    public HeroNodeDouble pre; // 指向前一个节点

    // 构造器
    public HeroNodeDouble(int no,String name,String hickname){
        this.no = no;
        this.name = name;
        this.nickname = hickname;
    }

    // toString
    @Override
    public String toString() {
        return "HeroNodeDouble{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname +
                '}';
    }
}