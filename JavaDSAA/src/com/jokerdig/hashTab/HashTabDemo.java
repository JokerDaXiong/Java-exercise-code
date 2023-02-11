package com.jokerdig.hashTab;

import java.util.Scanner;

/**
 * @author Joker大雄
 * @data 2022/10/26 - 8:25
 **/
public class HashTabDemo {
    public static void main(String[] args) {
        // 创建哈希表
        HashTab hashTab = new HashTab(7);
        // 写一个菜单测试
        String key = "";
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while (flag){
            System.out.println("==========HashTab雇员信息管理=============");
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("find:查找雇员");
            System.out.println("delete:删除雇员");
            System.out.println("update:修改雇员");
            System.out.println("exit:退出");
            System.out.print("请输入要测试的功能:");
            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("请输入ID");
                    int id = scanner.nextInt();
                    System.out.println("请输入性别(1或0)");
                    int sex = scanner.nextInt();
                    System.out.println("请输入姓名");
                    String name = scanner.next();
                    System.out.println("请输入地址");
                    String address = scanner.next();
                    // 创建雇员
                    Emp emp = new Emp(id,sex,name,address);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的雇员ID");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "delete":
                    System.out.println("请输入要删除的雇员ID");
                    id = scanner.nextInt();
                    hashTab.delete(id);
                    break;
                case "update":
                    System.out.println("请输入要修改雇员的ID");
                    id = scanner.nextInt();
                    System.out.println("请输入要修改雇员的性别(1或0)");
                    sex = scanner.nextInt();
                    System.out.println("请输入要修改雇员的姓名");
                    name = scanner.next();
                    System.out.println("请输入要修改雇员的地址");
                    address = scanner.next();
                    // 创建雇员
                    emp = new Emp(id,sex,name,address);
                    hashTab.update(emp);
                    break;
                case "exit":
                    flag = false;
                    scanner.close();
                    break;
                default:
                    break;
            }
        }
    }
}
// 创建HashTab，管理多条链表
class HashTab{
    private EmpLinkedList[] empLinkedList;
    private int size;
    // 构造器
    public HashTab(int size){
        this.size = size;
        // 初始化empLinkedList
        empLinkedList = new EmpLinkedList[size];
        // 初始化empLinkedList之后，不要忘了分别初始化每一条链表
        for (int i = 0; i < size; i++) {
            empLinkedList[i] = new EmpLinkedList();
        }
    }
    // 添加雇员
    public void add(Emp emp){
        // 根据员工id,得到该员工应该添加到哪条链表；
        int empLinkedListNo = hashFun(emp.id);
        // 将emp添加到对应的链表中
        empLinkedList[empLinkedListNo].add(emp);
    }
    // 遍历
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedList[i].list(i);
        }
    }
    // 查找雇员
    public void findEmpById(int id){
        // 使用散列函数确定到哪条链表查找
        int empLinkedListNo = hashFun(id);
        // 将emp添加到对应的链表中
        Emp emp = empLinkedList[empLinkedListNo].findEmpById(id);
        if(emp==null){
            System.out.println("没有找到该雇员");
        }else{
            System.out.println("在第"+(++empLinkedListNo)+"条链表中找到该雇员信息");
        }
    }
    // 删除雇员
    public void delete(int id){
        // 使用散列函数确定到哪条链表查找
        int empLinkedListNo = hashFun(id);
        // 调用删除
        boolean back = empLinkedList[empLinkedListNo].delete(id);
        if(back){
            System.out.println("雇员信息删除成功");
        }else{
            System.out.println("雇员信息删除失败");
        }
    }
    // 修改雇员信息
    public void update(Emp emp){
        // 使用散列函数确定到哪条链表查找
        int empLinkedListNo = hashFun(emp.id);
        // 调用修改
        boolean back = empLinkedList[empLinkedListNo].update(emp);
        if(back){
            System.out.println("雇员信息修改成功");
        }else{
            System.out.println("雇员信息修改失败");
        }
    }
    // 编写散列函数，使用一个简单取模法
    public int hashFun(int id){
        return id % size;
    }
}
// 表示雇员
class Emp{
    public int id;
    public int sex; // 1代表男，0代表女
    public String name;
    public String address;
    public Emp next; // 默认为null
    // 构造器
    public Emp(int id, int sex, String name, String address) {
        this.id = id;
        this.sex = sex;
        this.name = name;
        this.address = address;
    }
}
// 创建EmpLinkedList，表示链表
class EmpLinkedList{
    // 头指针，执行第一个Emp，这个链表的head是直接指向第一个Emp
    private Emp head; // 默认为null

    // 添加雇员
    // 添加雇员的时候，id自增；
    // 因此我们将该雇员直接加入到本链表最后
    public void add(Emp emp){
        // 如果是添加第一个雇员
        if(head == null){
            head = emp;
            return;
        }
        // 如果不是添加第一个雇员，则使用一个辅助指针，帮助定位
        Emp curEmp = head;
        while(true){
            if(curEmp.next==null){
                // 到链表最后了
                break;
            }
            curEmp = curEmp.next;// 后移
        }
        // 退出时直接将emp加入链表
        curEmp.next = emp;
    }
    // 遍历雇员链表
    public void list(int no){
        if(head==null){
            System.out.println("第 "+(++no)+" 条链表为空");
            return;
        }
        System.out.print("第 "+(++no)+" 条链表信息为：");
        Emp curEmp = head; //辅助指针
        while (true){
            System.out.printf("=> ID=%d sex=%d name=%s address=%s\t",curEmp.id, curEmp.sex,curEmp.name,curEmp.address);
            if(curEmp.next==null){
                // 到最后节点了
                break;
            }
            curEmp = curEmp.next; // 后移
        }
        System.out.println();
    }
    // 根据ID查找雇员
    // 如果找到就返回Emp，没找到就返回null
    public Emp findEmpById(int id){
        // 判断链表是否为空
        if(head == null){
            System.out.println("链表为空");
            return null;
        }
        // 辅助指针
        Emp curEmp = head;
        while(true){
            if(curEmp.id == id){
                // 找到了
                break;
            }
            // 退出
            if(curEmp.next == null){
                // 遍历结束且没找到该雇员
                curEmp = null;
                break;
            }
            curEmp = curEmp.next; // 后移
        }
        return curEmp;
    }
    // 删除雇员
    public boolean delete(int id){
        boolean flag = false;
        // 判断链表是否为空
        if(head == null){
            System.out.println("链表为空");
            return false;
        }
        // 辅助指针
        Emp curEmp = head;
        while(true){
            if(curEmp.id == id){
                //找到了,通过head删除
                head = curEmp;
                head = null;
                flag = true;
                break;
            }
            // 退出
            if(curEmp.next == null){
                // 遍历结束且没找到该雇员
                break;
            }
            curEmp = curEmp.next;// 后移
        }
        return flag;
    }
    // 修改雇员信息
    public boolean update(Emp emp){
        boolean flag = false;
        // 判断链表是否为空
        if(head == null){
            System.out.println("链表为空");
            return false;
        }
        // 辅助指针
        Emp curEmp = head;
        while(true){
            if(curEmp.id == emp.id){
                //找到了,进行修改
                head = curEmp;
                head = emp;
                flag = true;
                break;
            }
            // 退出
            if(curEmp.next == null){
                // 遍历结束且没找到该雇员
                break;
            }
            curEmp = curEmp.next;// 后移
        }
        return flag;
    }
}
