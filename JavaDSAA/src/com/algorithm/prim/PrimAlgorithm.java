package com.algorithm.prim;

import java.util.Arrays;

/**
 * @author Joker大雄
 * @data 2022/11/28 - 16:54
 **/
public class PrimAlgorithm {
    public static void main(String[] args) {
        // 测试图是否创建成功
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        // 邻接矩阵的关系使用二维数组表示，用10000这个较大的数表示两个点不连通
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}};

        // 创建MGraph对象
        MGraph graph = new MGraph(verxs);
        // 创建一个MinTree对象
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, verxs, data, weight);
        // 输出
        // minTree.showGraph(graph);

        // 测试prim算法
        minTree.prim(graph,0);
    }
}

// 创建最小生成树->村庄的图
class MinTree {
    // 创建图的邻接矩阵

    /**
     * @param graph  图对象
     * @param verxs  图对应的顶点个数
     * @param data   图各个顶点的值
     * @param weight 图的邻接矩阵
     */
    public void createGraph(MGraph graph, int verxs, char data[], int[][] weight) {
        int i, j;
        for (i = 0; i < verxs; i++) { // 顶点
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    // 显示图的方法
    public void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }
    // 编写prim算法，得到最小生成树

    /**
     * @param graph 表示图
     * @param v     表示从图的第几个顶点开始生成
     */
    public void prim(MGraph graph, int v) {
        // visited[] 标记节点是否被访问过，默认为0
        // Java中因为它创建本身就为0，所以省略初始化步骤
        int visited[] = new int[graph.verxs];

        // 把当前节点标记为已访问
        visited[v] = 1;
        // h1和h2记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        //将minWeight初始化为一个较大数值，在之后的遍历中会被替换
        int minWeight = 10000;
        for (int k = 1; k < graph.verxs; k++) {// 因为有graph.verxs多个顶点，prim算法结束后，有graph.verxs-1条边

            // 确定每一次生成的子图的节点，和哪个节点距离最近
            for (int i = 0; i < graph.verxs; i++) { // i表示被访问过的节点
                for (int j = 0; j < graph.verxs; j++) { // j表示还没有被访问过的节点
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        // 替换minWeight，寻找已经访问过的节点和未访问过的节点间的权值最小的边
                        minWeight = graph.weight[i][j];
                        // 同时记录顶点的下标
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            // 找到一条边是最小的
            System.out.println("边<"+graph.data[h1]+","+graph.data[h2]+"> 权值："+ minWeight);
            // 将当前这个节点标记为已经访问
            visited[h2] = 1;
            // 重置minWeight，将其设置为10000
            minWeight = 10000;
        }
    }
}

// 构建图
class MGraph {
    int verxs; //表示图的节点个数
    char[] data; // 保存节点数据
    int[][] weight; // 存放边，就是我们邻接矩阵的边

    // 初始化数据
    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}