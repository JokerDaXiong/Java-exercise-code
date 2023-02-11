package com.algorithm.floyd;

import java.util.Arrays;

/**
 * @author Joker大雄
 * @data 2022/12/1 - 11:36
 **/
public class FloydAlgorithm {
    public static void main(String[] args) {
        // 测试图是否创建成功
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        // 邻接矩阵创建
        int[][] matrix = new int[vertex.length][vertex.length];
        // 无法关联
        final int N = 65535;
        matrix[0] = new int[]{0, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, 0, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, 0, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, 0, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, 0, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, 0, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, 0};

        // 创建Graph对象
        Graph graph = new Graph(vertex.length, matrix, vertex);
        // 弗洛伊德算法测试
        graph.floyd();
        // 遍历
        graph.show();
    }
}

// 创建图
class Graph {
    private char[] vertex; //顶点
    private int[][] dis; // 保存从各个顶点出发到其他顶点的距离
    private int[][] pre; //保存到达目标顶点的前驱顶点

    // 构造器

    /**
     * @param length 长度
     * @param matrix 邻接矩阵
     * @param vertex 顶点数组
     */
    public Graph(int length, int[][] matrix, char[] vertex) {
        this.vertex = vertex;
        this.dis = matrix;
        this.pre = new int[length][length];
        // 对pre数组进行初始化
        for (int i = 0; i < length; i++) {
            Arrays.fill(pre[i], i);
        }
    }

    // 显示dis和pre
    public void show() {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        for (int i = 0; i < dis.length; i++) {
            // 先输出pre
            for (int j = 0; j < dis.length; j++) {
                System.out.print(vertex[pre[i][j]] + " ");
            }
            System.out.println();
            // 输出dis
            for (int j = 0; j < dis.length; j++) {
                System.out.print("(" + vertex[i] + "到" + vertex[j] + "的最短路径:" + dis[i][j] + ") ");
            }
            System.out.println();
        }
    }

    // 弗洛伊德算法
    public void floyd() {
        int len = 0; // 记录变量保存距离
        // 从中间顶点的遍历[A,B,C,D,E,F,G],i是中间顶点的下标
        for (int i = 0; i < dis.length; i++) {
            // 从j顶点开始出发[A,B,C,D,E,F,G]
            for (int j = 0; j < dis.length; j++) {
                // 到达k顶点经过[A,B,C,D,E,F,G]
                for (int k = 0; k < dis.length; k++) {
                    // 求出从j出发，经过i到达k的距离
                    len = dis[j][i] + dis[i][k];
                    if (len < dis[j][k]) {
                        // 如果len小于dis[i][j]
                        dis[j][k] = len; // 更新距离
                        pre[j][k] = pre[i][k];// 更新前驱顶点
                    }
                }
            }
        }
    }
}