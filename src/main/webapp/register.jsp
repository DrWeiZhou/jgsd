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
        $(function () {
                $("table .dingke").hide();
        })
        function changeRecordType(type) {
            if (type == 1) {
                $("table .dingke").show();
            }
            if (type == 2) {
//                alert('hi');
                $("table .dingke").hide();
            }
        }
        function validate(){
            if($("#password").val() == $("#repassword").val()){
                return true;
            }
            else{
                alert("两次输入的密码不一致!");
                return false;
            }
        }

    </script>
</head>
<body>
<div align="center">
    <form action="<%=basePath%>user/add"
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
                <td>
                    密码确认：
                </td>
                <td>
                    <input name="repassword" type="password"
                           id="repassword" placeholder="请再次输入密码"></br>
                </td>
            </tr>
            <tr>
                <td width="30%">
                    真名：
                </td>
                <td>
                    <input name="user.realName" type="text" width="10" id="realName" placeholder="用于显示统计的真名"> </br>
                </td>
            </tr>
            <%--                <tr>
                                <td>共修类型</td>
                                <td>
                                    <select>
                                        <option value="1">金刚萨埵心咒及百字明</option>
                                    </select>
                                </td>
                            </tr>--%>
            <tr>
                <td>记录类型</td>
                <td>
                    <input name="user.recordType" type="radio" value="1" onclick="changeRecordType(1)" />定课
                    <input name="user.recordType" type="radio" onclick="changeRecordType(2)" value="2" checked />非定课
                </td>
            </tr>
            <tr class="dingke">
                <td>
                    心咒
                </td>
                <td>
                    <input name="user.dailyJgsdXZ" type="text" placeholder="选择定课并输入数目">
                </td>
            </tr>
            <tr class="dingke">
                <td>
                    百字明
                </td>
                <td>
                    <input name="user.dailyJgsdBZM" type="text" placeholder="选择定课并输入数目">
                </td>
            </tr>
            <tr>
                <td></td>
                <td align="right">
                    <input name="" type="submit" value="报名参加"></br>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>