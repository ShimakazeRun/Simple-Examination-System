<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!--菜单栏-->
<div class="col-md-2">
    <ul class="nav nav-pills nav-stacked" id="nav">
        <li><a href="/student/showCourse">所有课程<span class="badge pull-right"><%=request.getParameter("showCourse")%></span></a></li>
        <li><a href="/student/selectedCourse">已选课程<span class="badge pull-right"><%=request.getParameter("selectedCourse")%></span></a></li>
        <li><a href="/student/overCourse">已修课程<span class="badge pull-right"><%=request.getParameter("overCourse")%></span></a></li>
        <li><a href="/student/passwordRest">修改密码<span class="glyphicon glyphicon-pencil pull-right"></span></a></li>
        <li><a href="/logout">退出系统<span class="glyphicon glyphicon-log-out pull-right"></span></a></li>
        <li class="disabled"><a href="#">未完成</a></li>
    </ul>
</div>