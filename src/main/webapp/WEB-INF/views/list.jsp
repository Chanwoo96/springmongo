<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table">
  <tr>
    <th>번호</th>
    <th>작성자</th>
    <th>내용</th>
    <th>날시</th>
    <th>날짜</th>
  </tr>
	<c:forEach items="${list}" var="vo" varStatus="status">
	<tr>
	<td>${status.count}</td>
	<td>${vo.name}</td>
	<td><a href="one.memo?_id=${vo._id}">${vo.content}</a></td>
	<td>${vo.weather}</td>
	<td>${vo.date}</td>
	</tr>
	</c:forEach> 
</table>
