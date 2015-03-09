<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>My JSP 'list.jsp' starting page</title>
	</head>
	<body>
		<table>
			<tr>
				<th>
					角色名称
				</th>
				<th>
					角色说明
				</th>
				<th>
					操作
				</th>
			</tr>
			<s:iterator value="#roleList">
				<tr>
					<td>
						${name}
					</td>
					<td>
						${description}
					</td>
					<td>
						<s:a action="role_updateUI?id=%{id}">修改</s:a> 
						<s:a action="role_delete?id=%{id}">删除</s:a> 
						<s:a action="role_setPrivilegeUI?id=%{id}">设置权限</s:a>
					</td>
				</tr>

			</s:iterator>
		</table>
		<s:a action="role_addUI">添加</s:a>
	</body>
</html>
