<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
  <head>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/pageCommon.css" />
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/forum.css" />
  </head>
  
  <body>
  <table border="1">
  <tr>
  	<th>昵称</th>
  	<th>登录名</th>
  	<th>联系方式</th>
  	<th>QQ号</th>
  	<th>邮箱</th>
  	<th>IP地址</th>
  	<th>岗位</th>
  	<th>图像预览</th>
  	<th>操作</th>
  	
  </tr>
  <!-- 角色没有添加 -->
  <s:a action="user_addUI">添加用户</s:a>
  	<s:iterator value="#userList">
  		<tr>
	  		<td><s:property value="name"/></td>
	  		<td><s:property value="loginName"/></td>
	  		<td><s:property value="phone"/></td>
	  		<td><s:property value="qq"/></td>
	  		<td><s:property value="email"/></td>
	  		<td><s:property value="ipAddr"/></td>
	  		<td><s:property value="role.name"/></td>
	  		<td><img src="uploadImage/<s:property value="imageName"/>" height="100" width="100"/></td>
	  		<td><s:a action="user_delete?id=%{id}">删除</s:a>,
	  			<s:a action="user_updateUI?id=%{id}">修改</s:a>,
	  			<s:a action="user_initPass?id=%{id}">初始化密码</s:a>
	  			</td>
  		</tr>
  	</s:iterator>
  
  	</table>
  		<!-- 分页信息 -->
  	<%@include file="/WEB-INF/jsp/public/split.jspf" %>
  	
  	<script type="text/javascript">
  		function gotoPageNum(currentPage){
				window.location.href="user_list.action?currentPage="+currentPage;

  	  		}
  	</script>
  </body>
</html>
