package com.example.myapplication.排序;

import java.util.ArrayList;
import java.util.List;

/***
 *       冒泡////快速///插入
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
        print("希尔排序结果", 希尔(list));
        print("归并排序结果", 归并(list));

    }

    /**
     * 归并排序
     * @param list
     * @return
     */
    private static List<Integer> 归并(List<Integer> list) {





        return list;
    }

    /**
     * 希尔排序又名缩小增量排序(基于简单插入排序)
     * 插入排序时拿到的数据要和已排序数据比较如果已排序数据量大则不理想
     *  希尔排序通过多次把数据源分组进行插入排序
     *
     *  优点 : 与插入排序相比减少数据移动操作
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
                while (preIndex >= 0 && currentValue < list.get(preIndex)) {
                    list.set(preIndex + gap, list.get(preIndex));
                    preIndex -= gap;
                }
                list.set(preIndex + gap, currentValue);
            }
            System.out.println("gap等于 : "+gap+" 时");
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(list.get(i)+", ");
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
