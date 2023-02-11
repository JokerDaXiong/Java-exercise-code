package com.jokerdig.recursion;

/**
 * @author Joker大雄
 * @data 2022/10/10 - 10:30
 **/
// 八皇后问题
public class EightEmpresses {
    // 定义max，存放皇后总数
    int max = 8;
    // 定义数组array，保存皇后放置结果
    int[] array = new int[max];
    // 统计摆放总数
    static int count = 0;
    public static void main(String[] args) {
        // 测试8皇后代码
        EightEmpresses empresses = new EightEmpresses();
        empresses.check(0);
        System.out.println("八皇后问题一共有"+count+"种正确摆法");
    }
    // 编写一个方法，放置第n个皇后
    // 特别注意：check的每一次递归，都有一个for循环，因此会有回溯
    private void check(int n){
       if(n==max){
           // n = 8，其实8个皇后就已经放好了
           print();
           return;
       }
       // 依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            // 先把当前这个皇后n，放到该行的第1列
            array[n] = i;
            // 判断当放置第n个皇后到i列时，是否冲突
            if(judge(n)){
                // 不冲突,接着放n+1个皇后
                check(n+1);
            }
            // 如果冲突，就继续回到array[n] = i执行，因为有i++，所以放到本行的后一列
        }
    }
    // 当我们放置第n个皇后，就去检测该皇后是否和之前摆放的皇后冲突
    /**
     *
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            // 说明：
            // 1. array[i] == array[n] 判断第n个皇后是否和前面的n-1个皇后在同一列
            // 2. Math.abs(n-i) == Math.abs(array[n]-array[i]) 判断第n个皇后是否和第i个皇后在同一斜线
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }
    // 编写一个方法，将皇后摆放位置输出
    private void print(){
        // 每打印一次，说明是一种摆放方法，count++统计
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+ " ");
        }
        System.out.println();
    }
}
