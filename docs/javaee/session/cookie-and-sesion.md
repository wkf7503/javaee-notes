---
title: JavaEE Cookie vs. Session
date: 2017/11/08
categories:
- javaee
tags:
- javaee
- cookie
- session
---

## 存取方式

Cookie只能保存`ASCII`字符串，如果需要存取Unicode字符或二进制数据，需要进行`UTF-8`、`GBK`或`BASE64`等方式的编码。

Session可以存取任何类型的数据，甚至是任何Java类。可以将Session看成是一个Java容器类。

## 隐私安全

Cookie存于客户端浏览器，一些客户端的程序可能会窥探、复制或修改Cookie内容。

Session存于服务器，对客户端是透明的，不存在敏感信息泄露的危险。

## 有效期

使用Cookie可以保证长时间登录有效，只要设置Cookie的`maxAge`属性为一个很大的数字。

而Session虽然理论上也可以通过设置很大的数值来保持长时间登录有效，但是，由于Session依赖于名为`JESSIONID`的Cookie，而Cookie `JESSIONID`的`maxAge`默认为-1，只要关闭了浏览器该Session就会失效，因此，Session不能实现信息永久有效的效果。使用URL地址重写也不能实现。

## 服务器的开销

由于Session是保存在服务器的，每个用户都会产生一个Session，如果并发访问的用户非常多，会产生很多的Session，消耗大量的内存。

而Cookie由于保存在客户端浏览器上，所以不占用服务器资源。

## 浏览器的支持

Cookie需要浏览器支持才能使用。

如果浏览器不支持Cookie，需要使用Session以及URL地址重写。

需要注意的事所有的用到Session程序的URL都要使用`response.encodeURL(StringURL)` 或`response.encodeRediretURL(String URL)`进行URL地址重写，否则导致Session会话跟踪失效。

## 跨域名

Cookie支持跨域名。

Session不支持跨域名。
