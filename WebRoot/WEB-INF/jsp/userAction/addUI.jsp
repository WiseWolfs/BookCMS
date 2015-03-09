<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	</head>

	<body>
		<s:form action="user_%{id == null ? 'add' : 'update'}" method="post">

			<s:hidden name="id"></s:hidden>
			<table>
				<tr>
					<td><s:textfield name="name" label="用户名"/></td>
				</tr>
				<tr>
					<td><s:textfield name="loginName" label="登录名"/></td>
				</tr>				
				<tr>
					<td> 密码<input type="password" name="password" /></td>
				</tr>
				<s:select list="#roleList" listKey="id" listValue="name" name="roleId">
				
				</s:select>
				<tr>
					<td><s:submit value="提交"></s:submit></td>
		  			<td><s:reset value="取消"></s:reset></td>
				</tr>
			</table>
		</s:form>
		<s:debug></s:debug>
	</body>
</html>
