package com.zhd.stark;

/**
 * 通过栈来实现计算器,只能运算小数
 */
public class CurcalculatorByStack {

    public static void main(String[] args) {
//        String a = "3*4-5+2*4";
        String a = "381+2*6-2";

        int curcal = curcal(a);
        System.out.println(curcal);
    }

    /**
     * 计算器实现
     */
    public static int curcal(String string) {
        //创建数栈和符号栈
        ArrayStack2 numStack = new ArrayStack2(20);
        ArrayStack2 operStack = new ArrayStack2(20);
        //定义栈中取出的运算符
        int oper = 0;
        int num1 = 0;
        int num2 = 0;
        //定义字符串中取出的数
        char ch = ' ';
        //定义一个指针
        int index = 0;
        //
        int res = 0;
        //定义一个字符串进行
        String app = "";
        while (true) {
            //取出字符串中的元素
            ch = string.substring(index, index + 1).charAt(0);

            //如果第一个取到的为符号栈，放入符号栈
            if (isOper(ch)) {
                //如果符号栈是空的  直接入栈
                if (!operStack.empty()) {
                    if (pos(ch) <= pos(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = suan(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    operStack.push(ch);
                }
            } else {
                //思路
                //1.定义一个字符串用作数字的拼接
                //2.if下一个为符号栈则拼接的数直接入数栈
                //3.
                app+=ch;
                if(index == string.length() -1){
                    numStack.push(Integer.parseInt(app));
                }else {
                    if(isOper(string.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(app));
                        // 用完清空
                        app = "";
                    }
                }

//                numStack.push(ch - 48);
            }
            index++;
            if (index >= string.length()) {
                break;
            }
        }

        while (!operStack.empty()) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = suan(num1, num2, oper);
            numStack.push(res);
        }
        return numStack.pop();
    }

    /**
     * 新增判断是否为数字的方法
     */
    public static boolean isOper(int oper) {
        return oper == '+' || oper == '-' || oper == '*' || oper == '/';
    }

    /**
     * 判断优先级大小的方法
     */
    public static int pos(int oper) {
        //如果为* / 为优先级最高  + /优先级剧中  其他反汇-1
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 计算的方法
     */
    public static int suan(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }
}

class ArrayStack2 {
    private int maxSize; //栈的容量
    private int[] array; //存储数据的数组
    private int top;     //出栈的指针

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
        top = -1;
    }

    /**
     * 获取栈顶的方法  不出栈
     */
    public int peek() {
        return array[top];
    }

    /**
     * 判断栈空
     */
    public boolean empty() {
        return top == -1;
    }

    /**
     * 判断栈满
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 入栈
     */
    public void push(int val) {
        if (isFull()) {
            System.out.println("队列已经满了");
        }
        top++;
        array[top] = val;
    }

    /**
     * 出栈
     */
    public int pop() {
        if (empty()) {
            throw new RuntimeException("队列为空，不能出栈");
        }
        int val = array[top];
        top--;
        return val;
    }

    /**
     * 展示
     */
    public void show() {
        if (empty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("第【%d】个，值为【%d】\n", i, array[i]);
        }
    }

}