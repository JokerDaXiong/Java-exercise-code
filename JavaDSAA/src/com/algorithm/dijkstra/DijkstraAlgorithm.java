package com.algorithm.dijkstra;

import java.util.Arrays;

/**
 * @author Joker大雄
 * @data 2022/11/30 - 11:51
 **/
public class DijkstraAlgorithm {
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        // 邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535; // 表示不可连通
        matrix[0] = new int[]{N, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, N, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, N, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, N, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, N, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, N, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, N};
        // 创建Graph对象
        Graph graph = new Graph(vertex, matrix);
        // graph.showGraph();
        // 测试迪杰斯特拉算法
        graph.dsj(6);
        // 遍历最后结果
        graph.showDsj();
    }
}

// 访问顶点集合
class VisitedVertex {
    //顶点的访问情况(0代表未访问，1代表已访问)，会动态更新；
    public int[] already_arr;
    // 记录出发顶点到其他顶点的距离，会动态更新，求出最短距离又会存放到dis中。
    public int[] dis;
    // 每一个下标对应的值为前一个顶点下标，会动态更新。
    public int[] pre_visited;

    // 构造器

    /**
     * @param len   顶点个数
     * @param index 出发顶点的下标
     */
    public VisitedVertex(int len, int index) {
        this.already_arr = new int[len];
        this.pre_visited = new int[len];
        this.dis = new int[len];
        // 初始化dis
        Arrays.fill(dis, 65535);
        already_arr[index] = 1; // 设置出发顶点被访问
        this.dis[index] = 0; // 设置出发顶的访问距离为0
    }

    /**
     * function:判断index顶点是否被访问过
     *
     * @param index
     * @return 如果访问过返回true，否则返回false
     */
    public boolean in(int index) {
        return already_arr[index] == 1;
    }

    /**
     * function:更新出发顶点到index顶点的距离
     *
     * @param index
     * @param len
     */
    public void updateDis(int index, int len) {
        dis[index] = len;
    }

    /**
     * function:更新pre顶点的前驱顶点为index的顶点
     *
     * @param pre
     * @param index
     */
    public void updatePre(int pre, int index) {
        pre_visited[pre] = index;
    }

    /**
     * function:返回出发顶点到index顶点的距离
     *
     * @param index
     * @return
     */
    public int getDis(int index) {
        return dis[index];
    }

    // 继续选择并返回新的访问顶点，例如G顶点访问过后，就以A作为新的访问顶点
    public int updateArr() {
        int min = 65535, index = 0;
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && dis[i] < min) {
                min = dis[i];
                index = i;
            }
        }
        // 更新index顶点被访问过了
        already_arr[index] = 1;
        return index;
    }

    // 显示最后结果
    public void show() {
        System.out.println("----------------------");
        // 输出already_arr
        for (int i : already_arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        // 输出pre_visited
        for (int i : pre_visited) {
            System.out.print(i + " ");
        }
        System.out.println();
        // 输出dis
        for (int i : dis) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("----------------------");
        // 优化输出效果
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int count = 0;
        for (int i : dis) {
            if (i != 65535) {
                System.out.print("G-"+vertex[count] + "(" + i + ") ");
            } else {
                System.out.println("N");
            }
            count++;
        }
        System.out.println();
    }
}

// 构建图
class Graph {
    private char[] vertex;// 存放顶点
    private int[][] matrix; //邻接矩阵
    private VisitedVertex vV; // 已经访问的顶点集合

    // 构造器
    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    // 显示图
    public void showGraph() {
        for (int[] link : matrix) {
            System.out.println(Arrays.toString(link));
        }
    }

    // 迪杰斯特拉算法

    /**
     * @param index 出发顶点对应的下标
     */
    public void dsj(int index) {
        vV = new VisitedVertex(vertex.length, index);
        update(index); // 更新index顶点到周围顶点的距离和前驱顶点

        for (int i = 1; i < vertex.length; i++) {
            index = vV.updateArr(); // 选择并返回新的访问顶点
            update(index);// 更新index顶点到周围顶点的距离和前驱顶点
        }
    }

    // 更新index下标顶点到周围顶点的距离，和周围顶点的前驱顶点
    private void update(int index) {
        int len = 0;
        // 遍历邻接矩阵matrix[index]行
        for (int j = 0; j < matrix[index].length; j++) {
            // len ：出发顶点到index顶点的距离 + 从index顶点到j顶点的距离
            len = vV.getDis(index) + matrix[index][j];
            // 如果j顶点没有被访问过，并且len<出发顶点到j顶点的距离，就需要更新
            if (!vV.in(j) && len < vV.getDis(j)) {
                vV.updatePre(j, index);// 更新j顶点的前驱顶点为index顶点
                vV.updateDis(j, len); // 更新出发顶点到j顶点的距离
            }
        }
    }

    // 显示最后结果
    public void showDsj() {
        vV.show();
    }
}