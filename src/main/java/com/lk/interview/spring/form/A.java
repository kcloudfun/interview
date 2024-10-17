package com.lk.interview.spring.form;

/**
 * 被面试官问到后端接前端form表单需要怎么特殊处理？哎，这问的我不知所措，就记录一下。可能他一直是固定的前后端不分离的项目，一直在自己写前端js，所以觉得这个基础问题，工作7年的人肯定会记得。
 * 实际是：现在spring boot前后端分离模式，后端基本不怎么关注Content-Type，知道有几种传参方式，postman怎么点就完事了。
 * 最后测试也是，几乎不需要任何处理，放一个对象在controller方法上即可接收（属性名和前端一致）
 */
public class A {
}
