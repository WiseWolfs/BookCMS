<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>My JSP 'saveUI.jsp' starting page</title>
	</head>
	<body>
		<s:form action="message_%{id == null ? 'add' : 'update'}">
		<s:hidden name="id"></s:hidden>
			<s:textfield name="content" label="留言内容" size="100"></s:textfield>
			<s:submit value="提交"></s:submit>
			<s:reset value="取消"></s:reset>

		</s:form>
	</body>
	<s:debug></s:debug>
</html>
