<%@ page language="java" pageEncoding="UTF-8" %>
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
    <form action="<%=basePath%>user/login"
          method="post" name="theForm" id="theForm" novalidate="novalidate" onsubmit="validate()">
        <h2 id="hh">欢迎参加普贤行愿研修会金刚萨埵共修</h2>
        <table>
            <tr>
                <td width="30%">
                    用户名：
                </td>
                <td>
                    <input name="user.userName" type="text" width="10" id="userName" placeholder="用于登录的用户名"> </br>
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
            <tr>
                <td></td>
                <td align="right">
                    <input name="" type="submit" value="登录"></br>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>