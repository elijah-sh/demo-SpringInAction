<!-- 欢迎应用的用户  首页
并提供了两个链接：一个是查看Spittle列表，另一个是在应用中进行注册。
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Spittr</title>
        <link rel="stylesheet" type="text/css" value="">
    </head>
    <body>
        <h1>Welcome to Spittr</h1>
<h2> index.jsp </h2>
        <a href="<c:url value="/spittles" /> ">Spittles </a> |
        <a href="<c:url value="/spitter/register" /> ">Register </a>
        <br/><br/>
    <c:out value="${spittle.message}" />
    <c:out value="${spittle.time}" />
    <br/>

    </body>
</html>