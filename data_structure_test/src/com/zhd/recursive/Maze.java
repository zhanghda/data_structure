package com.zhd.recursive;

/**
 * 递归解决迷宫问题
 * <p>
 * 用一个而为数组来表示迷宫
 */
public class Maze {

    public static void main(String[] args) {

        int[][] map = createArray();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

        setWay(map, 1, 1);
        System.out.println();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }

    /**
     * * 迷宫问题求解
     * 从 起点 1，1 开始出发  到7，6到终点
     * <p>
     * 约定:
     * 当地图的i，j为0 时，表示该点还没有走过
     * 当地图的i，j为1 时，表示墙
     * 当地图的i，j为2 时，表示已经走过
     * 当地图的i，j为3 时，表示该位置已经走过，走不通
     * <p>
     * 策略（先走哪个方向再走哪个防线）： 下 右 上 左
     *
     * @param map 迷宫
     * @param i   当前位置横坐标
     * @param j   当前位置纵坐标
     * @return
     */
    public static boolean setWay(int[][] map, int i, int j) {
        //如果已经找到出口
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {//如果当前这个点还没走过
                map[i][j] = 2;  //假设他能走通
                //策略 ： 下 右 上 左
                if (setWay(map, i + 1, j)) {  //下
                    return true;
                } else if (setWay(map, i, j + 1)) {  //右
                    return true;
                } else if (setWay(map, i - 1, j)) {  //上
                    return true;
                } else if (setWay(map, i, j - 1)) {  //左
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {  //如果map[i][j] 不等于0，那他就等于1，2，3  走不通
                return false;
            }
        }
    }

    /**
     * 创建一个二维数组来表示迷宫
     *
     * @return
     */
    public static int[][] createArray() {
        int[][] a = new int[8][7];
        //左右全为1
        for (int k = 0; k < 8; k++) {
            a[k][0] = 1;
            a[k][6] = 1;
        }
        //上下全为1
        for (int i = 0; i < 7; i++) {
            a[0][i] = 1;
            a[7][i] = 1;
        }
        a[3][1] = 1;
        a[3][2] = 1;

        return a;
    }
}
