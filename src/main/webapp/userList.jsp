<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="topFile.tag" %>
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

</head>
<body>
<div align="center">
        <h2 id="hh">共修成员列表</h2>
        <table border="1">
            <tr>
                <td>序号</td>
                <td>姓名</td>
            </tr>
            <c:forEach items="${users}" var="user" varStatus="status" >
                <tr>
                    <td>${status.count}</td>
                    <td>${user.realName}</td>
                </tr>
            </c:forEach>
        </table>
    <a href="<%=basePath%>home">返回</a>
</div>

</body>
</html>