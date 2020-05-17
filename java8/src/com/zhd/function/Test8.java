package com.zhd.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//判断字符串 是否大于五个
public interface Test {

    boolean test(String t);
}

class Main {
    public static void main(String[] args) {
        Test test = new Test() {

            @Override
            public boolean test(String t) {
                if(t.length()>5){
                    return true;
                }
                return false;
            }
        };
        List<String> strings = Arrays.asList("wqeqwqwe", "wqde", "w", "dwwwddwd");
        List<String> compared = compared(strings, test);
        for (String  s :compared) {
            System.out.println(s);
        }
    }

   static List<String> compared(List<String> list, Test test) {
        ArrayList<String> objects = new ArrayList<>();
        for (String s : list) {
            if (test.test(s)) {
                objects.add(s);
            }
        }
        return objects;
    }

}
