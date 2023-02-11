package com.algorithm.kruskal;

import java.util.Arrays;

/**
 * @author Joker大雄
 * @data 2022/11/29 - 13:21
 **/
public class KruskalCase {

    private int edgeNum; // 边的个数
    private char[] vertexs; // 顶点数组
    private int[][] matrix; // 邻接矩阵
    // 使用Integer最大值表示两个顶点不能连通
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // 测试邻接矩阵创建
        char[] vertexs = {'A','B','C','D','E','F','G'};
        //克鲁斯卡尔算法的邻接矩阵
        int matrix[][]= {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ { 0,12, INF, INF, INF, 16,14},
                /*B*/ { 12,0,10, INF, INF, 7, INF},
                /*C*/ { INF, 10, 0, 3, 5, 6, INF},
                /*D*/ { INF, INF, 3, 0, 4, INF, INF},
                /*E*/ { INF, INF, 5, 4, 0, 2, 8},
                /*F*/ { 16, 7, 6, INF, 2, 0, 9},
                /*G*/ { 14, INF, INF, INF, 8, 9, 0}};
        // 创建克鲁斯卡尔对象实例
        KruskalCase kruskalCase = new KruskalCase(vertexs, matrix);
        // 输出
        // kruskalCase.print();
        // 获取到边的集合
        // EData[] edge = kruskalCase.getEdges();
        // 返回边的数组
        // System.out.println("未排序："+Arrays.toString(edge));
        // 测试排序
        // kruskalCase.sortEdges(edge);
        // System.out.println("排序后："+Arrays.toString(edge));
        // 克鲁斯卡尔算法-> 最小生成树
        kruskalCase.kruskal();
    }

    // 构造器
    public KruskalCase(char[] vertexs,int[][] matrix){
        // 初始化顶点数和边的个数
        int vlen = vertexs.length;

        // 初始化顶点,拷贝方式
        this.vertexs = new char[vlen];
        for(int i=0;i<vertexs.length;i++){
            this.vertexs[i] = vertexs[i];
        }
        // 初始化边
        this.matrix = new int[vlen][vlen];
        // 初始化,拷贝方式
        for (int i=0;i<vlen;i++){
            for (int j = 0; j < vlen; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
        // 统计边
        for (int i = 0; i < vlen; i++) {
            for (int j = i+1; j < vlen; j++) {
                if(this.matrix[i][j] != INF){// 边有效
                    edgeNum++;
                }
            }
        }
    }
    // 打印邻接矩阵
    public void print(){
        System.out.println("邻接矩阵为：\n");
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%10d\t",matrix[i][j]);
            }
            System.out.println();
        }
    }
    // 使用克鲁斯卡尔完成 最小生成树
    public void kruskal(){
        int index = 0; // 表示结果数组的索引
        // 用于保存已有 "最小生成树"中的每个顶点在最小生成树的终点
        int[] ends = new int[edgeNum];
        // 创建结果数组，保存最后的最小生成树
        EData[] rets =new EData[edgeNum];

        // 获取图中所有的边的集合，初始一共有12条边
        EData[] edges = getEdges();

        // 按照边的权值大小进行排序(这里我们从小打大)
        sortEdges(edges);
        // 遍历edges数组，判断准备加入的边是否构成回路，如果没有构成就加入rets，否则不加入
        for (int i = 0; i < edgeNum; i++) {
            // 获取到第i条边的第一个顶点(起点)
            int p1 = getPosition(edges[i].start);
            // 获取到第i条变的第2个顶点
            int p2 = getPosition(edges[i].end);

            // 获取p1顶点在已有最小生成树中的终点
            int m = getEnd(ends,p1);
            // 获取p2顶点在已有最小生成树中的终点
            int n = getEnd(ends,p2);
            // 判断是否构成回路
            if(m != n){// 不构成回路
                ends[m] = n; // 设置m在已有最小生成树中的终点
                rets[index++] = edges[i];// 有一条边加入到rets数组
            }
        }
        // 统计并打印 最小生成树
        System.out.println("最小生成树：");
        for (int i = 0; i < index; i++) {
            System.out.println(rets[i]);
        }
    }

    // 按照边的权值进行排序，这里用冒泡
    /**
     * @param edges 边的集合
     */
    public void sortEdges(EData[] edges){
        for (int i = 0; i < edges.length-1; i++) {
            for (int j = 0; j < edges.length-1-i; j++) {
                if(edges[j].weight > edges[j+1].weight){
                    EData temp = edges[j];
                    edges[j] = edges[j+1];
                    edges[j+1] = temp;
                }
            }
        }
    }
    // 根据顶点返回对应的下标
    /**
     *
     * @param ch 传入一个顶点，例如'C','D'
     * @return 返回顶点对应的下标，找不到返回-1
     */
    private int getPosition(char ch){
        for (int i = 0; i < vertexs.length; i++) {
            if(vertexs[i] == ch){
                return i;
            }
        }
        return -1;
    }

    /**
     * 功能：获取图中的边，放到EData[]数组中，然后遍历该数组
     * 通过matrix邻接矩阵来获取
     * EData[] 形式[['A','B',12],......]
     * @return
     */
    private EData[] getEdges(){
        int index = 0;
        EData[] edge = new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i+1; j < vertexs.length; j++) {
                if(matrix[i][j] != INF){
                    edge[index++] = new EData(vertexs[i],vertexs[j],matrix[i][j]);
                }
            }
        }
        return edge;
    }
    /**
     * 功能：获取下标为i的顶点的终点，来判断两个顶点的终点是否相同
     * @param ends 记录了各个顶点对应的终点是哪个，是在扫描的过程逐步生成的，是一个动态的值
     * @param i 表示传入的顶点对应的下标
     * @return 返回的就是下标为i的顶点对应的终点的下标
     */
    private int getEnd(int[] ends,int i){
        while(ends[i] != 0){
            i = ends[i];
        }
        return i;
    }

}
// 创建一个类EData,它的对象实例就是表示一条边
class EData{
    char start; // 边的一个点
    char end; // 边的另外一个点
    int weight; //边的权值
    // 构造器
    public EData(char start,char end,int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    // 重写toString方法，便于输出边
    @Override
    public String toString() {
        return "EData{" +
                "<" + start +
                "," + end +
                ">=" + weight +
                '}';
    }
}