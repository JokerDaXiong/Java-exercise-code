package com.algorithm.divideAndConquer;

/**
 * @author Joker大雄
 * @data 2022/11/24 - 10:58
 **/
public class HanoiTower {
    public static void main(String[] args) {
        System.out.println("汉诺塔3个盘移动步骤：");
        hanoiTower(3,'A','B','C');
    }

    // 汉诺塔移动方法(分治算法)
    public static void hanoiTower(int n,char A,char B,char C){
        // 如果只有一个盘，直接从A移动到C
        if(n==1){
            System.out.println("第"+n+"个盘从"+A+"->"+C);
        }else if(n>1){
            // 如果有n>=2，可以总可以看作是两个部分：
            // 最下面的盘 和 最下面的盘向上的所有盘
            // 先把最上面的盘A->B；移动过程使用到C塔
            hanoiTower(n-1,A,C,B);
            // 把最下面的盘A->C；
            System.out.println("第"+n+"个盘从"+A+"->"+C);
            // 把B塔的所有盘从B->C；移动过程使用到A塔
            hanoiTower(n-1,B,A,C);

        }else{
            System.out.println("汉诺塔盘为空");
        }
    }
}
