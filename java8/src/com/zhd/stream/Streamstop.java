package com.zhd.stream;

import java.util.Arrays;
import java.util.List;

/**
 * 流终止操作 ； match匹配
 *
 * allMatch
 * AnyMatch
 *
 */
public class StreamMatch {

    public static void main(String[] args) {


        List<Student> students = Arrays.asList(
                new Student("zhangsan", 10, 178.1),
                new Student("zhangsan", 10, 178.1),
                new Student("lisi", 34, 178.1),
                new Student("wangwu", 21, 178.1),
                new Student("", 25, 178.1)
        );

        boolean b = students.stream().allMatch(x -> x.getAge() > 1);
        System.out.println(b);
    }
}
