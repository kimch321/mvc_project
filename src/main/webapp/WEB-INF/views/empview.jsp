<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>사원 상세정보</title>
</head>
<body>
  <h1>사원 상세정보</h1>
  <ul>
    <li>${emp.empno}</li>
    <li>${emp.fname}</li>
    <li>${emp.lname}</li>
    <li>${emp.email}</li>
    <li>${emp.phone}</li>
    <li>${emp.hdate}</li>
    <li>${emp.jobid}</li>
    <li>${emp.sal}</li>
    <li>${emp.comm}</li>
    <li>${emp.mgrid}</li>
    <li>${emp.deptno}</li>
  </ul>
  <p><a href="#">삭제하기</a></p>
  <p><a href="#">수정하기</a></p>
</body>
</html>
