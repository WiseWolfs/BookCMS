<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'logout.jsp' starting page</title>
  </head>
  
  <body>
  	当前用户已经注销登录<s:property value="#session.user.name"/>
  </body>
</html>
