<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>课程信息显示</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入bootstrap -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <!-- 引入JQuery  bootstrap.js-->
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
</head>
<body>
    <!--顶栏-->
    <jsp:include page="top.jsp"/>
    <!--中间主体-->
    <div class="container" id="content">
        <div class="row">
            <jsp:include page="menu.jsp" flush="true">
                <jsp:param name="showCourse" value="${amount.courseAmount}"/>
                <jsp:param name="selectedCourse" value="${amount.selectedCourseAmount}"/>
                <jsp:param name="overCourse" value="${amount.overCourseAmount}"/>
            </jsp:include>
            <div class="col-md-10">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="row">
                            <h1 class="col-md-5">已选课程</h1>
                        </div>
                    </div>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>课程号</th>
                                <th>课程名称</th>
                                <th>授课老师编号</th>
                                <th>上课时间</th>
                                <th>上课地点</th>
                                <th>周数</th>
                                <th>课程类型</th>
                                <th>学分</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${selectedCourseList}" var="items">
                            <!--输出还没修完的课程-->
                            <c:if test="${!items.over}">
                                <tr>
                                    <td>${items.courseCustom.courseid}</td>
                                    <td>${items.courseCustom.coursename}</td>
                                    <td>${items.courseCustom.teacherid}</td>
                                    <td>${items.courseCustom.coursetime}</td>
                                    <td>${items.courseCustom.classroom}</td>
                                    <td>${items.courseCustom.courseweek}</td>
                                    <td>${items.courseCustom.coursetype}</td>
                                    <td>${items.courseCustom.score}</td>
                                    <td>
                                        <button class="btn btn-default btn-sx btn-info" onclick="location.href='/student/outCourse?id=${items.courseid}'">退课</button>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>