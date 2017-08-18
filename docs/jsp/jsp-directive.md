# JSP 指令

## 概述

JSP指令用来设置整个JSP页面相关的属性，如网页的编码方式和脚本语言。

JSP指令以开`<%@`开始，以`%>`结束。

JSP指令语法格式如下：

```jsp
<%@ directive attribute="value" %>
```

指令可以有很多个属性，它们以键值对的形式存在，并用逗号隔开。

JSP中的三种指令标签：

| **指令**             | **描述**                         |
| ------------------ | ------------------------------ |
| <%@ page ... %>    | 定义网页依赖属性，比如脚本语言、error页面、缓存需求等等 |
| <%@ include ... %> | 包含其他文件                         |
| <%@ taglib ... %>  | 引入标签库的定义，可以是自定义标签              |

## Page指令

Page指令为容器提供当前页面的使用说明。一个JSP页面可以包含多个`page`指令。

Page指令的语法格式：

```jsp
<%@ page attribute="value" %>
```

等价的XML格式：

```jsp
<jsp:directive.page attribute="value" />
```

例：

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
```

### 属性

下表列出与Page指令相关的属性：

| **属性**             | **描述**                      |
| ------------------ | --------------------------- |
| buffer             | 指定out对象使用缓冲区的大小             |
| autoFlush          | 控制out对象的 缓存区                |
| contentType        | 指定当前JSP页面的MIME类型和字符编码       |
| errorPage          | 指定当JSP页面发生异常时需要转向的错误处理页面    |
| isErrorPage        | 指定当前页面是否可以作为另一个JSP页面的错误处理页面 |
| extends            | 指定servlet从哪一个类继承            |
| import             | 导入要使用的Java类                 |
| info               | 定义JSP页面的描述信息                |
| isThreadSafe       | 指定对JSP页面的访问是否为线程安全          |
| language           | 定义JSP页面所用的脚本语言，默认是Java      |
| session            | 指定JSP页面是否使用session          |
| isELIgnored        | 指定是否执行EL表达式                 |
| isScriptingEnabled | 确定脚本元素能否被使用                 |

## Include指令

JSP可以通过`include`指令来包含其他文件。

被包含的文件可以是JSP文件、HTML文件或文本文件。包含的文件就好像是该JSP文件的一部分，会被同时编译执行。

Include指令的语法格式如下：

```jsp
<%@ include file="文件相对 url 地址" %>
```

**include** 指令中的文件名实际上是一个相对的 URL 地址。

如果您没有给文件关联一个路径，JSP编译器默认在当前路径下寻找。

等价的XML语法：

```jsp
<jsp:directive.include file="文件相对 url 地址" />
```

## Taglib指令

JSP 允许用户自定义标签，一个自定义标签库就是自定义标签的集合。

`taglib`指令引入一个自定义标签集合的定义，包括库路径、自定义标签。

`taglib`指令的语法：

```jsp
<%@ taglib uri="uri" prefix="prefixOfTag" %>
```

uri属性确定标签库的位置，prefix属性指定标签库的前缀。

等价的XML语法：

```jsp
<jsp:directive.taglib uri="uri" prefix="prefixOfTag" />
```