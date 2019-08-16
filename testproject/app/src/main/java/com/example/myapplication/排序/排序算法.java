package com.example.myapplication.排序;

import java.util.ArrayList;
import java.util.List;

/***
 *       冒泡////选择///插入
 * @Author: Zhou xiaoyu
 * @CreateDate: 2019/8/14 0014
 *
 */
public class 排序算法 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(5);
        list.add(3);
        list.add(6);
        list.add(2);
        list.add(7);
        list.add(8);
        list.add(4);
        list.add(9);
//        print(list);
//        print("冒泡排序结果", 冒泡(list));
//        print("选择排序结果", 选择(list));
        print("插入排序结果", 插入(list));

    }

    /**
     * 冒泡排序
     *
     * @param list
     * @return
     */
    private static List<Integer> 冒泡(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j + 1) < list.get(j)) {
                    int temp = list.get(j + 1);
                    list.set(j + 1, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;

    }

    /**
     *  冒泡排序的改进版
     *
     * 选择排序  (每次循环剩下的元素找出一个最小(大)值放在每次循环的初始位置)
     *
     * 找出最大(最小)元素与第一个元素交换
     * 循环
     *
     * @param list
     * @return
     */
    private static List<Integer> 选择(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int minindex = i; //记录最小下标位置
            for (int j = i; j < list.size(); j++) {  //找到剩余元素的最小值(从i开始)
                if (list.get(j) < list.get(minindex)) {
                    minindex = j;
                }
            }
            int temp = list.get(minindex);
            list.set(minindex, list.get(i));
            list.set(i, temp);
        }
        return list;
    }


    /**
     * 简单的插入排序
     * 把排序好的和未排序的设立一个标界
     * 取出未排序的第一位和循环和已排序的比较
     *  缺点 : 数据量大过多做移动操作(可通过链表储存解决)
     * @param list
     * @return
     */
    private static List<Integer> 插入(List<Integer> list) {
        int currentValur;//等待排序的数据
        for (int i = 0; i < list.size() - 1; i++) {
            int preIndex = i;//已经排序数据最后一位的索引
            currentValur = list.get(i + 1); //正在比较的值
            while (preIndex >= 0 && currentValur < list.get(preIndex)) {  //循环比较已经排序的部分(从后向前)
                //如果匹配 把preindex值赋给preindex+1
//                此时preindex和preindex+1的值相等 (相当于向后移动一位 因为上面已经有变量储存了被覆盖的之前的值)
                list.set(preIndex + 1, list.get(preIndex));
                preIndex--;
            }
            list.set(preIndex + 1, currentValur);
        }
        return list;
    }


    private static void print(String tag, List<Integer> list) {
        System.out.print(tag + ": ");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.print(list.get(i));
                System.out.println();
                return;
            }
            System.out.print(list.get(i) + ", ");
        }

    }


}
