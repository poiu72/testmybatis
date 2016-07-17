<%--
  Created by IntelliJ IDEA.
  User: jiaranran
  Date: 2016/7/13
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title></title>
</head>
<body>
  <a href="../j_spring_security_logout">logout</a>
  <hr>
  input:form
  <hr>
<sec:authorize access="hasRole('ROLE_USER')">
  <s:form action="home" commandName="user" method="post">
    <s:input path="username"/><br>
    <s:input path="password"/><br>
    <s:button vlue="submit">submit</s:button>
  </s:form>
</sec:authorize>

</body>
</html>
