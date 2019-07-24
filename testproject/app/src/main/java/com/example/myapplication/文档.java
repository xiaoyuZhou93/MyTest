package com.example.myapplication;

/**
 *                          Handler
 * hander :  用来发送消息和处理消息的
 *      Send :  通过SendMessageAtTime()方法实现
 *      Post :  通过send一系类方法实现
 *
 * masage : 用来线程直接交互数据 可携带少量数据
 *
 * masg Queue:  消息队列 单向链表
 *      next :              无限循环
 *      enQueueMessage() :  向链表中插入一条数据
 *
 * looper : 轮询器 从queue里面取出数据
 *
 * Theradlcal: 保证每个线程中只存在一个 messageQueue和Looper
 *              Threadlocal是一个线程内部的数据存储类
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
