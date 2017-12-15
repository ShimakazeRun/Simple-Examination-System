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
                            <h1 class="col-md-5">课程列表</h1>
                            <form class="col-md-5" role="form" style="margin: 20px 0 10px 0;" action="/student/searchCourse" id="from1" method="post">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="请输入课程名" name="findByName">
                                    <span class="input-group-addon btn" onclick="document.getElementById('from1').submit" id="sub">搜索</span>
                                </div>
                            </form>
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
                        <c:forEach items="${courseList}" var="items">
                            <tr>
                                <td>${items.courseid}</td>
                                <td>${items.coursename}</td>
                                <td>${items.teacherid}</td>
                                <td>${items.coursetime}</td>
                                <td>${items.classroom}</td>
                                <td>${items.courseweek}</td>
                                <td>${items.coursetype}</td>
                                <td>${items.score}</td>
                                <td>
                                    <button class="btn btn-default btn-xs btn-info" onclick="location.href = '/student/selectCourse?id=${items.courseid}'">选课</button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="panel-footer">
                        <c:if test="${pagingVO != null}">
                            <nav style="text-align: center">
                                <ul class="pagination">
                                    <li><a href="/student/showCourse?page=${pagingVO.lastPageNo}">上一页</a></li>
                                    <li class="active"><a href="">${pagingVO.currentPageNo}</a></li>
                                    <c:if test="${pagingVO.currentPageNo + 1 <= pagingVO.totalCount}">
                                        <li><a href="/student/showCourse?page=${pagingVO.currentPageNo + 1}">${pagingVO.currentPageNo + 1}</a></li>
                                    </c:if>
                                    <c:if test="${pagingVO.currentPageNo + 2 <= pagingVO.totalCount}">
                                        <li><a href="/student/showCourse?page=${pagingVO.currentPageNo + 2}">${pagingVO.currentPageNo + 2}</a></li>
                                    </c:if>
                                    <c:if test="${pagingVO.currentPageNo + 3 <= pagingVO.totalCount}">
                                        <li><a href="/student/showCourse?page=${pagingVO.currentPageNo + 3}">${pagingVO.currentPageNo + 3}</a></li>
                                    </c:if>
                                    <c:if test="${pagingVO.currentPageNo + 4 <= pagingVO.totalCount}">
                                        <li><a href="/student/showCourse?page=${pagingVO.currentPageNo + 4}">${pagingVO.currentPageNo + 4}</a></li>
                                    </c:if>
                                    <li><a href="/student/showCourse?page=${pagingVO.totalCount}">最后一页</a></li>
                                </ul>
                            </nav>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container" id="footer">
        <div class="row">
            <div class="col-md-12"></div>
        </div>
    </div>
</body>
    <script type="text/javascript">
        $("#sub").click(function () {
            $("#from1").submit();
        })
    </script>
</html>