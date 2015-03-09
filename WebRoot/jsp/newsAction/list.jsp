<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'list.jsp' starting page</title>
  </head>
  <body>
    <%@include file="/jsp/indexAction/top.jsp" %>
    您当前位置>：<s:if test="%{type == 0}">
    	新闻公告
    </s:if>
    <s:else>
    	业界动态
    </s:else>
    <table border="1" style="width:1080px;height:400px">
    	<s:iterator value="#newsList">
    		<tr>
    			<td>
    				<s:a action="news_show?id=%{id}">${title} &nbsp;....................&nbsp; ${publishTime}</s:a>
    			</td>
    		</tr>
    	</s:iterator>
    </table>
    	<!-- 分页信息 -->
		<%@include file="/WEB-INF/jsp/public/split.jspf" %>
		<script type="text/javascript">
			function gotoPageNum(currentPage){
				window.location.href="news_more.action?currentPage="+currentPage;
			}
		</script>
    <%@include file="/jsp/indexAction/bottom.jsp" %>
  </body>
</html>
