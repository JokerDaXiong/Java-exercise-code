package com.jokerdig.sparseArr;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/9/6 - 14:56
 **/
public class Demo01 {
    public static void main(String[] args) throws IOException {
        // 创建原始二维数组 11 * 11
        // 0表示没有棋子 1表示黑子 2表示蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        // 输出原始原始二维数组
        System.out.println("===============原始二维数组===============");
        for (int[] row : chessArr1) {
            for (int data : row) {
                // 格式化输出
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        // 将二维数组转为稀疏数组
        // 1. 遍历原始二维数组，得到非零数据的个数
        int num = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if(chessArr1[i][j]!=0){
                    // 拿到非零个数
                    num++;
                }
            }
        }
        // 2. 创建对应的稀疏数组
        int sparseArr1[][] = new int[num+1][3];
        // 给稀疏数组第一行赋值
        sparseArr1[0][0] = chessArr1.length; // 二维数组行
        sparseArr1[0][1] = chessArr1[0].length; // 二维数组列
        sparseArr1[0][2] = num; // 二维数组中有效值
        // 遍历二维数组，将非0的值存放到sparseArr1
        int count = 1; // 计数器
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if(chessArr1[i][j]!=0){
                  sparseArr1[count][0] = i;
                  sparseArr1[count][1] = j;
                  sparseArr1[count][2] = chessArr1[i][j];
                  count++;
                }
            }
        }
        // 通过IO流存放到本地D盘
        String str = "D:/chess.data";
        File file = new File(str);
        if(!file.exists()){
            // 文件不存在，就创建新的
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(str);
        // 输出稀疏数组，同时写入
        System.out.println("===============稀疏数组===============");
        for (int i = 0; i < sparseArr1.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",
                    sparseArr1[i][0],
                    sparseArr1[i][1],
                    sparseArr1[i][2]
            );
            fileWriter.write(sparseArr1[i][0]+"\t");
            fileWriter.write(sparseArr1[i][1]+"\t");
            fileWriter.write(sparseArr1[i][2]+"\n");
        }
        // 关闭流
        fileWriter.close();
        System.out.println("文件已存放：D/chess.data");

        // 将chess.data恢复为稀疏数组
        BufferedReader file1 = new BufferedReader(new FileReader(new File(str)));
        String line;  //存放文件中的每一行数据
        // 因为我们不知道文件大小，使用集合存放文件
        List<String> list = new ArrayList<>();
        // 循环读取的值不为空
        while((line = file1.readLine())!=null){
            list.add(line); // 存放到集合
        }
        // 关闭流
        file1.close();
        // 恢复稀疏数组
        // 创建新的稀疏数组
        int sparseArr2[][] = new int[list.size()][3];
        for (int i=0; i < list.size(); i++) {
            // 将list中每一个值按照空格切割，并储存到一个数组中
            String temp[]= list.get(i).split("\t");
            for (int j = 0; j < temp.length; j++) {
                sparseArr2[i][j] = Integer.parseInt(temp[j]);
            }
        }
        // 遍历恢复的稀疏数组
        System.out.println("===============恢复稀疏数组===============");
        for (int i = 0; i < sparseArr2.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",
                    sparseArr2[i][0],
                    sparseArr2[i][1],
                    sparseArr2[i][2]
            );
        }


        // 将稀疏数组恢复为原始二维数组
        int row1 = sparseArr2[0][0];
        int col1 = sparseArr2[0][1];
        int chessArr2[][] = new int[row1][col1];
        for (int i = 1; i <= sparseArr2[0][2]; i++) {

            chessArr2[sparseArr2[i][0]][sparseArr2[i][1]]=sparseArr2[i][2];
        }
        // 遍历回复的二维数组
        System.out.println("===============恢复的原始二维数组===============");
        for (int[] row : chessArr2) {
            for (int data : row) {
                // 格式化输出
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
