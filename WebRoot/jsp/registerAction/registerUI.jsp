<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!-- 
TODO:
	address:Address
	birthday的表现形式
 -->
<html>
	<head>
	</head>
	<body>
	<s:fielderror name="file"></s:fielderror>
		<s:form action="register_add" enctype="multipart/form-data" method="post">
		
			<table>
					<tr>
						<td><s:file name="file" label="上传图像"></s:file></td>
					</tr>
					<tr>
						<td>昵称</td>
						<td><input type="text" name="name" /></td>
					</tr>
					<tr>
						<td>登录名：</td>
						<td><input type="text" name="loginName" /></td>
					</tr>
					<tr>
						<td>密码</td>
						<td><input type="password" name="password" /></td>
					</tr>
					<tr>
						<td>请确认密码</td>
						<td><input type="text" name="password2" /></td>
					</tr>
					<tr>
						<td>邮箱地址</td>
						<td><input type="text" name="eamil" /></td>
					</tr>
					<tr>
						<td>QQ号码</td>
						<td><input type="text" name="qq" /></td>
					</tr>
					<tr>
						<td>联系方式</td>
						<td><input type="text" name="phone" /></td>
					</tr>
					<tr>
						<td>地址</td><td><s:textfield name="address.district" label="区"></s:textfield></td>
						<td><s:textfield name="address.dormitory" label="宿舍楼"></s:textfield></td>
						<td><s:textfield name="address.area" label="座"></s:textfield></td>
						<td><s:textfield name="address.floor" label="层"></s:textfield></td>
						<td><s:textfield name="address.room" label="房间"></s:textfield></td>
						<td><s:textfield name="address.bed" label="床位"></s:textfield></td>
					</tr>
					<tr>
						<td>出生日期</td>
						<td><input type="text" name="birthday" /></td>
					</tr>
					<tr>
						<td>个人简介</td>
						<td><s:textarea rows="10"></s:textarea></td>
					</tr>
					<tr>
						<td><input type="submit" value="提交"/></td>
						<td><input type="reset" value="取消"/></td>
					</tr>
			</table>
		</s:form>
	</body>
</html>
