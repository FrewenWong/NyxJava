package com.frewen.collection.demo.set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {

    public static final void main(String[] args) {
        // 新建HashSet
        HashSet set = new HashSet();

        testHashSetAPI();

        // 添加元素 到HashSet中
        for (int i = 0; i < 5; i++) {
            set.add("" + i);
        }
        // 通过Iterator遍历HashSet
//        iteratorHashSet(set);

        // 通过for-each遍历HashSet
//        foreachHashSet(set);
    }

    private static void testHashSetAPI() {
        // 新建HashSet
        HashSet set = new HashSet();

        // 将元素添加到Set中
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        set.add("e");

        // 打印HashSet的实际大小
        System.out.printf("size : %d\n", set.size());

        // 判断HashSet是否包含某个值
        System.out.printf("HashSet contains a :%s\n", set.contains("a"));
        System.out.printf("HashSet contains g :%s\n", set.contains("g"));

        // 删除HashSet中的“e”
        set.remove("e");

        // 将Set转换为数组
        String[] arr = (String[]) set.toArray(new String[0]);
        for (String str : arr) {
            System.out.printf("for each : %s\n", str);
        }


        // 新建一个包含b、c、f的HashSet
        HashSet otherset = new HashSet();
        otherset.add("b");
        otherset.add("c");
        otherset.add("f");

        // 克隆一个removeset，内容和set一模一样
        HashSet removeset = (HashSet) set.clone();
        // 删除“removeset中，属于otherSet的元素”
        removeset.removeAll(otherset);
        // 打印removeset
        System.out.printf("removeset : %s\n", removeset);

        // 克隆一个retainset，内容和set一模一样
        HashSet retainset = (HashSet) set.clone();
        // 保留“retainset中，属于otherSet的元素”
        retainset.retainAll(otherset);
        // 打印retainset
        System.out.printf("retainset : %s\n", retainset);


        // 遍历HashSet
        for (Iterator iterator = set.iterator();
             iterator.hasNext(); )
            System.out.printf("iterator : %s\n", iterator.next());

        // 清空HashSet
        set.clear();

        // 输出HashSet是否为空
        System.out.printf("%s\n", set.isEmpty() ? "set is empty" : "set is not empty");
    }

    /*
     * 通过Iterator遍历HashSet。推荐方式
     * 遍历的放大速度比较慢
     */
    private static void iteratorHashSet(HashSet set) {
        long beginTime = System.currentTimeMillis();
        System.out.println("=====iterator HashSet===begin==" + beginTime);
        for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
            //测试遍历时间
//            Object object = new Object();
            System.out.printf("iterator : %s\n", iterator.next());
        }
        System.out.println("=====iterator HashSet===end==" + (System.currentTimeMillis() - beginTime));
    }

    /*
     * 通过for-each遍历HashSet。不推荐！此方法需要先将Set转换为数组
     * 但是这种遍历方法速度比较快
     */
    private static void foreachHashSet(HashSet set) {
        long beginTime = System.currentTimeMillis();
        System.out.println("=====foreach HashSet===begin==" + beginTime);
        String[] arr = (String[]) set.toArray(new String[0]);
        for (String str : arr) {
            //测试遍历时间
//            Object object = new Object();
            System.out.printf("for each : %s\n", str);
        }
        System.out.println("=====foreach HashSet===end==" + (System.currentTimeMillis() - beginTime));
    }
}
