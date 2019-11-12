<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lz
  Date: 2019/11/1
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/index.css">
</head>
<body>
<div>

    <form action="${pageContext.request.contextPath}/air/pagelist.html" method="get">
        <input type="hidden" name="pageIndex" value="1">
        <table>
            <tr>
                <th colspan="6"><h3>空气质量检测信息库</h3></th>
            </tr>
            <tr>
                <td colspan="4">按区域查询<select name="districtId">
                    <option value="0">不限</option>
                    <c:forEach var="dislist" items="${districtList}">
                        <option value="${dislist.id}">${dislist.name}</option>
                    </c:forEach>
                </select><input type="submit" value="查找"></td>
                <td colspan="2"><a href="${pageContext.request.contextPath}/air/openAdd.html">添加空气质量信息</a></td>
            </tr>
            <s:choose>
                <s:when test="${airQualityIndices.size()>0}">
                    <tr>
                        <th>序号</th>
                        <th>区域</th>
                        <th>检测时间</th>
                        <th>PM10数据</th>
                        <th>PM2.5数据</th>
                        <th>监测站</th>
                    </tr>
                    <s:forEach var="air" items="${airQualityIndices}" varStatus="status">
                        <tr>
                            <td>${status.index+1}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/air/openupdate.html?id=${air.id}">${air.name}</a>
                            </td>
                            <td>${air.monitorTime}</td>
                            <td>${air.pm10}</td>
                            <td>${air.pm}</td>
                            <td>${air.monitoringStation}</td>
                        </tr>
                    </s:forEach>
                </s:when>
                <s:otherwise>
                    <tr>
                        <th colspan="6">抱歉站无数据</th>
                    </tr>
                </s:otherwise>
            </s:choose>
            <tr>
                <th colspan="6">
                    <a href="${pageContext.request.contextPath}/air/pagelist.html?pageIndex=1">首页 |</a>
                    <a href="${pageContext.request.contextPath}/air/pagelist.html?pageIndex=${pages.currentPageNo-1}"> 《
                        上一页
                        |</a>

                    <c:if test="${pages.currentPageNo>=pages.totalPageCount}">
                        <a href="${pageContext.request.contextPath}/air/pagelist.html?pageIndex=${pages.totalPageCount}">下一页
                            》|</a>
                    </c:if>
                    <c:if test="${pages.currentPageNo<pages.totalPageCount}">
                        <a href="${pageContext.request.contextPath}/air/pagelist.html?pageIndex=${pages.currentPageNo+1}">下一页
                            》|</a>
                    </c:if>
                    <a href="${pageContext.request.contextPath}/air/pagelist.html?pageIndex=${pages.totalPageCount }">
                        尾页 </a>
                    <span>第${pages.currentPageNo}页/共${pages.totalPageCount }页(${pages.totalCount}条)</span>
                </th>
            </tr>
        </table>
    </form>
</div>
<script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/static/js/index.js"></script>
</body>
</html>
