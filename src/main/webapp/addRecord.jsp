<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width,inital-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <title>普贤行愿共修</title>
    <!-- <link href="resources/style/system/front/wap/css/style.css" rel="stylesheet" type="text/css">
     -->
    <%@include file="topFile.tag" %>
    <script>

     </script>
</head>
<body>
<div align="center">
    <form action="<%=basePath%>record/add"
          method="post" name="theForm" id="theForm" novalidate="novalidate" onsubmit="validate()">
        <input type="hidden" name="user.userId" value="${user.userId}">
        <h2 id="hh">功课记录(非定课)</h2>
        <table>
            <tr>
                <td width="30%">
                    用户名：
                </td>
                <td>
                        <input name="user.userName" value="${user.userName}" type="text" width="10" id="userName" placeholder="用于登录的用户名"> </br>
                </td>
            </tr>
            <tr>
                <td>
                    密码：
                </td>
                <td>
                    <input name="user.password" type="password"
                           id="password" placeholder="请输入密码"></br>
                </td>
            </tr>
            <tr >
                <td>
                    心咒
                </td>
                <td>
                    <input name="record.dailyJgsdXZ" value="${record.dailyJgsdXZ}" type="text" placeholder="纯整数数字,没有填0">
                </td>
            </tr>
            <tr>
                <td>
                    百字明
                </td>
                <td>
                    <input name="record.dailyJgsdBZM" value="${record.dailyJgsdBZM}" type="text" placeholder="纯整数数字,没有填0">
                </td>
            </tr>
            <tr>
                <td></td>
                <td align="right">
                        <input name="" type="submit" value="上报记录"></br>
                </td>
            </tr>
        </table>
        <div align="left">
        说明：<br/>
        1. 非定课每天12点2分之后前至第二天12点之前上报的信息为当日的记录，如果在一天内多次上报，则以最后上报的信息为记录。<br/>
        2. 定课不用上报，系统在每天的12点1分会自动生成昨日的功课记录（如果用户没有自行上报的话）。可以通过信息管理修改定课信息，系统会依据修改的信息继续生成新的功课记录。<br/>
        3. 定课也可以通过本界面上报，则系统依据用户上报自己的数量生成当天的记录，今后的记录仍然会由系统自动生成。<br/>
        </div>
    </form>
</div>

</body>
</html>