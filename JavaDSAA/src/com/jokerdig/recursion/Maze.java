package com.jokerdig.recursion;

/**
 * @author Joker大雄
 * @data 2022/10/8 - 10:05
 **/
public class Maze {
    public static void main(String[] args) {
        // 迷宫问题
        // 先创建一个二维数据，模拟迷宫
        // 迷宫地图
        int [][] map = new int [8][7];
        // 使用1 表示迷宫的墙壁
        // 先把上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        // 左右全部置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        // 设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        // 输出地图
        System.out.println("=======地图的情况=======");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        // 使用递归回溯，给小球找路
        setWayUpdate(map,1,1);
        // 输出新的地图，小球走过并标识的地图
        // 输出地图
        System.out.println("=======小球走过并标识的地图的情况=======");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    // 使用递归回溯来给小球找路
    /*
        说明：
        1. map表示地图，i,j表示从地图那个位置出发;
        2. 如果小球能到map[6][5],则说明通路找到
        3. 当map[i][j]为0时，表示该点还没有走左，
           为1表示墙，
           为2表示路可以走，
           为3表示该点已经走过，但走不通；
        4. 在走迷宫时，策略：下->右->上->左 的顺序走，如果该点走不通再回溯；

     */
    /***
     * @param map 迷宫地图
     * @param i 从哪个位置开始
     * @param j 从哪个位置开始
     * @return 返回找路结果
     */
    public static boolean setWay(int[][] map,int i,int j){
        if(map[6][5] == 2){
            // 通过已经找到
            return true;
        }else{
            if(map[i][j]==0){
                // 如果当前点还没有走过,按照策略走 下->右->上->左
                map[i][j] = 2;// 假定该点可以走通
                if(setWay(map,i+1,j)){
                    // 向下走
                    return true;
                }else if(setWay(map,i,j+1)){
                    // 向右走
                    return true;
                }else if(setWay(map,i-1,j)){
                    // 向上走
                    return true;
                }else if(setWay(map,i,j-1)){
                    // 向左走
                    return true;
                }else{
                    // 到这说明该点下右上左都走不通，说明该点为死路
                    map[i][j] = 3;
                    return false;
                }
            }else{
                // 如果map[i][j] != 0，可能是1，2，3
                return false;
            }
        }
    }
    // 修改找路策略为：上->右->下->左
    public static boolean setWayUpdate(int[][] map,int i,int j){
        if(map[6][5] == 2){
            // 通过已经找到
            return true;
        }else{
            if(map[i][j]==0){
                // 如果当前点还没有走过,按照策略走 上->右->下->左
                map[i][j] = 2;// 假定该点可以走通
                if(setWayUpdate(map,i-1,j)){
                    // 向上走
                    return true;
                }else if(setWayUpdate(map,i,j+1)){
                    // 向右走
                    return true;
                }else if(setWayUpdate(map,i+1,j)){
                    // 向下走
                    return true;
                }else if(setWayUpdate(map,i,j-1)){
                    // 向左走
                    return true;
                }else{
                    // 到这说明该点下右上左都走不通，说明该点为死路
                    map[i][j] = 3;
                    return false;
                }
            }else{
                // 如果map[i][j] != 0，可能是1，2，3
                return false;
            }
        }
    }
}
