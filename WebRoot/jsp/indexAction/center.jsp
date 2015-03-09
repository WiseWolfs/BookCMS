<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>首页</title>
  </head>
  
  <body>
  <label>
			<div align="center" >
				<input name="textfield" type="text"
					style="height: 40px; width: 200px" />
				<input name="Submit" type="button"
					style="height: 40px; width: 100px"
					onclick="window.location.href=&quot;搜索列表.html&quot;" value="搜索" />
			</div>
		</label>
		<table width="1077" height="202" border="1">
			<tr>
				<td width="745" height="154" rowspan="2">
					<a id="showhref" href="#" onclick="testOpen()"><img src="uploadImage/${advertisementList[0].imageName}" width="745" height="200" id="showpic" />
					</a>
				</td>
				<td width="151" height="30">
					新闻公告<s:a action="news_more?type=0">more..</s:a>
				</td>
					<td width="159">
					业界动态 <s:a action="news_more?type=1">more..</s:a>
				</td>
			</tr>
			<tr>
				<td height="164">
					<table>
						<s:iterator value="#annoList">
							<tr>
								<td>
									<s:a action="news_show?id=%{id}">${title}</s:a>
								</td>
							</tr>
						</s:iterator>
					</table>
				
				</td>
				<td width="159">
					<table>
						<s:iterator value="#fraList">
							<tr>
								<td>
									<s:a action="news_show?id=%{id}">${title}</s:a>
								</td>
							</tr>
						</s:iterator>
					</table>
				</td>
			</tr>
		</table>

		<table width="1078" height="330" border="1">
			<tr>
				<td height="33" colspan="5">
					购买专区
				</td>
				<td colspan="2">
					交换专区
				</td>
				<td colspan="2">
					捐赠专区
				</td>
				<td width="322">
					电子资源
				</td>
			</tr>
			<tr>
				<td width="199" height="141">
					<table>
						<s:iterator value="#buyChannel">
							<tr>
								<td>${profile}</td>
							</tr>
						</s:iterator>
					</table>
				</td>
				<td colspan="4">
					<table>
						<s:iterator value="#buyChannel">
							<tr>
								<td><img src="uploadImage/${imageName}" style="width:100px;height:100px"/></td>
							</tr>
						</s:iterator>
					</table>
				</td>
				<td width="85">
					<table>
						<s:iterator value="#swapChannel">
							<tr>
								<td>${profile}</td>
							</tr>
						</s:iterator>
					</table>
				</td>
				<td width="88">
					<table>
						<s:iterator value="#swapChannel">
							<tr>
								<td><img src="uploadImage/${imageName}" style="width:100px;height:100px"/></td>
							</tr>
						</s:iterator>
					</table>
				</td>
				<td width="82">
					<table>
						<s:iterator value="#contriChannel">
							<tr>
								<td>${profile}</td>
							</tr>
						</s:iterator>
					</table>
				</td>
				<td width="85">
					<table>
						<s:iterator value="#contriChannel">
							<tr>
								<td><img src="uploadImage/${imageName}" style="width:100px;height:100px"/></td>
							</tr>
						</s:iterator>
					</table>
				</td>
				<td height="138" valign="bottom">
					电子资源 more..
				</td>
			</tr>
			<tr>
				<td height="119" colspan="5">
					<p>
						部分商品展示（） 《》
					</p>
					<p>
						[购买商品图片]
					</p>
					<p>
						名字：
					</p>
					<p>
						价格
					</p>
				</td>
				<td colspan="2">
					&nbsp;
				</td>
				<td colspan="2">
					&nbsp;
				</td>
				<td height="119">
					试题
				</td>
			</tr>
			<tr>
				<td height="28" colspan="5">
					more..
				</td>
				<td colspan="2">
					more..
				</td>
				<td colspan="2">
					more..
				</td>
				<td>
					more..
				</td>
			</tr>
		</table>
		<table width="1078" height="236" border="1">
			<tr>
				<td height="30" colspan="2">
					留言板 <a href="message_more.action">more..</a>
				</td>
			</tr>
			<tr>
				<td width="264" align="right" valign="bottom">
					<table>
						<s:iterator value="#messageList">
							<tr>
								<td>${content}</td>
							</tr>
						</s:iterator>
					</table>
					我要留言
				</td>
				<td width="798">
					爱心榜
				</td>
			</tr>
		</table>
  </body>
</html>
