package com.zhd.recursive;

/**
 * 八皇后问题
 */
public class Queen {

    //先定义一个一维数组表示棋盘
    static int max = 8;
    int[] arr = new int[max];


    public static void main(String[] args) {
        Queen queen = new Queen();
        queen.check(0);
    }

    /**
     * 表示插入的方法
     * @param n 表示第n个皇后
     */
    public void check(int n){
        if(n == max){  //max =8  当n== 7的时候表示八行全都插完   在加一 就会退出  完成这一种摆放顺序
            print();
            return;
        }
        //依此放入皇后
        for (int i = 0; i < max; i++) {
            //将当前这个皇后n ，放在该行的第一列
            arr[n] = i;
            if(panduan(n)){
                check(n+1);
            }
        }
    }

    /**
     * 判断添加是否合理  比如不能在同一列  不能在对角线
     *
     * 当我们查看第n个皇后  我们要检测与前面的皇后是否冲入
     * @param n  表示第n个皇后
     * @return
     */
    public boolean panduan(int n){
        //要用for循环，要判断之前所有的皇后
        for (int i = 0; i < n; i++) {
            //arr[i] == arr[n] 检查是狗在同一列
            //Math.abs(n -i) == Math.abs(arr[n] -arr[i]) 检查是否在同一对角线
            //对角线可以理解为 x 轴之差 = y轴之差  说明斜率为45° 即在同一对角线
            if(arr[i] == arr[n] || Math.abs(n -i) == Math.abs(arr[n] -arr[i])){
                return false;
            }
        }
        return true;
    }
    /**
     * 写一个打印的方法
     */
    public void print(){
        for (int i = 0; i < max; i++) {
            System.out.print(arr[i] + ' ' );
        }
        System.out.println();
    }

}
