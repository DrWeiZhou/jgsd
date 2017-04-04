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
        <c:if test="${!empty theDayRecords[0]}">
        <h2 id="hh">${theDayRecords[0].theDate}功课记录</h2>
        <table border="1">
            <tr>
                <td>姓名</td>
                <td>百字明</td>
                <td>心咒</td>
            </tr>
            <c:forEach items="${theDayRecords}" var="record" >
                <tr>
                    <td>${record.user.userName}</td>
                    <td>${record.dailyJgsdBZM}</td>
                    <td>${record.dailyJgsdXZ}</td>
                </tr>
            </c:forEach>
        </table>
        </c:if>
    <a href="<%=basePath%>home">返回</a>
</div>

</body>
</html>