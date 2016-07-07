<%--
  Created by IntelliJ IDEA.
  User: jiaranran
  Date: 2016/7/4
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login.do" method="post">
  用户名：<input type="text" name="username"/>
  用户名：<input type="password" name="password"/>
  <input type="submit" value="登录"/>
</form>
</body>
</html>
