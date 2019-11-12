<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lz
  Date: 2019/11/1
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/addAri.css">
</head>
<body>
<div>


    <form method="POST" action="#" id="login_form">
        <table>
            <tr>
                <th colspan="2"><h3>添加空气质量信息</h3></th>
            </tr>
            <tr>
                <th>检测区域</th>
                <td><select name="districtId" id="districtId">
                    <option value="0">请选择</option>
                    <c:forEach var="dislist" items="${districtList}">
                        <option value="${dislist.id}">${dislist.name}</option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <th>检测日期</th>
                <td><input type="text" name="monitorTime" id="monitorTime"></td>
            </tr>
            <tr>
                <th>PM10值:</th>
                <td><input type="text" name="pm10" id="pm10"></td>
            </tr>
            <tr>
                <th>PM2.5值:</th>
                <td><input type="text" name="pm" id="pm"></td>
            </tr>
            <tr>
                <th>检测站:</th>
                <td><input type="text" name="monitoringStation" id="monitoringStation"></td>
            </tr>
            <tr>
                <th colspan="2">
                    <input type="button" value="保存" id="save">
                    <input type="reset" value="重置">
                    <input type="button" value="返回" onclick="backtrack()">
                </th>
            </tr>
        </table>
    </form>
</div>
<script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/static/js/addAir.js"></script>
</body>
</html>
