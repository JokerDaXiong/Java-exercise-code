package com.jokerdig.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/11/22 - 10:26
 **/
public class GraphDemo {
    // 存储顶点
    private List<String> vertexList;
    // 存储图对应的邻接矩阵
    private int[][] edges;
    // 当前边的数量
    private int numOfEdges;
    // 记录节点是否被访问过
    private boolean [] isVisited;

    public static void main(String[] args) {
        // 测试图的创建
        int n = 5; // 节点的个数
        String vertexVal[] = {"A","B","C","D","E"};
        // 创建图对象
        GraphDemo graph = new GraphDemo(n);
        // 循环添加顶点
        for (String value : vertexVal){
            graph.insertVertex(value);
        }
        // 添加边： A-B  A-D  B-C  B-D  D-E
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,3,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(3,4,1);
        // 显示矩阵
        // graph.showGraph();
        // 测试dfs遍历
        // System.out.println("深度优先遍历");
        // graph.dfs();
        System.out.println("广度优先遍历");
        graph.bfs();
    }

    // 构造器
    public GraphDemo(int n){
        // 初始化矩阵和ArrayList
        edges = new int [n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
        isVisited = new boolean[5];
    }
    // 得到第一个邻接节点的下标
    /**
     *
     * @param index
     * @return 如果节点存在就返回下标，否则返回-1
     */
    public int getFirstNe(int index){
        for (int j = 0; j <vertexList.size(); j++) {
            if(edges[index][j]>0) {
                return j;
            }
        }
        return -1;
    }
    // 根据前一个邻接节点的下标来获取下一个邻接节点
    public int getNextNe(int v1,int v2){
        for (int j = v2+1; j < vertexList.size(); j++) {
            if(edges[v1][j]>0){
                return j;
            }
        }
        return -1;
    }
    // 深度优先遍历算法
    private void dfs(boolean[] isVisited,int i){
        // 首先我们访问该节点，输出
        System.out.print(getValueByIndex(i)+"->");
        // 将节点设置为已经访问
        isVisited[i] = true;
        // 查找节点i的第一个邻接节点w
        int w = getFirstNe(i);
        while(w!=-1) {// 说明有邻接节点
            // 判断是否被访问过
            if(!isVisited[w]){
                dfs(isVisited,w);
            }
            // 如果w已经被访问
            w = getNextNe(i,w);
        }
    }

    // 对dfs进行重载，遍历所有节点，进行dfs(回溯)
    public void dfs(){
        // 遍历所有节点，进行dfs(回溯)
        for (int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }
    // 对一个节点进行广度优先遍历的方法
    private void bfs(boolean[] isVisited,int i){
        int u; //  表示队列的头节点对应的下标
        int w; // 邻接节点的下标
        // 队列，记录节点访问的顺序
        LinkedList queue = new LinkedList<>();
        // 访问节点
        System.out.print(getValueByIndex(i)+"->");
        // 标记为已经访问
        isVisited[i] = true;
        // 将节点加入队列
        queue.addLast(i);
        // 队列是否为空
        while(!queue.isEmpty()){
            // 不为空，取出队列头节点下标
            u = (Integer)queue.removeFirst();
            // 得到u的第一个邻接节点下标
            w = getFirstNe(u);
            while(w!=-1){// w存在
                // 是否被访问过
                if(!isVisited[w]){
                    System.out.print(getValueByIndex(w)+"->");
                    // 标记已经被访问
                    isVisited[w] = true;
                    // 入队列
                    queue.addLast(w);
                }
                // 如果已经访问过，以u为前提，找w的下一个邻接节点
                w = getNextNe(u,w); // 体现出广度优先
            }
        }
    }

    // 遍历所有的节点，保证每个节点都进行广度优先(重载)
    public void bfs(){
        for (int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }

    // 返回节点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }
    // 得到边的数量
    public int getNumOfEdges(){
        return numOfEdges;
    }
    // 返回节点下标对应的数据 0->A 1->B 2->C .....
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }
    // 返回v1和v2的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }
    // 显示图矩阵
    public void showGraph(){
        for(int[] link:edges){
            System.out.println(Arrays.toString(link));
        }
    }

    // 插入节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    // 添加边

    /**
     *
     * @param v1 表示第一个顶点的下标，即第几个顶点 "A"-"B" "A"->0 "B"->1
     * @param v2 表示第二个顶点的下标
     * @param weight 表示权值
     */
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
