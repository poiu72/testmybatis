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
  <script type="text/javascript">
    function deleteItem(){
      alert(1);
      document.itemForm.action = "${pageContext.request.contextPath}/itemController/deleteItem.do";
      document.itemForm.submit();
    }
    function queryItem(){
      document.itemForm.action = "${pageContext.request.contextPath}/itemController/queryItem.do";
      document.itemForm.submit();
    }
  </script>
</head>
<body>
${username},生意兴隆
<form name="itemForm" action="${pageContext.request.contextPath}/itemController/queryItem.do" method="post">
  查询条件：
  <table width="100%" border="1">
    <tr>
      <td>
        商品名称：<input name="itemCustom.name"/>
        商品类型：
        <select name="itemType" >
          <c:forEach items="${itemTypes}" var="itemType">
            <option value="${itemType.key}" >${itemType.value}</option>
          </c:forEach>
        </select>
      </td>
      <td><input type="submit" value="查询" onclick="queryItem()"/>
        <input type="submit" value="批量删除" onclick="deleteItem()"/>
      </td>
    </tr>
  </table>
  商品列表：
  <table width="100%" border="1">
    <tr>
      <td>选择</td>
      <td>商品名称</td>
      <td>商品价格</td>
      <td>商品日期</td>
      <td>商品描述</td>
      <td>操作</td>
    </tr>
    <c:forEach items="${list}" var="item">

      <tr>
        <td><input type="checkbox" name="item_id" value="${item.id}"/></td>
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
