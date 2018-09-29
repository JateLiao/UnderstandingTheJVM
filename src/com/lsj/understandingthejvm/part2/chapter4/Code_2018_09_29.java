package com.lsj.understandingthejvm.part2.chapter4;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc Code_2018_09_29
 * @ProjectName UnderstandingTheJVM
 * @Company com.lsj
 * @CreateTime 2018/9/29 21:44
 * @Author tianzhong
 */
public class Code_2018_09_29 {
    /**
     * Main Method: 请开始你的操作.
     *
     */
    public static void main(String[] args) {
        // 测试OOM
        /**
         * JVM参数: -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:/Test/Dump/dump.log
         */
        int _1M = 1 * 1024 * 1024;
        List<byte[]> myList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            byte[] arr = new byte[_1M]; // 申请1M内存
            myList.add(arr);
            System.out.println("已申请：" + (i + 1) + "M 内存");
        }
    }
}
