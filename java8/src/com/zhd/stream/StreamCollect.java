package com.zhd.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 流终止操作 ；归约
 *map-reduce模式
 *
 */
public class Streamstop {

    public static void main(String[] args) {


        List<Student> students = Arrays.asList(
                new Student("zhangsan", 10, 178.1),
                new Student("zhangsan", 10, 178.1),
                new Student("lisi", 34, 178.1),
                new Student("wangwu", 21, 178.1),
                new Student("", 25, 178.1)
        );

        List<Integer> integers = Arrays.asList(1, 3, 2, 3, 4, 2);

        Integer reduce = integers.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(reduce);

        //场景 ： 统计员工工资和
//        Double reduce1 = students.stream()
//                .map(Student::getHeight)
//                .reduce((double) 0, (x, y) -> x + y);
        Double reduce1 = students.stream()
                .map(Student::getHeight)
                .reduce((double) 0, Double::sum);

        System.out.println(reduce1);
    }
}
