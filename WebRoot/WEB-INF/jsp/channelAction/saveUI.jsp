<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>My JSP 'saveUI.jsp' starting page</title>
  </head>
  
  <body>
  	<s:form action="channel_%{id == null ? 'add' : 'update'}"  enctype="multipart/form-data">
  		<s:hidden name="id"></s:hidden>
  		<s:hidden name="type"></s:hidden>
  		<table>
  			<tr><s:file name="file" label="上传图片"></s:file></tr>
  			<tr><s:textarea name="profile" label="简介"></s:textarea></tr>
  			<tr>
  				<td><s:submit value="提交"></s:submit></td>
  				<td><s:reset value="取消"></s:reset></td>
  			</tr>	
  		</table>
  		
		  		
  		
  	</s:form>
  </body>
</html>
