package com.jokerdig.syn;


/**
 * @author Joker大雄
 * @data 2021/8/22 - 12:15
 **/
//不安全的取钱
    //两个人同事去银行取一张卡里的钱
public class UnsafeBank {
    public static void main(String[] args) {
        //账户
        Account account = new Account(100,"结婚份子钱");

        Drawing you = new Drawing(account,50,"张三");
        Drawing wife = new Drawing(account,100,"wife");

        you.start();
        wife.start();

    }
}

//账户
class Account{
    int money;//余额
    String name;//卡号

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//银行:模拟取款
class Drawing extends Thread{
    Account account;//账户
    int drawingMoney;//取乐的钱
    int nowMoney;//剩余的钱


    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    //这种synchronized无法锁
    @Override
    public  void run() {
        //使用synchronized块,锁变化的量
        synchronized (account){
            //判断有没钱
            if(account.money-drawingMoney<0){
                System.out.println(Thread.currentThread().getName()+"的钱不够了");
                return;
            }
            //模拟延时
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("账户余额："+account.money);
            //卡内余额
            account.money=account.money-drawingMoney;
            //手里的钱
            nowMoney = nowMoney+drawingMoney;
            System.out.println(this.getName()+"手里的余额："+nowMoney);
            System.out.println("账户余额："+account.money);
        }
    }
}