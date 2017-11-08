---
title: JSTL 核心标签
date: 2017/11/08
categories:
- javaee
tags:
- javaee
- jstl
---

核心标签是最常用的JSTL标签。引用核心标签库的语法如下：

```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
```

| 标签              | 描述                                       |
| --------------- | ---------------------------------------- |
| `<c:out>`       | 用于在JSP中显示数据，就像<%= ... >                  |
| `<c:set>`       | 用于保存数据                                   |
| `<c:remove>`    | 用于删除数据                                   |
| `<c:catch>`     | 用来处理产生错误的异常状况，并且将错误信息储存起来                |
| `<c:if>`        | 与我们在一般程序中用的if一样                          |
| `<c:choose>`    | 本身只当做`<c:when>`和`<c:otherwise>`的父标签      |
| `<c:when>`      | `<c:choose>`的子标签，用来判断条件是否成立              |
| `<c:otherwise>` | `<c:choose>`的子标签，接在`<c:when>`标签后，当`<c:when>`标签判断为false时被执行 |
| `<c:import>`    | 检索一个绝对或相对 URL，然后将其内容暴露给页面                |
| `<c:forEach>`   | 基础迭代标签，接受多种集合类型                          |
| `<c:forTokens>` | 根据指定的分隔符来分隔内容并迭代输出                       |
| `<c:param>`     | 用来给包含或重定向的页面传递参数                         |
| `<c:redirect>`  | 重定向至一个新的URL.                             |
| `<c:url>`       | 使用可选的查询参数来创造一个URL                        |

## `<c:out>` 标签

`<c:out>`标签用来显示一个表达式的结果，与`<%= %>`作用相似，它们的区别就是`<c:out>`标签可以直接通过"."操作符来访问属性。

举例来说，如果想要访问customer.address.street，只需要这样写：

```jsp
<c:out value="customer.address.street">
```

`<c:out>`标签会自动忽略XML标记字符，所以它们不会被当做标签来处理。

### 语法格式

```jsp
<c:out value="<string>" default="<string>" escapeXml="<true|false>"/>
```

### 属性

`<c:out>`标签有如下属性：

| **属性**    | **描述**      | **是否必要** | **默认值** |
| --------- | ----------- | -------- | ------- |
| value     | 要输出的内容      | 是        | 无       |
| default   | 输出的默认值      | 否        | 主体中的内容  |
| escapeXml | 是否忽略XML特殊字符 | 否        | true    |

## `<c:set>` 标签

`<c:set>`标签用于设置变量值和对象属性。

`<c:set>`标签就是`<jsp:setProperty>`行为标签的孪生兄弟。

这个标签之所以很有用呢，是因为它会计算表达式的值，然后使用计算结果来设置 JavaBean 对象或 java.util.Map 对象的值。

### 语法格式

```jsp
<c:set
   var="<string>"
   value="<string>"
   target="<string>"
   property="<string>"
   scope="<string>"/>
```

### 属性

`<c:set>`标签有如下属性：

| **属性**   | **描述**      | **是否必要** | **默认值** |
| -------- | ----------- | -------- | ------- |
| value    | 要存储的值       | 否        | 主体的内容   |
| target   | 要修改的属性所属的对象 | 否        | 无       |
| property | 要修改的属性      | 否        | 无       |
| var      | 存储信息的变量     | 否        | 无       |
| scope    | var属性的作用域   | 否        | Page    |

如果指定了target属性，那么property属性也需要被指定。

## `<c:remove>` 标签

`<c:remove>`标签用于移除一个变量，可以指定这个变量的作用域，若未指定，则默认为变量第一次出现的作用域。

这个标签不是特别有用，不过可以用来确保JSP完成清理工作。

### 语法格式

```jsp
<c:remove var="<string>" scope="<string>"/>
```

### 属性

`c:remove>`标签有如下属性：

| **属性** | **描述**   | **是否必要** | **默认值** |
| ------ | -------- | -------- | ------- |
| var    | 要移除的变量名称 | 是        | 无       |
| scope  | 变量所属的作用域 | 否        | 所有作用域   |

## `<c:catch>` 标签

`<c:catch>` 标签主要用来处理产生错误的异常状况，并且将错误信息储存起来。

### 语法格式

```jsp
<c:catch var="<string>">
...
</c:catch>
```

### 属性

`<c:catch>`标签有如下属性：

| 属性   | 描述          | 是否必要 | 默认值  |
| ---- | ----------- | ---- | ---- |
| var  | 用来储存错误信息的变量 | 否    | None |

## `<c:if>` 标签

`<c:if>`标签判断表达式的值，如果表达式的值为 true 则执行其主体内容。

### 语法格式

```jsp
<c:if test="<boolean>" var="<string>" scope="<string>">
   ...
</c:if>
```

### 属性

`<c:if>`标签有如下属性：

| **属性** | **描述**      | **是否必要** | **默认值** |
| ------ | ----------- | -------- | ------- |
| test   | 条件          | 是        | 无       |
| var    | 用于存储条件结果的变量 | 否        | 无       |
| scope  | var属性的作用域   | 否        | page    |

## `<c:choose>`, `<c:when>`, `<c:otherwise>` 标签

`<c:choose>`标签与Java switch语句的功能一样，用于在众多选项中做出选择。

switch语句中有case，而`<c:choose>`标签中对应有`<c:when>`，switch语句中有default，而`<c:choose>`标签中有`<c:otherwise>`。

### 语法格式

```jsp
<c:choose>
    <c:when test="<boolean>"/>
        ...
    </c:when>
    <c:when test="<boolean>"/>
        ...
    </c:when>
    ...
    ...
    <c:otherwise>
        ...
    </c:otherwise>
</c:choose>
```

### 属性

- `<c:choose>`标签没有属性。
- `<c:when>`标签只有一个属性，在下表中有给出。
- `<c:otherwise>`标签没有属性。

`<c:when>`标签的属性如下：

| **属性** | **描述** | **是否必要** | **默认值** |
| ------ | ------ | -------- | ------- |
| test   | 条件     | 是        | 无       |

## `<c:import>` 标签

`<c:import>`标签提供了所有`<jsp:include>`行为标签所具有的功能，同时也允许包含绝对URL。

举例来说，使用`<c:import>`标签可以包含一个FTP服务器中不同的网页内容。

### 语法格式

```jsp
<c:import
   url="<string>"
   var="<string>"
   scope="<string>"
   varRender="<string>"
   context="<string>"
   charEncoding="<string>"/>
```

### 属性

`<c:import>`标签有如下属性：

| **属性**       | **描述**                                   | **是否必要** | **默认值**    |
| ------------ | ---------------------------------------- | -------- | ---------- |
| url          | 待导入资源的URL，可以是相对路径和绝对路径，并且可以导入其他主机资源      | 是        | 无          |
| context      | 当使用相对路径访问外部context资源时，context指定了这个资源的名字。 | 否        | 当前应用程序     |
| charEncoding | 所引入的数据的字符编码集                             | 否        | ISO-8859-1 |
| var          | 用于存储所引入的文本的变量                            | 否        | 无          |
| scope        | var属性的作用域                                | 否        | page       |
| varReader    | 可选的用于提供java.io.Reader对象的变量               | 否        | 无          |

## `<c:forEach>`, `<c:forTokens>` 标签

[![JSP 标准标签库](http://www.runoob.com/images/up.gif)JSP 标准标签库](http://www.runoob.com/jsp/jsp-jstl.html)

这些标签封装了Java中的for，while，do-while循环。

相比而言，`<c:forEach>`标签是更加通用的标签，因为它迭代一个集合中的对象。

`<c:forTokens>`标签通过指定分隔符将字符串分隔为一个数组然后迭代它们。

### `forEach` 语法格式

```jsp
<c:forEach
    items="<object>"
    begin="<int>"
    end="<int>"
    step="<int>"
    var="<string>"
    varStatus="<string>">

    ...
```

### `forTokens` 语法格式

```jsp
<c:forTokens
    items="<string>"
    delims="<string>"
    begin="<int>"
    end="<int>"
    step="<int>"
    var="<string>"
    varStatus="<string>">
```

### 属性

`<c:forEach>`标签有如下属性：

| **属性**    | **描述**                  | **是否必要** | **默认值**      |
| --------- | ----------------------- | -------- | ------------ |
| items     | 要被循环的信息                 | 否        | 无            |
| begin     | 开始的元素（0=第一个元素，1=第二个元素）  | 否        | 0            |
| end       | 最后一个元素（0=第一个元素，1=第二个元素） | 否        | Last element |
| step      | 每一次迭代的步长                | 否        | 1            |
| var       | 代表当前条目的变量名称             | 否        | 无            |
| varStatus | 代表循环状态的变量名称             | 否        | 无            |

`<c:forTokens>`标签与`<c:forEach>`标签有相似的属性，不过`<c:forTokens>`还有另一个属性：

| **属性** | **描述** | **是否必要** | **默认值** |
| ------ | ------ | -------- | ------- |
| delims | 分隔符    | 是        | 无       |

## `<c:param>` 标签

`<c:param>`标签用于在`<c:url>`标签中指定参数，而且与URL编码相关。

在`<c:param>`标签内，name属性表明参数的名称，value属性表明参数的值。

### 语法格式

```jsp
<c:param name="<string>" value="<string>"/>
```

### 属性

`<c:param>`标签有如下属性：

| **属性** | **描述**        | **是否必要** | **默认值** |
| ------ | ------------- | -------- | ------- |
| name   | URL中要设置的参数的名称 | 是        | 无       |
| value  | 参数的值          | 否        | Body    |

## `<c:redirect>` 标签

`<c:redirect>`标签通过自动重写URL来将浏览器重定向至一个新的URL，它提供内容相关的URL，并且支持c:param标签。

### 语法格式

```
<c:redirect url="<string>" context="<string>"/>
```

### 属性

`<c:redirect>`标签有如下属性：

| **属性**  | **描述**           | **是否必要** | **默认值** |
| ------- | ---------------- | -------- | ------- |
| url     | 目标URL            | 是        | 无       |
| context | 紧接着一个本地网络应用程序的名称 | 否        | 当前应用程序  |

## `<c:url>` 标签

`<c:url>`标签将URL格式化为一个字符串，然后存储在一个变量中。

这个标签在需要的时候会自动重写URL。

var属性用于存储格式化后的URL。

`<c:url>`标签只是用于调用`response.encodeURL()`方法的一种可选的方法。它真正的优势在于提供了合适的URL编码，包括`<c:param>`中指定的参数。

### 语法格式

```jsp
<c:url
  var="<string>"
  scope="<string>"
  value="<string>"
  context="<string>"/>
```

### 属性

`<c:url>`标签有如下属性：

| **属性**  | **描述**      | **是否必要** | **默认值**       |
| ------- | ----------- | -------- | ------------- |
| value   | 基础URL       | 是        | 无             |
| context | 本地网络应用程序的名称 | 否        | 当前应用程序        |
| var     | 代表URL的变量名   | 否        | Print to page |
| scope   | var属性的作用域   | 否        | Page          |
