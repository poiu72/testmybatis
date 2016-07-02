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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>商品修改</title>
</head>
<body>
<form id="itemForm" action="${pageContext.request.contextPath}/items/editItemSubmit.do" method="post" enctype="multipart/form-data">
  <input type="hidden" name="id" value="${itemCustom.id}"/>
  修改商品信息：
  <table width="100%" border="1">
    <tr>
      <td>商品名称</td>
      <td><input type="text" name="name" value="${itemCustom.name}"/></td>
    </tr>
    <tr>
      <td>商品价格</td>
      <td> <input type="text" name="price" value="${itemCustom.price}"/></td>
    </tr>
    <tr>
      <td>商品日期</td>
      <td><input type="text" name="createtime" value="<fmt:formatDate value="${itemCustom.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
    </tr>
    <tr>
      <td>商品描述</td>
      <td><textarea rows="3" cols="30" name="detail">${itemCustom.detail}</textarea></td>
    </tr>
    <td colspan="2" align="center">
      <input type="submit" value="提交"/>
    </td>
  </table>
</form>
</body>
</html>
