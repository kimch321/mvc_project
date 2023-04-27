<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>사원 조회</title>
</head>
<body>
    <h1>사원 리스트</h1>
    <table border="1" width="750px" cellpadding="10px" cellspacing="0">
        <tr><th>사원번호</th><th>이름</th><th>이메일</th><th>직무번호</th><th>부서번호</th></tr>

        <c:forEach items="${emps}" var="emp">
            <tr><td>${emp.empno}</td>
                <td><a href="/view?empno=${emp.empno}">${emp.fname}</a></td>
                <td>${emp.email}</td><td>${emp.jobid}</td><td>${emp.deptno}</td></tr>
        </c:forEach>

    </table>
</body>
</html>
