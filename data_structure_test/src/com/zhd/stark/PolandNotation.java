package com.zhd.stark;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式的实现
 * 例如（3+4）*5-6  =》 3 4 + 5 * 6 -
 * 思路：
 * 逆波兰首先数和符号从左向右依次入栈
 * 1.先将前两个数压入数栈
 * 2.如果遇到符号将栈顶和次顶pop出来 运算结果 压入数栈
 * 3.将5压入数栈
 * 4.符号的话，pop出栈顶和次顶  运算压入数栈
 * 5.将6压入数栈
 * 5.遇到减号，将数栈pop出  用第二个pop的减去第一个pop的
 */
public class PolandNotation {

    public static void main(String[] args) {

//        String aa = "3 4 + 5 * 6 -";
        String aa = "4 5 * 8 - 60 + 8 2 / +";

//        4 * 5 - 8 + 60 + 8 / 2 => 4 5 * 8 - 60 + 8 2 / +
        List<String> listByString = getListByString(aa);
        System.out.println(listByString);

        int compute = compute(listByString);
        System.out.println(compute);
    }

    //写一个方法  将字符串存放到数组里面
    public static List<String> getListByString(String suffixExpression) {
        String[] s = suffixExpression.split(" ");
        List<String> array = new ArrayList<>();
        for (String str : s) {
            array.add(str);
        }
        return array;
    }

    //计算的方法
    public static int compute(List<String> lists) {
        //先定义两个栈
        Stack<String> numStack = new Stack<>();

        for (String ch : lists) {
//            如果是符号，就pop两个数
            if (isOper(ch)) {
                String num1 = numStack.pop();
                String num2 = numStack.pop();
                int calculate = calculate(num1, num2, ch);
                numStack.push(calculate+"");
            } else {
                //如果是数字  就加入数栈
                numStack.push(ch);
            }
        }

        return Integer.parseInt(numStack.pop());
    }

    //提供判断是否是符号的方法

    public static boolean isOper(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    //提供一个运算的方法

    public static int calculate(String num1, String num2, String oper) {
        int i1 = Integer.parseInt(num1);
        int i2 = Integer.parseInt(num2);
        int res = 0;
        switch (oper) {
            case "+":
                res = i1 + i2;
                break;
            case "-":
                //注意这里  后pop的 要减去先pop的
                res = i2 - i1;
                break;
            case "*":
                res = i1 * i2;
                break;
            case "/":
                //注意这里  后pop的 要减去先pop的
                res = i2 / i1;
                break;
        }
        return res;
    }
}
