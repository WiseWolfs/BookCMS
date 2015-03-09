<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>My JSP 'list.jsp' starting page</title>
	</head>
	<body>
		<s:iterator value="#application.privilegeList" >
			<h3>
				<s:property value="name" />
				<input type="checkbox" name="privilegeIds" <s:property value="%{id in privilegeIds ? 'checked':''}"/>/>
			</h3>
			<s:iterator value="children">
				<s:property value="name" />
				<input type="checkbox" name="privilegeIds" <s:property value="%{id in privilegeIds ? 'checked':''}"/>/>
			</s:iterator>
			<br />
		</s:iterator>
		<s:debug></s:debug>

	
	</body>
</html>
