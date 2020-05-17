package com.zhd.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 流操作 ； 中间操作之映射
 */
public class StreamSort {

    public static void main(String[] args) {
//        Arrays.asList("aa","bb","cc").stream().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
//        Stream.of("aa","bb","cc").map(String::toUpperCase).forEach(System.out::println);


        List<Student> students = Arrays.asList(
                new Student("zhangsan", 10, 178.1),
                new Student("zhangsan", 10, 178.1),
                new Student("lisi", 34, 178.1),
                new Student("wangwu", 21, 178.1),
                new Student("", 25, 178.1)
        );

        students.stream().sorted((x,y) -> -(x.getAge() - y.getAge())).forEach(System.out::println);
    }
}
