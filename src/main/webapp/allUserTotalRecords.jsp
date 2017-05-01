<%--
  Created by IntelliJ IDEA.
  User: 周炜
  Date: 2017/3/30
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="topFile.tag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>共修统计</title>
    <meta name="viewport" content="width=device-width,inital-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
</head>
<body>
<div align="center">
           <c:if test="${!empty theDayRecords[0] && !empty allUserTotalRecords}">
            <h2 id="hh">截止${theDayRecords[0].theDate}共修统计</h2>
            <table border="1">
                <tr>
                    <td>排名</td>
                    <td>姓名</td>
                    <td>百字明</td>
                    <td>百字明进度</td>
                    <td>心咒</td>
                    <td>心咒进度</td>
                </tr>
                <c:forEach items="${allUserTotalRecords}" var="userRecord" varStatus="index">
                    <tr>
                        <td>${index.count}</td>
                        <td>${userRecord['user'].realName}</td>
                        <td>${userRecord['totalBZM']}</td>
                        <td><fmt:formatNumber type="percent" value="${userRecord['totalBZM']/10000.0}" maxFractionDigits="4"/></td>
                        <td>${userRecord['totalXZ']}</td>
                        <td><fmt:formatNumber type="percent" value="${userRecord['totalXZ']/10000.0}" maxFractionDigits="4"/></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

</div>
</body>
</html>
