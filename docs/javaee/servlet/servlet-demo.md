# 编写Servlet

# 部署Servlet

## web.xml是什么

## <servlet>

`<servlet>`元素用于注册Servlet。

`<servlet>`包含有两个主要的子元素：`<servlet-name>`和`<servlet-class>`，分别用于设置Servlet的注册名称和Servlet的完整类名。 

如果在`<servlet>`元素中配置了一个`<load-on-startup>`元素，那么WEB应用程序在启动时，就会装载并创建Servlet的实例对象、以及调用Servlet实例对象的init()方法。

```xml
<servlet>
  <servlet-name>HelloServlet</servlet-name>
  <servlet-class>org.zp.notes.javaee.servlet.HelloServlet</servlet-class>
  <load-on-startup>1</load-on-startup>
</servlet>
```

## <servlet-mapping>

`<servlet-mapping>`元素用于映射一个已注册的Servlet的一个对外访问路径。

`<servlet-mapping>`包含有两个子元素：`<servlet-name>`和`<url-pattern>`，分别用于指定Servlet的注册名称和Servlet的对外访问路径。

**注：同一个Servlet可以被映射到多个URL上。**例：

```xml
<servlet>
  <servlet-name>HelloServlet</servlet-name>
  <servlet-class>org.zp.notes.javaee.servlet.HelloServlet</servlet-class>
</servlet>
<servlet-mapping>
  <servlet-name>HelloServlet</servlet-name>
  <url-pattern>/servlet/HelloServlet</url-pattern>
  <url-pattern>/servlet/HelloServlet.asp</url-pattern>
  <url-pattern>/servlet/HelloServlet.jsp</url-pattern>
  <url-pattern>/servlet/HelloServlet.php</url-pattern>
  <url-pattern>/servlet/HelloServlet.aspx</url-pattern>
</servlet-mapping>
```

### url-pattern的通配符

/

如果某个Servlet的映射路径仅仅为一个正斜杠`/`，那么这个Servlet就成为当前Web应用程序的缺省Servlet。 凡是在`web.xml`文件中找不到匹配的`<servlet-mapping>`元素的URL，它们的访问请求都将交给缺省Servlet处理，也就是说，缺省Servlet用于处理所有其他Servlet都不处理的访问请求。

*

`*`可以匹配任意的字符。

/*

## <init-param>和<context-param>

`<init-param>`标签用于为当前servlet配置一些初始化参数。

`<context-param>`标签用于配置全局的初始化参数，所有servlet都可以使用。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="3.0" xmlns="http://java.sun.com/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee 
    http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd">
    <display-name></display-name>
    <!-- 配置WEB应用的初始化参数 -->
    <context-param>
        <param-name>datasource</param-name>
        <param-value>jdbc:mysql://localhost:3306/test</param-value>
    </context-param>

    <welcome-file-list>
        <welcome-file>index.jsp</welcome-file>
    </welcome-file-list>
</web-app>
```