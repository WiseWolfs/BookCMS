<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>My JSP 'saveUI.jsp' starting page</title>
  </head>
  <body>
  	<s:form	action="remark_add">
  		<s:hidden name="id"></s:hidden>
  
  		<s:property value="id"/>
		<s:textfield name="content" label="内容"></s:textfield>
		<s:submit value="提交"></s:submit>
		<s:reset value="取消"></s:reset>  	
  	</s:form>
  </body>
</html>
