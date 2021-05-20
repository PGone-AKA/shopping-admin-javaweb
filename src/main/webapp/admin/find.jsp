<%@ page import="java.util.List" %>
<%@ page import="com.example.test.Admin" %>
<%@ page import="com.example.dao.AdminDao" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.example.test.User" %><%--
  Created by IntelliJ IDEA.
  User: 13474
  Date: 2021/5/15
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查找所用用户</title>
</head>
<body>
<%
    Iterator itr = (Iterator) request.getAttribute("userFind");
%>
<table align="center" border="2">
    <tr>
        <th>账户</th>
        <th>密码</th>
        <th>性别</th>
        <th>年龄</th>
        <th>手机号</th>
        <th>余额</th>
    </tr>
    <% while (itr.hasNext()){
        User user = (User) itr.next();
    %>
    <tr>
        <td><%=user.getName()%></td>
        <td><%=user.getPd()%></td>
        <td><%=user.getSex()%></td>
        <td><%=user.getAge()%></td>
        <td><%=user.getPhone()%></td>
        <td><%=user.getBalance()%></td>
    </tr>
    <%
    }
    %>



</table>

</body>
</html>
