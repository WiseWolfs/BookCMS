<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'show.jsp' starting page</title>
  </head>
  <body>
  <s:debug></s:debug>
  <%@include file="/jsp/indexAction/top.jsp" %>
  		<center>
			<s:a action="news_previous?id=%{id}&type=%{type}">上一篇</s:a> 
			<s:a action="news_next?id=%{id}&type=%{type}">下一篇</s:a>
		</center><br/>
		发表时间：<s:property value="%{publishTime}"/>
		阅览次数：<s:property value="%{viewCount}"/>
		<br/>
		
	  <s:textarea   cssStyle="width:1080px;height:500px" value="%{content}">
	  </s:textarea>
  <%@include file="/jsp/indexAction/bottom.jsp" %>
  </body>
</html>
