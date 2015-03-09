<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>My JSP 'saveUI.jsp' starting page</title>
  </head>
  <body>
  <s:form action="role_%{id == null ? 'add' : 'update'}">
  <table>
  <s:hidden name="id"></s:hidden>
  	<tr>
	  	<td>角色名称：<s:textfield name="name"></s:textfield></td>
  	</tr>
  	<tr>
  		<td>
	  		角色描述：<s:textarea name="description"></s:textarea>
  		</td>
  	</tr>
  	<s:submit value="提交"></s:submit>
  	<s:reset value="取消"></s:reset>
  	</table>
  	
  </s:form>
  </body>
</html>
