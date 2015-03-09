<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>My JSP 'saveUI.jsp' starting page</title>
  </head>
  
  <body>
  	<s:form action="advertisement_%{id == null ? 'add' : 'update'}" method="post" enctype="multipart/form-data">
  		<s:hidden name="id"></s:hidden>
  		<table>
  			<tr><s:file name="file" label="上传文件"></s:file></tr>
  			<tr><s:textfield name="url" label="链接地址"></s:textfield></tr>
  			<tr>
  				<td><s:submit value="提交"></s:submit></td>
  				<td><s:reset value="取消"></s:reset></td>
  			</tr>	
  		</table>
  		
		  		
  		
  	</s:form>
  </body>
</html>
