package com.test.mapper;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ConsoleClock {
    public static void main(String[] args) {
        // 创建时间格式化器
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        // 无限循环显示时钟
        while (true) {
            // 获取当前时间
            LocalTime currentTime = LocalTime.now();

            // 格式化并显示时间
            String formattedTime = currentTime.format(formatter);
            System.out.print("\r" + formattedTime); // \r 将光标移回行首

            try {
                // 暂停1秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // 如果线程被中断，退出程序
                System.out.println("\n时钟已停止");
                return;
            }
        }
    }
}