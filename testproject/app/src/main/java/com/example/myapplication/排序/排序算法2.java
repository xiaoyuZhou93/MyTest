package com.example.myapplication.排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 *       归并////希尔///
 * @Author: Zhou xiaoyu
 * @CreateDate: 2019/8/14 0014
 *
 */
public class 排序算法2 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();

        list.add(5);
        list.add(3);
        list.add(6);
        list.add(2);
        list.add(8);
        list.add(4);
        list.add(7);
        list.add(9);
        list.add(1);
//        print("希尔排序结果", 希尔(list));
        int[] array = {7, 8, 9, 5, 2, 6, 3, 4, 1, 10};
        int[] 归并 = 归并(array);
        for (int i = 0; i < 归并.length; i++) {
            System.out.println(归并[i]);

        }

    }

    /**
     * 归并排序(升序)
     *
     * @param
     * @return
     */
    private static int[] 归并(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return marge(归并(left), 归并(right));
    }

    /**
     * 合并两个数组
     *
     * @param left
     * @param right
     * @return
     */
    private static int[] marge(int[] left, int[] right) {
        int[] array = new int[left.length + right.length];
        for (int index = 0, leftIndex = 0, rightIndex = 0; index < array.length; index++) {

            if (leftIndex >= left.length) {
                array[index] = right[rightIndex++];
            } else if (rightIndex >= right.length) {
                array[index] = left[leftIndex++];
            } else if (left[leftIndex] < right[rightIndex]) {
                array[index] = left[leftIndex++];
            } else if (left[leftIndex] > right[rightIndex]) {
                array[index] = right[rightIndex++];
            }
        }
        return array;
    }

    /**
     * 希尔排序又名缩小增量排序(基于简单插入排序)
     * 插入排序时拿到的数据要和已排序数据比较如果已排序数据量大则不理想
     * 希尔排序通过多次把数据源分组进行插入排序
     * <p>
     * 优点 : 与插入排序相比减少数据移动操作
     *
     * @param list
     * @return
     */
    private static List<Integer> 希尔(List<Integer> list) {
        int size = list.size();
        int gap = size / 2; //增量
        int currentValue;//待排序的数据
        while (gap > 0) {
            for (int i = gap; i < size; i++) {
                currentValue = list.get(i);
                int preIndex = i - gap; //已排序完的位置
                while (preIndex >= 0 && currentValue < list.get(preIndex)) { //这里是循环 已排序的位置
                    list.set(preIndex + gap, list.get(preIndex));
                    preIndex -= gap;
                }
                list.set(preIndex + gap, currentValue);
            }
            System.out.println("gap等于 : " + gap + " 时");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + ", ");
            }
            System.out.println();
            gap /= 2;
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
