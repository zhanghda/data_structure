package com.zhd.sparseArray;

import java.io.*;

/**
 * 稀疏数组与二维数组之间的相互转换
 *
 * 用于压缩空间
 */
public class SparseArray {

    public static void main(String[] args) throws IOException {
        //创建一个原始数组 11*11
        int[][] ints = new int[11][11];
        //0表示没有棋子  1表示黑棋
        ints[1][2] = 1;
        ints[2][3] = 2;
        ints[2][5] = 2;

        //原始二维数组
        //遍历二维数组
       for (int[] ints1:ints) {
            for (int i:ints1) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }


        //*******************************************************************************

        //转换为稀疏数组
        // 先定义一个存储有效点数的变量
        int count = 0;

        System.out.println("初始二维数组");
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                if(ints[i][j] != 0){
                    count++;
                }
            }
        }
        System.out.println(count);
        //创建稀疏数组
        int[][] sparse = new int[count + 1][3];
        //给稀疏数组赋值
        sparse[0][0] = ints.length;
        sparse[0][1] = ints[0].length;
        sparse[0][2] = count;
        //创建一个变量 用于保证稀疏数组一直往下一位
        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                if(ints[i][j] != 0){
                    sum++;
                    sparse[sum][0] = i;
                    sparse[sum][1] = j;
                    sparse[sum][2] = ints[i][j];
                }
            }
        }
        //便利稀疏数组
        System.out.println("转化稀疏数组");
        for (int[] ints1:sparse) {
            for (int i:ints1) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
        /**
         * 将稀疏数组存入磁盘
         */
//        new XishuArray().writeArray(sparse);
        /**
         * 获取二维数组
         */
        System.out.println("测试");
                new SparseArray().toArray();

//*******************************************************************************
        //稀疏数组转化为二维数组
        //先读取稀疏数组的第一行
        int[][] newArray = new int[sparse[0][0]][sparse[0][1]];
        //从稀疏数组的第二行开始读取
        for (int i = 1; i < sparse.length; i++) {
            newArray[sparse[i][0]][sparse[i][1]] = sparse[i][2];
        }

        //便利转化后的稀疏数组
        System.out.println("新的二维数组 为");
        for (int[] ints1:newArray) {
            for (int i:ints1) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
    }

    /**
     * 将二维数组写入文件
     *
     */
    public void writeArray(int[][] ints) throws IOException {
        File file = new File("D:/demo.txt");
        FileWriter out = new FileWriter(file);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[1].length; j++) {
                out.write(ints[i][j]+"\t");
            }
            out.write("\r\n");
        }
        out.close();
    }
    /**
     * 从磁盘中读取稀疏数组  并转化为二维数组
     */
    public int[][] toArray() throws IOException {
        String url = "D:/demo.txt";
        FileReader fileReader = new FileReader(url);
        int i = 0;
        while ((i = fileReader.read()) != -1){
            System.out.println(i);
        }
        return null;
    }

}
