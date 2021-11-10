<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h2>상세보기</h2>
	<br/>
	<form action="update.do" method="post">
		<input type="hidden" name="id" value="${dto.id}">
		<table class="table table-striped table-hover">
			<tr>
				<th>id</th><td>${dto.id}</td>
				<th>password</th><td><input type="password" value="${dto.pwd }"name="pwd"></td>
			</tr>
			<tr>
				<th>name</th><td><input type="text" value="${dto.name }"name="name"></td>
				<th>email</th><td><input type="text" value="${dto.email }"name="email"></td>
			</tr>
			<tr>
				<th>joinDate</th><td colspan="3"><input type="text" value="${dto.joinDate }"name="joinDate"></td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="submit" value="맴버 수정">
					<input type="button" value="맴버 삭제" onclick ="location.href='delete.do?id=${dto.id}'">
					<input type="button" value="맴버 목록" onclick ="location.href='list.do'">
					<input type="button" value="맴버 등록" onclick ="location.href='insertForm.do'">
				</td>
			</tr>
		</table><br><br>
	</form>

</div>

</body>
</html>