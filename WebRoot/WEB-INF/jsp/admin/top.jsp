<%@ page language="java" import="java.util.*,com.njit.lib.domain.User" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'top.jsp' starting page</title>
  </head>
  
  <body>
  后台管理系统<br/>
  <center>当前用户：[<s:property value="#session.user.name"/>]  <s:a action="user_logout">注销</s:a></center>
  <s:debug></s:debug>
  </body>
</html>
