<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

    <c:forEach items="${spittleList}" var="spittle">
        <li id="spittle_<c:out value='${spittle.id}'/>">
            <div class="spittleMessage">
                <c:out value="${spittle.message}" />
            </div>
            <div>
                <spen class="spittleTime">
                    <c:out value="${spittle.time}"></c:out>
                </spen>
                <spen class="spittleLocation">
                    <c:out value="${spittle.latitude}"></c:out>
                    <c:out value="${spittle.longitude}"></c:out>
                </spen>
            </div>
        </li>
    </c:forEach>

</html>
