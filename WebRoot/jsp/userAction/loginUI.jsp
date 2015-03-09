<%@ page language="java" import="java.util.*,com.njit.lib.domain.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    
    <title>登陆页面</title>
  </head>
  <body>
  <%--<%
				User user = (User)session.getAttribute("user");
				out.print("username"+user.getName());
				
			%>  
  --%><s:form action="user_login" method="post">
  	登录名：<input name="loginName" type="text"/>,<br/>
  	密码：<input name="password" type="password"/>
  	<s:submit value="提交"></s:submit>
  	<s:reset value="取消"></s:reset>
  </s:form>
  <s:fielderror name="error"></s:fielderror>
  <s:debug></s:debug>
  </body>
</html>
