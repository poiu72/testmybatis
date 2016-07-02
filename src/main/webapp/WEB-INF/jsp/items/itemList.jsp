<%--
  Created by IntelliJ IDEA.
  User: jiaranran
  Date: 2016/6/30
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>查询商品列表</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/items/queryItem.do" method="post">
  <table width="100%" border="1">
    <tr>
      <td><input type="submit" value="查询"/></td>
    </tr>
  </table>
  商品列表：
  <table width="100%" border="1">
    <tr>
      <td>商品名称</td>
      <td>商品价格</td>
      <td>商品日期</td>
      <td>商品描述</td>
      <td>操作</td>
    </tr>
    <c:forEach items="${list}" var="item">
      <tr>
        <td>${item.name}</td>
        <td>${item.price}</td>
        <td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        <td>${item.detail}</td>
        <td><a href="${pageContext.request.contextPath}/itemController/editItem.do?id=${item.id}" />修改</td>
      </tr>
    </c:forEach>
  </table>
</form>
</body>
</html>
