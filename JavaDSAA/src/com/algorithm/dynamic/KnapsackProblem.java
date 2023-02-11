package com.algorithm.dynamic;

/**
 * @author Joker大雄
 * @data 2022/11/25 - 13:30
 **/
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1,4,3}; // 物品重量
        int[] val = {1500,3000,2000}; // 物品的价值
        int m = 4; // 背包的容量
        int n = val.length; // 物品的个数
        // 创建二维数组
        // v[i][j] 表示在前 i个物品中，
        // 能够装入容量为 j 的背包中的最大价值
        int[][] v = new int[n+1][m+1];
        // 为了记录放入商品情况，我们定义二维数组
        int[][] path = new int[n+1][m+1];

        // 初始化第一行和第一列(该步骤可以省略)
        for(int i = 0;i < v.length;i++){
            v[i][0] = 0; // 将第一列设置为0
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;// 将第一行设置为0
        }
        // 根据之前得到公式，来动态规划处理
        for (int i = 1; i < v.length; i++) { // 不处理第一行
            for (int j = 1; j < v[0].length; j++) {// 不处理第一列
                // 公式
                // 我们推导是从0开始的，但是这里我们从1开始
                // 所以w[i]应该为w[i-1]
                if(w[i-1] > j){
                    v[i][j] = v[i-1][j];
                }else{
                    // 因为我们的i是从1开始，因此公式需要如下调整
                    // v[i][j] = Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                    // 为了记录商品的信息，需要对上方的公式进行调整
                    if(v[i-1][j] < val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j] = val[i-1]+v[i-1][j-w[i-1]];
                        // 记录当前情况到path
                        path[i][j] = 1;
                    }else{
                        v[i][j] =v[i-1][j];
                    }
                }
            }
        }
        // 遍历打印v[][]
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j]+" ");
            }
            System.out.println();
        }
        // 输出存入的物品信息，这样输出会有信息冗余
        /*
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[i].length; j++) {
                if(path[i][j] == 1){
                    System.out.printf("第%d个物品放入背包\n",i);
                }
            }
        }
         */
        // 放入很多次，但只有最后那一次是我们需要的
        int maxRow = path.length-1; // 先求出path行的最大下标
        int maxCol = path[0].length-1; // 求出path列的最大下标
        System.out.println("----------------------------------");
        while(maxRow> 0 && maxCol > 0){// path从最后开始往前遍历
            if(path[maxRow][maxCol]==1){
                System.out.printf("第%d个物品放入背包\n",maxRow);
                maxCol -= w[maxRow-1]; // 调整背包容量
            }
            maxRow--; // 遍历下一个
        }
    }
}
