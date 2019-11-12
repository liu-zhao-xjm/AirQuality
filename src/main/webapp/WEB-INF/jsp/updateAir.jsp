<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lz
  Date: 2019/11/1
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>

<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/updateAri.css">
</head>
<body>
<div>


    <form method="GET" action="#" id="update_from">
        <input type="hidden" value="${qualityIndex.id}" name="id">
        <table>
            <tr>
                <th colspan="2"><h3>添加空气质量信息</h3></th>
            </tr>
            <tr>
                <th>检测区域</th>
                <td><select name="districtId" id="districtId">
                    <option value="0">请选择</option>
                    <c:forEach var="dislist" items="${districtList}">
                        <c:choose>
                            <c:when test="${dislist.id==qualityIndex.districtId}">
                                <option selected="selected" value="${dislist.id}">${dislist.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${dislist.id}">${dislist.name}</option>
                            </c:otherwise>
                        </c:choose>


                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <th>检测日期</th>
                <td><input type="text" name="monitorTime" id="monitorTime" value="${qualityIndex.monitorTime}"></td>
            </tr>
            <tr>
                <th>PM10值:</th>
                <td><input type="text" name="pm10" id="pm10" value="${qualityIndex.pm10}"></td>
            </tr>
            <tr>
                <th>PM2.5值:</th>
                <td><input type="text" name="pm" id="pm" value="${qualityIndex.pm}"></td>
            </tr>
            <tr>
                <th>检测站:</th>
                <td><input type="text" name="monitoringStation" id="monitoringStation"
                           value="${qualityIndex.monitoringStation}"></td>
            </tr>
            <tr>
                <th>最后的修改时间:
                </th>
                <td>${qualityIndex.lastModifyTime}</td>
            </tr>
            <tr>
                <th colspan="2">
                    <input type="submit" value="更新" id="updateAir">
                    <input type="button" value="删除" id="deleteAir">
                    <input type="button" value="返回" onclick="backtrack()">
                </th>
            </tr>
        </table>
    </form>
</div>
<script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/static/js/updateAir.js"></script>
</body>
</html>
