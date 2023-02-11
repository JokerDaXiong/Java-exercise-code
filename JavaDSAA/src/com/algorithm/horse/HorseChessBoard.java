package com.algorithm.horse;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Joker大雄
 * @data 2022/12/2 - 10:53
 **/
public class HorseChessBoard {

    private static int X; // 棋盘的列数
    private static int Y; // 棋盘的行数
    // 创建一个数组，标记棋盘的各个位置是否被访问过
    private static boolean visited[];
    // 记录棋盘所有位置是否都被访问过
    private static boolean finished; // true表示全部被访问

    public static void main(String[] args) {
        // 测试骑士周游问题代码
        System.out.println("~骑士周游启动~");
        X = 8;
        Y = 8;
        int row = 1; // 马初始位置的行，从1开始
        int column = 1; //马初始位置的列，从1开始
        // 创建棋盘
        int[][] chessboard = new int[X][Y];
        visited = new boolean[X * Y]; // 初始都为false
        // 测试耗时
        long start = System.currentTimeMillis();
        traversalChessboard(chessboard, row - 1, column - 1, 1);
        long end = System.currentTimeMillis();
        System.out.println("耗费时间：" + (end - start) + "ms");
        // 输出棋盘最终结果
        for (int[] rows : chessboard) {
            for (int step : rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }

    /**
     * function:马踏棋盘问题解决的方法(回溯)
     *
     * @param chessboard 棋盘
     * @param row        马当前所在位置的行，从0开始
     * @param column     马当前所在位置的列，从0开始
     * @param step       马所走的第几步，初始位置就是第一步
     */
    public static void traversalChessboard(int[][] chessboard, int row, int column, int step) {

        chessboard[row][column] = step; // 马初始所在位置
        visited[row * X + column] = true; //标记被访问过
        // 获取当前位置可以走的下一个位置的集合
        ArrayList<Point> ps = next(new Point(column, row));
        // 对ps所有的Point对象下一步骤的位置的数据，进行非递减排序
        sort(ps);
        // 遍历ps
        while (!ps.isEmpty()) {
            Point p = ps.remove(0);// 取出下一个可以走的位置
            // 判断该点是否已经访问过
            if (!visited[p.y * X + p.x]) {// 还未被访问
                traversalChessboard(chessboard, p.y, p.x, step + 1);
            }
        }
        // 判断任务是否完成，没完成就将棋盘置为0
        // step < X * Y 成立存在两种情况：
        // 1. 棋盘到目前位置，仍然没有走完
        // 2. 棋盘处于回溯过程中
        if (step < X * Y && !finished) {
            chessboard[row][column] = 0;
            visited[row * X + column] = false;
        } else {// 棋盘走完
            finished = true;
        }
    }

    /**
     * function: 根据当前位置(Point对象)，计算马还能走哪些位置(Point对象)，并放入到一个集合中(ArrayList),最多有8个位置
     *
     * @param curPoint
     * @return
     */
    public static ArrayList<Point> next(Point curPoint) {
        // 创建一个ArrayList
        ArrayList<Point> ps = new ArrayList<Point>();
        // 创建一个Point
        Point p1 = new Point();
        // 表示：马可以走到5的位置
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        // 判断马是否可以走6这个位置
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        // 判断马是否可以走7这个位置
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        // 判断马是否可以走0这个位置
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        // 判断马是否可以走1这个位置
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        // 判断马是否可以走2这个位置
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        // 判断马是否可以走3这个位置
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        // 判断马是否可以走4这个位置
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }

        return ps;
    }
    // 贪心算法优化，进行非递减排序
    public static void sort(ArrayList<Point> ps){
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                // 获取o1和o2的下一步的所有位置个数
                int count1 = next(o1).size();
                int count2 = next(o2).size();
                // 非递减
                if(count1<count2){
                    return -1;
                }else if(count1 == count2){
                    return 0;
                }else{
                    return 1;
                }
            }
        });
    }
}
