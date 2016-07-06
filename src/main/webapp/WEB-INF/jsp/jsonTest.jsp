<%--
  Created by IntelliJ IDEA.
  User: jiaranran
  Date: 2016/7/4
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>json交互测试</title>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.js"/>
  <script type="text/javascript">
    function requestJson(){
      $.ajax({
        type:'post';
        url:'${pageContext.request.contextPath}/requestJson.do';
        contentType:'application/json;charset=utf-8';
        data:'{"name":手机，"price":"999"}';
        success:function(data){
          alert(data);
        }
      });
    }
    function responseJson(){
      $.ajax({
        type:'post';
        url:'${pageContext.request.contextPath}/responseJson.do';
        data:'name=手机&&price=999';
        success:function(data){
          alert(data);
        }
      });
    }
  </script>
</head>
<body>
  <input type="button" onclick="requestJson()" value="请求json输出json"/>
  <input type="button" onclick="responseJson()" value="请求key/value输出json"/>
</body>
</html>
