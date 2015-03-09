<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>My JSP 'saveUI.jsp' starting page</title>
  </head>
  
  <body>
  	<s:form action="news_%{id == null ? 'add' : 'update'}">
  		<s:hidden name="id"></s:hidden>
  		<s:hidden name="type"></s:hidden>
  		<table>
  			<tr><s:textfield name="title" label="标题"></s:textfield></tr>
  			<tr><s:textarea name="content" label="简介"></s:textarea></tr>
  			<tr>
  				<td><s:submit value="提交"></s:submit></td>
  				<td><s:reset value="取消"></s:reset></td>
  			</tr>	
  		</table>
  		
		  		
  		
  	</s:form>
  </body>
</html>
